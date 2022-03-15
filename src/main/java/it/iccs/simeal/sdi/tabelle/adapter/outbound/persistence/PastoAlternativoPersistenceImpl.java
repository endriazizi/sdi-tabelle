package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.mapper.PastoAlternativoEntityMapper;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.PastoAlternativoRepository;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.PastoAlternativoEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification.PastoAlternativoSpecification;
import it.iccs.simeal.sdi.tabelle.application.model.PastoAlternativoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.PastoAlternativoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.PastoAlternativoPersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class PastoAlternativoPersistenceImpl extends PastoAlternativoSpecification implements PastoAlternativoPersistence {
	
	private final Logger log = LoggerFactory.getLogger(PastoAlternativoPersistenceImpl.class);
	
	@Autowired
	private PastoAlternativoRepository pastoAlternativoRepository;
	
	@Autowired
	private PastoAlternativoEntityMapper entityMapper;
	
	@Override
	public PastoAlternativoModel save(PastoAlternativoModel PastoAlternativoModel) {
		log.debug("Request to save PastoAlternativo: {}", PastoAlternativoModel);
        PastoAlternativoEntity entityToSave = this.entityMapper.fromModelToEntity(PastoAlternativoModel);
        PastoAlternativoEntity savedEntity = pastoAlternativoRepository.save(entityToSave);
        return this.entityMapper.fromEntityToModel(savedEntity);
	}
	
	@Override
	public Page<PastoAlternativoModel> search(PastoAlternativoCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search PastoAlternativo: {}", criteria);
        Page<PastoAlternativoEntity> entities = pastoAlternativoRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }

}
