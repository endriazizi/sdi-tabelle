package it.iccs.simeal.sdi.tabelle.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.iccs.simeal.sdi.tabelle.application.mapper.GiroModelMapper;
import it.iccs.simeal.sdi.tabelle.application.model.GiroModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.GiroService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.TurnoService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioGiroCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.GiroCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.GiroDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.GiroUpdateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TurnoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TurnoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.GiroPersistence;
import it.iccs.simeal.sdi.tabelle.web.rest.errors.InternalServerErrorException;
import it.iccs.simeal.sdi.tabelle.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class GiroServiceImpl implements GiroService {

	@Autowired
	private GiroModelMapper giroModelMapper;
	
	@Autowired
	private GiroPersistence giroPersistence;
	
	@Autowired
	private TurnoService servizioTurnoService;
	
	@Override
	public GiroDTO create(ServizioGiroCreateDTO dto) {
		GiroDTO giroDTO = giroModelMapper.fromCreateDto(dto);
        GiroModel giroModel = giroModelMapper.toModel(giroDTO);
        GiroModel model = giroPersistence.save(giroModel);
        return giroModelMapper.toDto(model);
	}

	@Override
	public List<GiroDTO> findByIds(List<UUID> ids) {
		GiroCriteria criteria = new GiroCriteria().setId(ids);
		Page<GiroModel> models = giroPersistence.search(criteria, PageRequest.ofSize(10));
		return models.map(model -> this.giroModelMapper.toDto(model)).getContent();
	}

	@Override
	public Page<GiroDTO> search(GiroCriteria criteria, Pageable pageRequest) {
		Page<GiroModel> models = giroPersistence.search(criteria, pageRequest);
		return models.map(model -> this.giroModelMapper.toDto(model));
	}

	@Override
	public GiroDTO update(GiroUpdateDTO dto) {
		GiroDTO giroDTO = giroModelMapper.fromUpdateDto(dto);
        this.checkGiroExists(giroDTO.getId());		
        GiroModel giroModel = giroModelMapper.toModel(giroDTO);
        giroPersistence.save(giroModel);
        
        GiroCriteria criteria = new GiroCriteria().setId(Collections.singletonList(giroDTO.getId()));
		Page<GiroModel> models = giroPersistence.search(criteria, PageRequest.ofSize(10));
        GiroModel model = models
        		.getContent()
                .stream()
                .findAny()
                .orElse(null);
        return giroModelMapper.toDto(model);
	}
	
	@Override
	public void delete(UUID id) {
		this.checkGiroExists(id);
		this.checkInUse(id);
		GiroDTO giroDTO = this.findByIds(Collections.singletonList(id))
				.stream()
				.findAny()
				.orElse(null);
		giroDTO.setFlagElimina((short)1);
		
		GiroModel giroModel = giroModelMapper.toModel(giroDTO);
		giroPersistence.save(giroModel);
	}
	
	private void checkGiroExists(UUID id) {
		GiroCriteria criteria = new GiroCriteria().setId(Collections.singletonList(id));
		if (giroPersistence.search(criteria, PageRequest.ofSize(10)).isEmpty()) {
			log.warn("ServizioGiro {} not found", id);
			throw new NotFoundException(String.format("Giro %s not found", id));
		}
	}
	
	private void checkInUse(UUID id) {
		TurnoCriteria criteria = new TurnoCriteria().setGiro(Collections.singletonList(id));
		List<TurnoDTO> found = servizioTurnoService.search(criteria, PageRequest.ofSize(10)).getContent();
		if (!found.isEmpty()) {
			log.warn("Giro {} referenced in {} Turno", id, found.size());
	        throw new InternalServerErrorException(String.format("Giro %s referenced in %d Turno", id, found.size()));
	    }
	}

}
