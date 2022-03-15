package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper.ClasseComposizioneEntityMapper;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.ClasseComposizioneRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.ClasseRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.IstitutoRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.SezioneRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ClasseComposizioneEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ClasseEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.IstitutoEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.SezioneEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.specification.ClasseComposizioneSpecification;
import it.iccs.simeal.sdi.configurazione.application.model.ClasseComposizioneModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence.ClasseComposizionePersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ClasseComposizionePersistenceImpl extends ClasseComposizioneSpecification implements ClasseComposizionePersistence {
	
	private final Logger log = LoggerFactory.getLogger(ClasseComposizionePersistenceImpl.class);
	
	@Autowired
	private ClasseComposizioneRepository classeComposizioneRepository;
	
	@Autowired
	private ClasseComposizioneEntityMapper entityMapper;
	
	@Autowired
	private IstitutoRepository istitutoRepository;
	
	@Autowired
	private ClasseRepository classeRepository;
	
	@Autowired
	private SezioneRepository sezioneRepository;
	
	@Override
	public ClasseComposizioneModel save(ClasseComposizioneModel classeComposizioneModel) {
		log.debug("Request to save ClasseComposizione: {}", classeComposizioneModel);
        ClasseComposizioneEntity entityToSave = this.entityMapper.fromModelToEntity(classeComposizioneModel);
        
        if (classeComposizioneModel.getIstituto() != null && classeComposizioneModel.getIstituto().getId() != null) {
        	IstitutoEntity istitutoEntity = istitutoRepository.findById(classeComposizioneModel.getIstituto().getId())
        			.stream()
        			.findAny()
        			.orElse(null);
        	entityToSave.setIstituto(istitutoEntity);
        }
        
        if (classeComposizioneModel.getClasse() != null && classeComposizioneModel.getClasse().getId() != null) {
        	ClasseEntity classeEntity = classeRepository.findById(classeComposizioneModel.getClasse().getId())
        			.stream()
        			.findAny()
        			.orElse(null);
        	entityToSave.setClasse(classeEntity);
        }
        
        if (classeComposizioneModel.getSezione() != null && classeComposizioneModel.getSezione().getId() != null) {
        	SezioneEntity sezioneEntity = sezioneRepository.findById(classeComposizioneModel.getSezione().getId())
        			.stream()
        			.findAny()
        			.orElse(null);
        	entityToSave.setSezione(sezioneEntity);
        }
        
        if (classeComposizioneModel.getIstitutoSuccessiva() != null && classeComposizioneModel.getIstitutoSuccessiva().getId() != null) {
        	IstitutoEntity istitutoSuccessivaEntity = istitutoRepository.findById(classeComposizioneModel.getIstitutoSuccessiva().getId())
        			.stream()
        			.findAny()
        			.orElse(null);
        	entityToSave.setIstitutoSuccessiva(istitutoSuccessivaEntity);
        }
        
        if (classeComposizioneModel.getClasseSuccessiva() != null && classeComposizioneModel.getClasseSuccessiva().getId() != null) {
        	ClasseEntity classeSuccessivaEntity = classeRepository.findById(classeComposizioneModel.getClasseSuccessiva().getId())
        			.stream()
        			.findAny()
        			.orElse(null);
        	entityToSave.setClasseSuccessiva(classeSuccessivaEntity);
        }
        
        if (classeComposizioneModel.getSezioneSuccessiva() != null && classeComposizioneModel.getSezioneSuccessiva().getId() != null) {
        	SezioneEntity sezioneSuccessivaEntity = sezioneRepository.findById(classeComposizioneModel.getSezioneSuccessiva().getId())
        			.stream()
        			.findAny()
        			.orElse(null);
        	entityToSave.setSezioneSuccessiva(sezioneSuccessivaEntity);
        }
        
        ClasseComposizioneEntity savedEntity = classeComposizioneRepository.save(entityToSave);
        return this.entityMapper.fromEntityToModel(savedEntity);
	}

	@Override
	public Page<ClasseComposizioneModel> search(ClasseComposizioneCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search ClasseComposizione: {}", criteria);
        Page<ClasseComposizioneEntity> entities = classeComposizioneRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }

}
