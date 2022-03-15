package it.iccs.simeal.sdi.configurazione.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.iccs.simeal.sdi.configurazione.application.mapper.ClasseComposizioneModelMapper;
import it.iccs.simeal.sdi.configurazione.application.model.ClasseComposizioneModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.ClasseComposizioneAnnoService;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.ClasseComposizioneService;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneAnnoCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneAnnoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneUpdateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence.ClasseComposizionePersistence;
import it.iccs.simeal.sdi.configurazione.web.rest.errors.InternalServerErrorException;
import it.iccs.simeal.sdi.configurazione.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClasseComposizioneServiceImpl implements ClasseComposizioneService {

	@Autowired
	private ClasseComposizioneModelMapper classeComposizioneModelMapper;
	
	@Autowired
	private ClasseComposizionePersistence classeComposizionePersistence;
	
	@Autowired
	private ClasseComposizioneAnnoService classeComposizioneAnnoService;
	
	@Override
	public ClasseComposizioneDTO create(ClasseComposizioneCreateDTO dto) {
		ClasseComposizioneDTO classeComposizioneDTO = classeComposizioneModelMapper.fromCreateDto(dto);
        ClasseComposizioneModel classeComposizioneModel = classeComposizioneModelMapper.toModel(classeComposizioneDTO);
        ClasseComposizioneModel model = classeComposizionePersistence.save(classeComposizioneModel);
        return classeComposizioneModelMapper.toDto(model);
	}

	@Override
	public List<ClasseComposizioneDTO> findByIds(List<UUID> ids) {
		ClasseComposizioneCriteria criteria = new ClasseComposizioneCriteria().setId(ids);
		Page<ClasseComposizioneModel> models = classeComposizionePersistence.search(criteria, PageRequest.ofSize(10));
		return models.map(model -> classeComposizioneModelMapper.toDto(model)).getContent();
	}

	@Override
	public Page<ClasseComposizioneDTO> search(ClasseComposizioneCriteria criteria, Pageable pageRequest) {
		Page<ClasseComposizioneModel> models = classeComposizionePersistence.search(criteria, pageRequest);
		return models.map(model -> this.classeComposizioneModelMapper.toDto(model));
	}

	@Override
	public ClasseComposizioneDTO update(ClasseComposizioneUpdateDTO dto) {
		ClasseComposizioneDTO classeComposizioneDTO = classeComposizioneModelMapper.fromUpdateDto(dto);
        this.checkClasseComposizioneExists(classeComposizioneDTO.getId());		
        ClasseComposizioneModel classeComposizioneModel = classeComposizioneModelMapper.toModel(classeComposizioneDTO);
        classeComposizionePersistence.save(classeComposizioneModel);
        
        ClasseComposizioneCriteria criteria = new ClasseComposizioneCriteria().setId(Collections.singletonList(classeComposizioneDTO.getId()));
		Page<ClasseComposizioneModel> models = classeComposizionePersistence.search(criteria, PageRequest.ofSize(1));
		ClasseComposizioneModel model = models
				.getContent()
				.stream()
                .findAny()
                .orElse(null);
        return classeComposizioneModelMapper.toDto(model);
	}
	
	@Override
	public ClasseComposizioneDTO delete(UUID id) {
		this.checkClasseComposizioneExists(id);
		this.checkInUse(id);
		ClasseComposizioneDTO classeComposizioneDTO = this.findByIds(Collections.singletonList(id))
				.stream()
				.findAny()
				.orElse(null);
		classeComposizioneDTO.setFlagElimina((short)1);
		
		ClasseComposizioneModel classeComposizioneModel = classeComposizioneModelMapper.toModel(classeComposizioneDTO);
        classeComposizionePersistence.save(classeComposizioneModel);
        
        ClasseComposizioneCriteria criteria = new ClasseComposizioneCriteria().setId(Collections.singletonList(classeComposizioneDTO.getId()));
		Page<ClasseComposizioneModel> models = classeComposizionePersistence.search(criteria, PageRequest.ofSize(1));
		ClasseComposizioneModel model = models
				.getContent()
				.stream()
                .findAny()
                .orElse(null);
        return classeComposizioneModelMapper.toDto(model);
	}
	
	private void checkClasseComposizioneExists(UUID id) {
		ClasseComposizioneCriteria criteria = new ClasseComposizioneCriteria().setId(Collections.singletonList(id));
		if (classeComposizionePersistence.search(criteria, PageRequest.ofSize(10)).isEmpty()) {
			log.warn("ClasseComposizione {} not found", id);
			throw new NotFoundException(String.format("ClasseComposizione %s not found", id));
		}
	}
	
	private void checkInUse(UUID id) {
		ClasseComposizioneAnnoCriteria criteria = new ClasseComposizioneAnnoCriteria().setClasseComposizione(Collections.singletonList(id));
		List<ClasseComposizioneAnnoDTO> found = classeComposizioneAnnoService.search(criteria, PageRequest.ofSize(10)).getContent();
		if (!found.isEmpty()) {
            log.warn("ClasseComposizione {} referenced in {} ClasseComposizioneAnno", id, found.size());
            throw new InternalServerErrorException(String.format("ClasseComposizione %s referenced in %d ClasseComposizioneAnno", id, found.size()));
        }
	}

}
