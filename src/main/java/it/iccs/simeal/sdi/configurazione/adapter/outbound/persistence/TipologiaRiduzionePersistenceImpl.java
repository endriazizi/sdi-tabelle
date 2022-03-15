package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper.TipologiaRiduzioneEntityMapper;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.TipologiaRiduzioneRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.TipologiaRiduzioneEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.specification.TipologiaRiduzioneSpecification;
import it.iccs.simeal.sdi.configurazione.application.model.TipologiaRiduzioneModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TipologiaRiduzioneCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence.TipologiaRiduzionePersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class TipologiaRiduzionePersistenceImpl extends TipologiaRiduzioneSpecification implements TipologiaRiduzionePersistence {
	
	private final Logger log = LoggerFactory.getLogger(TipologiaRiduzionePersistenceImpl.class);
	
	@Autowired
	private TipologiaRiduzioneRepository tipologiaRiduzioneRepository;
	
	@Autowired
	private TipologiaRiduzioneEntityMapper entityMapper;
	
	@Override
	public TipologiaRiduzioneModel save(TipologiaRiduzioneModel tipologiaRiduzioneModel) {
		log.debug("Request to save TipologiaRiduzione: {}", tipologiaRiduzioneModel);
        TipologiaRiduzioneEntity entityToSave = this.entityMapper.fromModelToEntity(tipologiaRiduzioneModel);
        TipologiaRiduzioneEntity savedEntity = tipologiaRiduzioneRepository.save(entityToSave);
        return this.entityMapper.fromEntityToModel(savedEntity);
	}
	
	@Override
	public Page<TipologiaRiduzioneModel> search(TipologiaRiduzioneCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search TipologiaRiduzione: {}", criteria);
        Page<TipologiaRiduzioneEntity> entities = tipologiaRiduzioneRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }

}
