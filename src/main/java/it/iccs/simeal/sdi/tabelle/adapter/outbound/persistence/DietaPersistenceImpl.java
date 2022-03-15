package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.mapper.DietaEntityMapper;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.DietaRepository;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.DietaEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification.DietaSpecification;
import it.iccs.simeal.sdi.tabelle.application.model.DietaModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.DietaCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.DietaPersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class DietaPersistenceImpl extends DietaSpecification implements DietaPersistence {
	
	private final Logger log = LoggerFactory.getLogger(DietaPersistenceImpl.class);
	
	@Autowired
	private DietaRepository dietaRepository;
	
	@Autowired
	private DietaEntityMapper entityMapper;
	
	@Override
	public DietaModel save(DietaModel dietaModel) {
		log.debug("Request to save Dieta: {}", dietaModel);
        DietaEntity entityToSave = this.entityMapper.fromModelToEntity(dietaModel);
        DietaEntity savedEntity = dietaRepository.save(entityToSave);
        return this.entityMapper.fromEntityToModel(savedEntity);
	}
	
	@Override
	public Page<DietaModel> search(DietaCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search Dieta: {}", criteria);
        Page<DietaEntity> entities = dietaRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }

}
