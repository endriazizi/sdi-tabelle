package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper.SezioneEntityMapper;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.SezioneRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.SezioneEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.specification.SezioneSpecification;
import it.iccs.simeal.sdi.configurazione.application.model.SezioneModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.SezioneCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence.SezionePersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class SezionePersistenceImpl extends SezioneSpecification implements SezionePersistence {
	
	private final Logger log = LoggerFactory.getLogger(SezionePersistenceImpl.class);
	
	@Autowired
	private SezioneRepository sezioneRepository;
	
	@Autowired
	private SezioneEntityMapper entityMapper;
	
	@Override
	public SezioneModel save(SezioneModel sezioneModel) {
		log.debug("Request to save Sezione: {}", sezioneModel);
        SezioneEntity entityToSave = this.entityMapper.fromModelToEntity(sezioneModel);
        SezioneEntity savedEntity = sezioneRepository.save(entityToSave);
        return this.entityMapper.fromEntityToModel(savedEntity);
	}

//	@Override
//	public List<SezioneModel> findByIds(List<UUID> ids) {
//		log.debug("Request to find any Sezione {}", ids);
//        List<SezioneEntity> entities = sezioneRepository.findAllById(ids);
//        return entityMapper.fromEntitiesToModels(entities);
//	}

	@Override
	public Page<SezioneModel> search(SezioneCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search Sezione: {}", criteria);
        Page<SezioneEntity> entities = sezioneRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }

//	@Override
//	public void delete(UUID id) {
//        log.debug("Request to delete Sezione {}", id);
//        sezioneRepository.deleteById(id);
//	}

}
