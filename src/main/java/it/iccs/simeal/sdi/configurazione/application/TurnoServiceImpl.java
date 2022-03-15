package it.iccs.simeal.sdi.configurazione.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.iccs.simeal.sdi.configurazione.application.mapper.TurnoModelMapper;
import it.iccs.simeal.sdi.configurazione.application.model.TurnoModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.ClasseComposizioneAnnoService;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.TurnoService;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneAnnoCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneAnnoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TurnoCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TurnoCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TurnoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TurnoUpdateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence.TurnoPersistence;
import it.iccs.simeal.sdi.configurazione.web.rest.errors.InternalServerErrorException;
import it.iccs.simeal.sdi.configurazione.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TurnoServiceImpl implements TurnoService {

	@Autowired
	private TurnoModelMapper turnoModelMapper;
	
	@Autowired
	private TurnoPersistence turnoPersistence;

	@Autowired
	private ClasseComposizioneAnnoService classeComposizioneAnnoService;
	
	@Override
	public TurnoDTO create(TurnoCreateDTO dto) {
		TurnoDTO turnoDTO = turnoModelMapper.fromCreateDto(dto);
        TurnoModel turnoModel = turnoModelMapper.toModel(turnoDTO);
        TurnoModel model = turnoPersistence.save(turnoModel);
        return turnoModelMapper.toDto(model);
	}

	@Override
	public List<TurnoDTO> findByIds(List<UUID> ids) {
		TurnoCriteria criteria = new TurnoCriteria().setId(ids);
		Page<TurnoModel> models = turnoPersistence.search(criteria, PageRequest.ofSize(10));
		return models.map(model -> turnoModelMapper.toDto(model)).getContent();
	}

	@Override
	public Page<TurnoDTO> search(TurnoCriteria criteria, Pageable pageRequest) {
		Page<TurnoModel> models = turnoPersistence.search(criteria, pageRequest);
		return models.map(model -> this.turnoModelMapper.toDto(model));
	}

	@Override
	public TurnoDTO update(TurnoUpdateDTO dto) {
		TurnoDTO turnoDTO = turnoModelMapper.fromUpdateDto(dto);
        this.checkTurnoExists(turnoDTO.getId());		
        TurnoModel turnoModel = turnoModelMapper.toModel(turnoDTO);
        turnoPersistence.save(turnoModel);
        
        TurnoCriteria criteria = new TurnoCriteria().setId(Collections.singletonList(turnoDTO.getId()));
		Page<TurnoModel> models = turnoPersistence.search(criteria, PageRequest.ofSize(1));
		TurnoModel model = models
				.getContent()
				.stream()
                .findAny()
                .orElse(null);
        return turnoModelMapper.toDto(model);
	}
	
	@Override
	public void delete(UUID id) {
		this.checkTurnoExists(id);
		this.checkInUse(id);
		TurnoDTO turnoDTO = this.findByIds(Collections.singletonList(id))
				.stream()
				.findAny()
				.orElse(null);
		turnoDTO.setFlagElimina((short)1);
		
		TurnoModel turnoModel = turnoModelMapper.toModel(turnoDTO);
        turnoPersistence.save(turnoModel);
	}
	
	private void checkTurnoExists(UUID id) {
		TurnoCriteria criteria = new TurnoCriteria().setId(Collections.singletonList(id));
		if (turnoPersistence.search(criteria, PageRequest.ofSize(10)).isEmpty()) {
			log.warn("Turno {} not found", id);
			throw new NotFoundException(String.format("Turno %s not found", id));
		}
	}
	
	private void checkInUse(UUID id) {
		ClasseComposizioneAnnoCriteria criteria = new ClasseComposizioneAnnoCriteria().setTurno(Collections.singletonList(id));
		List<ClasseComposizioneAnnoDTO> found = classeComposizioneAnnoService.search(criteria, PageRequest.ofSize(10)).getContent();
		if (!found.isEmpty()) {
            log.warn("Turno {} referenced in {} ClasseComposizioneAnno", id, found.size());
            throw new InternalServerErrorException(String.format("Turno %s referenced in %d ClasseComposizioneAnno", id, found.size()));
        }
	}

}