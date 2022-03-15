package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper.ClasseEntityMapper;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.ClasseRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ClasseEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.specification.ClasseSpecification;
import it.iccs.simeal.sdi.configurazione.application.model.ClasseModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence.ClassePersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ClassePersistenceImpl extends ClasseSpecification implements ClassePersistence {
	
	private final Logger log = LoggerFactory.getLogger(ClassePersistenceImpl.class);
	
	@Autowired
	private ClasseRepository classeRepository;
	
	@Autowired
	private ClasseEntityMapper entityMapper;
	
	@Override
	public ClasseModel save(ClasseModel classeModel) {
		log.debug("Request to save Classe: {}", classeModel);
        ClasseEntity entityToSave = this.entityMapper.fromModelToEntity(classeModel);
        ClasseEntity savedEntity = classeRepository.save(entityToSave);
        return this.entityMapper.fromEntityToModel(savedEntity);
	}
	
	@Override
	public Page<ClasseModel> search(ClasseCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search Classe: {}", criteria);
        Page<ClasseEntity> entities = classeRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }

}
