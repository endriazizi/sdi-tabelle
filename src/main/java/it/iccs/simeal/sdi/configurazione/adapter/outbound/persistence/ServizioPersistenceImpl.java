package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper.ServizioEntityMapper;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.ServizioRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ServizioEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.specification.ServizioSpecification;
import it.iccs.simeal.sdi.configurazione.application.model.ServizioModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence.ServizioPersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ServizioPersistenceImpl extends ServizioSpecification implements ServizioPersistence {
	
	private final Logger log = LoggerFactory.getLogger(ServizioPersistenceImpl.class);
	
	@Autowired
	private ServizioRepository servizioRepository;
	
	@Autowired
	private ServizioEntityMapper entityMapper;
	
	@Override
	public ServizioModel save(ServizioModel servizioModel) {
		log.debug("Request to save Servizio: {}", servizioModel);
        ServizioEntity entityToSave = this.entityMapper.fromModelToEntity(servizioModel);
        ServizioEntity savedEntity = servizioRepository.save(entityToSave);
        return this.entityMapper.fromEntityToModel(savedEntity);
	}

//	@Override
//	public List<SezioneModel> findByIds(List<UUID> ids) {
//		log.debug("Request to find any Sezione {}", ids);
//        List<SezioneEntity> entities = sezioneRepository.findAllById(ids);
//        return entityMapper.fromEntitiesToModels(entities);
//	}

	@Override
	public Page<ServizioModel> search(ServizioCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search Sezione: {}", criteria);
        Page<ServizioEntity> entities = servizioRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }

//	@Override
//	public void delete(UUID id) {
//        log.debug("Request to delete Sezione {}", id);
//        sezioneRepository.deleteById(id);
//	}

}
