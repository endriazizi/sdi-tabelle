package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper.RefettorioEntityMapper;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.RefettorioRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.RefettorioEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.specification.RefettorioSpecification;
import it.iccs.simeal.sdi.configurazione.application.model.RefettorioModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.RefettorioCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence.RefettorioPersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RefettorioPersistenceImpl extends RefettorioSpecification implements RefettorioPersistence {
	
	private final Logger log = LoggerFactory.getLogger(RefettorioPersistenceImpl.class);
	
	@Autowired
	private RefettorioRepository refettorioRepository;
	
	@Autowired
	private RefettorioEntityMapper entityMapper;
	
	@Override
	public RefettorioModel save(RefettorioModel refettorioModel) {
		log.debug("Request to save Refettorio: {}", refettorioModel);
        RefettorioEntity entityToSave = this.entityMapper.fromModelToEntity(refettorioModel);
        RefettorioEntity savedEntity = refettorioRepository.save(entityToSave);
        return this.entityMapper.fromEntityToModel(savedEntity);
	}

	@Override
	public Page<RefettorioModel> search(RefettorioCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search Refettorio: {}", criteria);
        Page<RefettorioEntity> entities = refettorioRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }

}
