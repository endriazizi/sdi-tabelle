package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper.IstitutoEntityMapper;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.IstitutoRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.IstitutoEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.specification.IstitutoSpecification;
import it.iccs.simeal.sdi.configurazione.application.model.IstitutoModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.IstitutoCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence.IstitutoPersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class IstitutoPersistenceImpl extends IstitutoSpecification implements IstitutoPersistence {
	
	private final Logger log = LoggerFactory.getLogger(IstitutoPersistenceImpl.class);
	
	@Autowired
	private IstitutoRepository istitutoRepository;
	
	@Autowired
	private IstitutoEntityMapper entityMapper;
	
	@Override
	public IstitutoModel save(IstitutoModel istitutoModel) {
		log.debug("Request to save Istituto: {}", istitutoModel);
        IstitutoEntity entityToSave = this.entityMapper.fromModelToEntity(istitutoModel);
        IstitutoEntity savedEntity = istitutoRepository.save(entityToSave);
        return this.entityMapper.fromEntityToModel(savedEntity);
	}

	@Override
	public Page<IstitutoModel> search(IstitutoCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search Istituto: {}", criteria);
        Page<IstitutoEntity> entities = istitutoRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }

}
