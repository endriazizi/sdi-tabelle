package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.mapper.GiroEntityMapper;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.GiroRepository;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.GiroEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification.GiroSpecification;
import it.iccs.simeal.sdi.tabelle.application.model.GiroModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.GiroCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.GiroPersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class GiroPersistenceImpl extends GiroSpecification implements GiroPersistence {
	
	private final Logger log = LoggerFactory.getLogger(GiroPersistenceImpl.class);
	
	@Autowired
	private GiroRepository giroRepository;
	
	@Autowired
	private GiroEntityMapper entityMapper;
	
	@Override
	public GiroModel save(GiroModel giroModel) {
		log.debug("Request to save Giro: {}", giroModel);
        GiroEntity entityToSave = this.entityMapper.fromModelToEntity(giroModel);
        GiroEntity savedEntity = giroRepository.save(entityToSave);
        return this.entityMapper.fromEntityToModel(savedEntity);
	}
	
	@Override
	public Page<GiroModel> search(GiroCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search Giro: {}", criteria);
        Page<GiroEntity> entities = giroRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }

}
