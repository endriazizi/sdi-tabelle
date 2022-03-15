package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper.CentroCotturaEntityMapper;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.CentroCotturaRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.CentroCotturaEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.specification.CentroCotturaSpecification;
import it.iccs.simeal.sdi.configurazione.application.model.CentroCotturaModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.CentroCotturaCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence.CentroCotturaPersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CentroCotturaPersistenceImpl extends CentroCotturaSpecification implements CentroCotturaPersistence {
	
	private final Logger log = LoggerFactory.getLogger(CentroCotturaPersistenceImpl.class);
	
	@Autowired
	private CentroCotturaRepository centroCotturaRepository;
	
	@Autowired
	private CentroCotturaEntityMapper entityMapper;
	
	@Override
	public CentroCotturaModel save(CentroCotturaModel centroCotturaModel) {
		log.debug("Request to save CentroCottura: {}", centroCotturaModel);
        CentroCotturaEntity entityToSave = this.entityMapper.fromModelToEntity(centroCotturaModel);
        CentroCotturaEntity savedEntity = centroCotturaRepository.save(entityToSave);
        return this.entityMapper.fromEntityToModel(savedEntity);
	}

	@Override
	public Page<CentroCotturaModel> search(CentroCotturaCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search CentroCottura: {}", criteria);
        Page<CentroCotturaEntity> entities = centroCotturaRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }

}
