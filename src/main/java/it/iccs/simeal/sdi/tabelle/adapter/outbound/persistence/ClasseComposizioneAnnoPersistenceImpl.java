package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.mapper.ClasseComposizioneAnnoEntityMapper;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.ClasseComposizioneAnnoRepository;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.ClasseComposizioneRepository;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.RefettorioRepository;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.TurnoRepository;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.ClasseComposizioneAnnoEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.ClasseComposizioneEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.RefettorioEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.TurnoEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification.ClasseComposizioneAnnoSpecification;
import it.iccs.simeal.sdi.tabelle.application.model.ClasseComposizioneAnnoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseComposizioneAnnoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.ClasseComposizioneAnnoPersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ClasseComposizioneAnnoPersistenceImpl extends ClasseComposizioneAnnoSpecification implements ClasseComposizioneAnnoPersistence {
	
	private final Logger log = LoggerFactory.getLogger(ClasseComposizioneAnnoPersistenceImpl.class);
	
	@Autowired
	private ClasseComposizioneAnnoRepository classeComposizioneAnnoRepository;
	
	@Autowired
	private ClasseComposizioneAnnoEntityMapper entityMapper;
	
	@Autowired
	private TurnoRepository turnoRepository;
	
	@Autowired
	private RefettorioRepository refettorioRepository;
	
	@Autowired
	private ClasseComposizioneRepository classeComposizioneRepository;
	
	@Override
	public ClasseComposizioneAnnoModel save(ClasseComposizioneAnnoModel classeComposizioneAnnoModel) {
		log.trace("This is a TRACE level message");
        log.debug("This is a DEBUG level message");
        log.info("This is an INFO level message");
        log.warn("This is a WARN level message");
        log.error("This is an ERROR level message");
		log.debug("Request to save ClasseComposizioneAnno: {}", classeComposizioneAnnoModel);
        ClasseComposizioneAnnoEntity entityToSave = this.entityMapper.fromModelToEntity(classeComposizioneAnnoModel);
        
        if (classeComposizioneAnnoModel.getTurno() != null && classeComposizioneAnnoModel.getTurno().getId() != null) {
        	TurnoEntity turnoEntity = turnoRepository.findById(classeComposizioneAnnoModel.getTurno().getId())
        			.stream()
        			.findAny()
        			.orElse(null);
        	entityToSave.setTurno(turnoEntity);
        }
        
        if (classeComposizioneAnnoModel.getRefettorio() != null && classeComposizioneAnnoModel.getRefettorio().getId() != null) {
        	RefettorioEntity refettorioEntity = refettorioRepository.findById(classeComposizioneAnnoModel.getRefettorio().getId())
        			.stream()
        			.findAny()
        			.orElse(null);
        	entityToSave.setRefettorio(refettorioEntity);
        }
        
        if (classeComposizioneAnnoModel.getClasseComposizione() != null && classeComposizioneAnnoModel.getClasseComposizione().getId() != null) {
        	ClasseComposizioneEntity classeComposizioneEntity = classeComposizioneRepository.findById(classeComposizioneAnnoModel.getClasseComposizione().getId())
        			.stream()
        			.findAny()
        			.orElse(null);
        	entityToSave.setClasseComposizione(classeComposizioneEntity);
        }
        
        ClasseComposizioneAnnoEntity savedEntity = classeComposizioneAnnoRepository.save(entityToSave);
		return this.entityMapper.fromEntityToModel(savedEntity);
	}

	@Override
	public Page<ClasseComposizioneAnnoModel> search(ClasseComposizioneAnnoCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search ClasseComposizioneAnno: {}", criteria);
        Page<ClasseComposizioneAnnoEntity> entities = classeComposizioneAnnoRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }

}
