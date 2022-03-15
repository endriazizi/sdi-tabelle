package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper.CentroCotturaIstitutoEntityMapper;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.CentroCotturaIstitutoRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.CentroCotturaRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.IstitutoRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.CentroCotturaIstitutoEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.IstitutoEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.CentroCotturaEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.specification.CentroCotturaIstitutoSpecification;
import it.iccs.simeal.sdi.configurazione.application.model.CentroCotturaIstitutoModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.CentroCotturaIstitutoCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence.CentroCotturaIstitutoPersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class CentroCotturaIstitutoPersistenceImpl extends CentroCotturaIstitutoSpecification
		implements CentroCotturaIstitutoPersistence {

	private final Logger log = LoggerFactory.getLogger(CentroCotturaIstitutoPersistenceImpl.class);

	@Autowired
	private CentroCotturaIstitutoRepository centroCotturaIstitutoRepository;

	@Autowired
	private CentroCotturaIstitutoEntityMapper entityMapper;

	@Autowired
	private CentroCotturaRepository centroCotturaRepository;
	
	@Autowired
	private IstitutoRepository istitutoRepository;
	
	@Override
	public CentroCotturaIstitutoModel save(CentroCotturaIstitutoModel centroCotturaIstitutoModel) {
		log.trace("This is a TRACE level message");
		log.debug("This is a DEBUG level message");
		log.info("This is an INFO level message");
		log.warn("This is a WARN level message");
		log.error("This is an ERROR level message");
		log.debug("Request to save CentroCotturaIstituto: {}", centroCotturaIstitutoModel);
		CentroCotturaIstitutoEntity entityToSave = this.entityMapper.fromModelToEntity(centroCotturaIstitutoModel);

		if (centroCotturaIstitutoModel.getCentroCottura() != null
				&& centroCotturaIstitutoModel.getCentroCottura().getId() != null) {
			CentroCotturaEntity centroCotturaEntity = centroCotturaRepository
					.findById(centroCotturaIstitutoModel.getCentroCottura().getId()).stream().findAny().orElse(null);
			entityToSave.setCentroCottura(centroCotturaEntity);
		}
		
		if (centroCotturaIstitutoModel.getIstituto() != null
				&& centroCotturaIstitutoModel.getIstituto().getId() != null) {
			IstitutoEntity istitutoEntity = istitutoRepository
					.findById(centroCotturaIstitutoModel.getIstituto().getId()).stream().findAny().orElse(null);
			entityToSave.setIstituto(istitutoEntity);
		}

		CentroCotturaIstitutoEntity savedEntity = centroCotturaIstitutoRepository.save(entityToSave);
		return this.entityMapper.fromEntityToModel(savedEntity);
	}
	
	

	@Override
	public Page<CentroCotturaIstitutoModel> search(CentroCotturaIstitutoCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search CentroCotturaIstituto: {}", criteria);
		Page<CentroCotturaIstitutoEntity> entities = centroCotturaIstitutoRepository.findAll(this.filter(criteria),
				pageRequest);
		return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
	}



	@Override
	public void delete(UUID id) {
		centroCotturaIstitutoRepository.deleteById(id);
	}

}
