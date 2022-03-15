package it.iccs.simeal.sdi.configurazione.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.iccs.simeal.sdi.configurazione.application.mapper.SezioneModelMapper;
import it.iccs.simeal.sdi.configurazione.application.model.SezioneModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.ClasseComposizioneService;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.SezioneService;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.SezioneCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.SezioneCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.SezioneDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.SezioneUpdateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence.SezionePersistence;
import it.iccs.simeal.sdi.configurazione.web.rest.errors.InternalServerErrorException;
import it.iccs.simeal.sdi.configurazione.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class SezioneServiceImpl implements SezioneService {

	@Autowired
	private SezioneModelMapper sezioneModelMapper;
	
	@Autowired
	private SezionePersistence sezionePersistence;
	
	@Autowired
	private ClasseComposizioneService classeComposizioneService;
	
	@Override
	public SezioneDTO create(SezioneCreateDTO dto) {
		SezioneDTO sezioneDTO = sezioneModelMapper.fromCreateDto(dto);
        SezioneModel sezioneModel = sezioneModelMapper.toModel(sezioneDTO);
        SezioneModel model = sezionePersistence.save(sezioneModel);
        return sezioneModelMapper.toDto(model);
	}

	@Override
	public List<SezioneDTO> findByIds(List<UUID> ids) {
		SezioneCriteria criteria = new SezioneCriteria().setId(ids);
		Page<SezioneModel> models = sezionePersistence.search(criteria, PageRequest.ofSize(10));
		return models.map(model -> this.sezioneModelMapper.toDto(model)).getContent();
//		List<SezioneModel> models = sezionePersistence.findByIds(ids);
//		return sezioneModelMapper.toDto(models);
	}

	@Override
	public Page<SezioneDTO> search(SezioneCriteria criteria, Pageable pageRequest) {
		Page<SezioneModel> models = sezionePersistence.search(criteria, pageRequest);
		return models.map(model -> this.sezioneModelMapper.toDto(model));
	}

	@Override
	public SezioneDTO update(SezioneUpdateDTO dto) {
		SezioneDTO sezioneDTO = sezioneModelMapper.fromUpdateDto(dto);
        this.checkSezioneExists(sezioneDTO.getId());		
        SezioneModel sezioneModel = sezioneModelMapper.toModel(sezioneDTO);
        sezionePersistence.save(sezioneModel);
        
//      SezioneModel model = sezionePersistence.findByIds(Collections.singletonList(sezioneDTO.getId()))
//              .stream()
//              .findAny()
//              .orElse(null);
        
        SezioneCriteria criteria = new SezioneCriteria().setId(Collections.singletonList(sezioneDTO.getId()));
		Page<SezioneModel> models = sezionePersistence.search(criteria, PageRequest.ofSize(1));
		SezioneModel model = models
				.getContent()
				.stream()
                .findAny()
                .orElse(null);
        return sezioneModelMapper.toDto(model);
	}
	
	@Override
	public void delete(UUID id) {
		this.checkSezioneExists(id);
		this.checkInUse(id);
		SezioneDTO sezioneDTO = this.findByIds(Collections.singletonList(id))
				.stream()
				.findAny()
				.orElse(null);
		sezioneDTO.setFlagElimina((short)1);
		
		SezioneModel sezioneModel = sezioneModelMapper.toModel(sezioneDTO);
        sezionePersistence.save(sezioneModel);
        
//        SezioneModel model = sezionePersistence.findByIds(Collections.singletonList(sezioneDTO.getId()))
//                .stream()
//                .findAny()
//                .orElse(null);
	}
	
	// CONTROLLA CHE ESISTA E CHE NON SIA "ELIMINATO"
	private void checkSezioneExists(UUID id) {
		SezioneCriteria criteria = new SezioneCriteria().setId(Collections.singletonList(id));
		if (sezionePersistence.search(criteria, PageRequest.ofSize(10)).isEmpty()) {
			log.warn("Sezione {} not found", id);
			throw new NotFoundException(String.format("Sezione %s not found", id));
		}
//		if (sezionePersistence.findByIds(Collections.singletonList(id)).isEmpty()) {
//			log.warn("Sezione {} not found", id);
//			throw new NotFoundException(String.format("Sezione %s not found", id));
//		}
	}
	
	// TODO check che in classeComposizione non ci sia il flagElimina
	// in teoria dopo aver aggiornato le Specification dovrebbe fare in automatico se si usa il search()
	private void checkInUse(UUID id) {
		ClasseComposizioneCriteria criteria = new ClasseComposizioneCriteria().setSezione(Collections.singletonList(id));
		List<ClasseComposizioneDTO> found = classeComposizioneService.search(criteria, PageRequest.ofSize(10)).getContent();
		if (!found.isEmpty()) {
            log.warn("Sezione {} referenced in {} ClasseComposizione", id, found.size());
            throw new InternalServerErrorException(String.format("Sezione %s referenced in %d ClasseComposizione", id, found.size()));
        }
	}

}
