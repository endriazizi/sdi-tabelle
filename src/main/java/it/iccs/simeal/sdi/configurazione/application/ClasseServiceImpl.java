package it.iccs.simeal.sdi.configurazione.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.iccs.simeal.sdi.configurazione.application.mapper.ClasseModelMapper;
import it.iccs.simeal.sdi.configurazione.application.model.ClasseModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.ClasseComposizioneService;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.ClasseService;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseUpdateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence.ClassePersistence;
import it.iccs.simeal.sdi.configurazione.web.rest.errors.InternalServerErrorException;
import it.iccs.simeal.sdi.configurazione.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ClasseServiceImpl implements ClasseService {

	@Autowired
	private ClasseModelMapper classeModelMapper;
	
	@Autowired
	private ClassePersistence classePersistence;
	
	@Autowired
	private ClasseComposizioneService classeComposizioneService;
	
	@Override
	public ClasseDTO create(ClasseCreateDTO dto) {
		ClasseDTO classeDTO = classeModelMapper.fromCreateDto(dto);
        ClasseModel classeModel = classeModelMapper.toModel(classeDTO);
        ClasseModel model = classePersistence.save(classeModel);
        return classeModelMapper.toDto(model);
	}

	@Override
	public List<ClasseDTO> findByIds(List<UUID> ids) {
		ClasseCriteria criteria = new ClasseCriteria().setId(ids);
		Page<ClasseModel> models = classePersistence.search(criteria, PageRequest.ofSize(10));
		return models.map(model -> this.classeModelMapper.toDto(model)).getContent();
	}

	@Override
	public Page<ClasseDTO> search(ClasseCriteria criteria, Pageable pageRequest) {
		Page<ClasseModel> models = classePersistence.search(criteria, pageRequest);
		return models.map(model -> this.classeModelMapper.toDto(model));
	}

	@Override
	public ClasseDTO update(ClasseUpdateDTO dto) {
		ClasseDTO classeDTO = classeModelMapper.fromUpdateDto(dto);
        this.checkClasseExists(classeDTO.getId());		
        ClasseModel classeModel = classeModelMapper.toModel(classeDTO);
        classePersistence.save(classeModel);
        
        ClasseCriteria criteria = new ClasseCriteria().setId(Collections.singletonList(classeDTO.getId()));
		Page<ClasseModel> models = classePersistence.search(criteria, PageRequest.ofSize(10));
        ClasseModel model = models
        		.getContent()
                .stream()
                .findAny()
                .orElse(null);
        return classeModelMapper.toDto(model);
	}
	
	@Override
	public void delete(UUID id) {
		this.checkClasseExists(id);
		this.checkInUse(id);
		ClasseDTO classeDTO = this.findByIds(Collections.singletonList(id))
				.stream()
				.findAny()
				.orElse(null);
		classeDTO.setFlagElimina((short)1);
		
		ClasseModel classeModel = classeModelMapper.toModel(classeDTO);
		classePersistence.save(classeModel);
	}
	
	private void checkClasseExists(UUID id) {
		ClasseCriteria criteria = new ClasseCriteria().setId(Collections.singletonList(id));
		if (classePersistence.search(criteria, PageRequest.ofSize(10)).isEmpty()) {
			log.warn("Classe {} not found", id);
			throw new NotFoundException(String.format("Classe %s not found", id));
		}
	}
	
	private void checkInUse(UUID id) {
		ClasseComposizioneCriteria criteria = new ClasseComposizioneCriteria().setClasse(Collections.singletonList(id));
		List<ClasseComposizioneDTO> found = classeComposizioneService.search(criteria, PageRequest.ofSize(10)).getContent();
		if (!found.isEmpty()) {
			log.warn("Classe {} referenced in {} ClasseComposizione", id, found.size());
	        throw new InternalServerErrorException(String.format("Classe %s referenced in %d ClasseComposizione", id, found.size()));
	    }
	}

}
