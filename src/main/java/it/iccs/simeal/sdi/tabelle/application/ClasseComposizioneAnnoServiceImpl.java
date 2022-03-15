package it.iccs.simeal.sdi.tabelle.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.iccs.simeal.sdi.tabelle.application.mapper.ClasseComposizioneAnnoModelMapper;
import it.iccs.simeal.sdi.tabelle.application.model.ClasseComposizioneAnnoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.ClasseComposizioneAnnoService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseComposizioneAnnoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseComposizioneAnnoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseComposizioneAnnoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseComposizioneAnnoUpdateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.ClasseComposizioneAnnoPersistence;
import it.iccs.simeal.sdi.tabelle.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClasseComposizioneAnnoServiceImpl implements ClasseComposizioneAnnoService {

	@Autowired
	private ClasseComposizioneAnnoModelMapper classeComposizioneAnnoModelMapper;
	
	@Autowired
	private ClasseComposizioneAnnoPersistence classeComposizioneAnnoPersistence;
	
	@Override
	public ClasseComposizioneAnnoDTO create(ClasseComposizioneAnnoCreateDTO dto) {
		ClasseComposizioneAnnoDTO classeComposizioneAnnoDTO = classeComposizioneAnnoModelMapper.fromCreateDto(dto);
        ClasseComposizioneAnnoModel classeComposizioneAnnoModel = classeComposizioneAnnoModelMapper.toModel(classeComposizioneAnnoDTO);
        ClasseComposizioneAnnoModel model = classeComposizioneAnnoPersistence.save(classeComposizioneAnnoModel);
        return classeComposizioneAnnoModelMapper.toDto(model);
	}

	@Override
	public List<ClasseComposizioneAnnoDTO> findByIds(List<UUID> ids) {
		ClasseComposizioneAnnoCriteria criteria = new ClasseComposizioneAnnoCriteria().setId(ids);
		Page<ClasseComposizioneAnnoModel> models = classeComposizioneAnnoPersistence.search(criteria, PageRequest.ofSize(10));
		return models.map(model -> classeComposizioneAnnoModelMapper.toDto(model)).getContent();
	}

	@Override
	public Page<ClasseComposizioneAnnoDTO> search(ClasseComposizioneAnnoCriteria criteria, Pageable pageRequest) {
		Page<ClasseComposizioneAnnoModel> models = classeComposizioneAnnoPersistence.search(criteria, pageRequest);
		return models.map(model -> this.classeComposizioneAnnoModelMapper.toDto(model));
	}

	@Override
	public ClasseComposizioneAnnoDTO update(ClasseComposizioneAnnoUpdateDTO dto) {
		ClasseComposizioneAnnoDTO classeComposizioneAnnoDTO = classeComposizioneAnnoModelMapper.fromUpdateDto(dto);
        this.checkClasseComposizioneAnnoExists(classeComposizioneAnnoDTO.getId());		
        ClasseComposizioneAnnoModel classeComposizioneAnnoModel = classeComposizioneAnnoModelMapper.toModel(classeComposizioneAnnoDTO);
        classeComposizioneAnnoPersistence.save(classeComposizioneAnnoModel);
        
        ClasseComposizioneAnnoCriteria criteria = new ClasseComposizioneAnnoCriteria().setId(Collections.singletonList(classeComposizioneAnnoDTO.getId()));
		Page<ClasseComposizioneAnnoModel> models = classeComposizioneAnnoPersistence.search(criteria, PageRequest.ofSize(1));
		ClasseComposizioneAnnoModel model = models
				.getContent()
				.stream()
                .findAny()
                .orElse(null);
        return classeComposizioneAnnoModelMapper.toDto(model);
	}
	
	@Override
	public void delete(UUID id) {
		this.checkClasseComposizioneAnnoExists(id);
		ClasseComposizioneAnnoDTO classeComposizioneAnnoDTO = this.findByIds(Collections.singletonList(id))
				.stream()
				.findAny()
				.orElse(null);
		classeComposizioneAnnoDTO.setFlagVisibile((short)0);
		
		ClasseComposizioneAnnoModel classeComposizioneAnnoModel = classeComposizioneAnnoModelMapper.toModel(classeComposizioneAnnoDTO);
        classeComposizioneAnnoPersistence.save(classeComposizioneAnnoModel);
	}
	
	private void checkClasseComposizioneAnnoExists(UUID id) {
		ClasseComposizioneAnnoCriteria criteria = new ClasseComposizioneAnnoCriteria().setId(Collections.singletonList(id));
		if (classeComposizioneAnnoPersistence.search(criteria, PageRequest.ofSize(10)).isEmpty()) {
			log.warn("ClasseComposizioneAnno {} not found", id);
			throw new NotFoundException(String.format("ClasseComposizioneAnno %s not found", id));
		}
	}

}
