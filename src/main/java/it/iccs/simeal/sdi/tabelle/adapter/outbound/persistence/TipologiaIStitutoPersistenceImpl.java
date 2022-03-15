package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.mapper.TipologiaIstitutoEntityMapper;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.TipologiaIstitutoRepository;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.TipologiaIstitutoEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification.TipologiaIstitutoSpecification;
import it.iccs.simeal.sdi.tabelle.application.model.TipologiaIstitutoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaIstitutoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.TipologiaIstitutoPersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class TipologiaIStitutoPersistenceImpl extends TipologiaIstitutoSpecification implements TipologiaIstitutoPersistence {
	
	private final Logger log = LoggerFactory.getLogger(TipologiaIStitutoPersistenceImpl.class);
	
	@Autowired
	private TipologiaIstitutoRepository tipologiaIstitutoRepository;
	
	@Autowired
	private TipologiaIstitutoEntityMapper entityMapper;
	
	@Override
	public TipologiaIstitutoModel save(TipologiaIstitutoModel tipologiaIstitutoModel) {
		log.debug("Request to save TipologiaIstituto: {}", tipologiaIstitutoModel);
        TipologiaIstitutoEntity entityToSave = this.entityMapper.fromModelToEntity(tipologiaIstitutoModel);
        TipologiaIstitutoEntity savedEntity = tipologiaIstitutoRepository.save(entityToSave);
        return this.entityMapper.fromEntityToModel(savedEntity);
	}
	
	@Override
	public Page<TipologiaIstitutoModel> search(TipologiaIstitutoCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search TipologiaIstituto: {}", criteria);
        Page<TipologiaIstitutoEntity> entities = tipologiaIstitutoRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }

}
