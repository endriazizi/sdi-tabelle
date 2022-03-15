package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence;

import java.util.List;
import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.mapper.AnnoEntityMapper;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.AnnoRepository;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.AnnoEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification.AnnoSpecification;
import it.iccs.simeal.sdi.tabelle.application.model.AnnoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.AnnoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.AnnoPersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AnnoPersistenceImpl extends AnnoSpecification implements AnnoPersistence {
	
	private final Logger log = LoggerFactory.getLogger(AnnoPersistenceImpl.class);
	
	@Autowired
	private AnnoRepository annoRepository;
	
	@Autowired
	private AnnoEntityMapper entityMapper;
	
	@Override
	public AnnoModel save(AnnoModel annoModel) {
		log.debug("Request to save Anno: {}", annoModel);
        AnnoEntity entityToSave = this.entityMapper.fromModelToEntity(annoModel);
        AnnoEntity savedEntity = annoRepository.save(entityToSave);
        return this.entityMapper.fromEntityToModel(savedEntity);
	}

	@Override
	public List<AnnoModel> findByIds(List<UUID> ids) {
		log.debug("Request to find any Anno {}", ids);
        List<AnnoEntity> entities = annoRepository.findAllById(ids);
        return entityMapper.fromEntitiesToModels(entities);
	}

	@Override
	public Page<AnnoModel> search(AnnoCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search Anno: {}", criteria);
        Page<AnnoEntity> entities = annoRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }

	@Override
	public void delete(UUID id) {
        log.debug("Request to delete Anno {}", id);
        annoRepository.deleteById(id);
	}

}
