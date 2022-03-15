package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence;

import java.util.UUID;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper.ServizioAnnoEntityMapper;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.ServizioAnnoRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.ServizioRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ServizioAnnoEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ServizioEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.specification.ServizioAnnoSpecification;
import it.iccs.simeal.sdi.configurazione.application.model.ServizioAnnoModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioAnnoCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence.ServizioAnnoPersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ServizioAnnoPersistenceImpl extends ServizioAnnoSpecification implements ServizioAnnoPersistence {
	
	private final Logger log = LoggerFactory.getLogger(ServizioAnnoPersistenceImpl.class);
	
	@Autowired
	private ServizioAnnoRepository servizioAnnoRepository;
	
	@Autowired
	private ServizioAnnoEntityMapper entityMapper;
	
	@Autowired
	private ServizioRepository servizioRepository;
	
	@Override
	public ServizioAnnoModel save(ServizioAnnoModel servizioAnnoModel) {
		log.debug("Request to save ServizioAnno: {}", servizioAnnoModel);
        ServizioAnnoEntity entityToSave = this.entityMapper.fromModelToEntity(servizioAnnoModel);
        
        if (servizioAnnoModel.getServizio() != null && servizioAnnoModel.getServizio().getId() != null) {
        	ServizioEntity servizioEntity = servizioRepository.findById(servizioAnnoModel.getServizio().getId())
        			.stream()
        			.findAny()
        			.orElse(null);
        	entityToSave.setServizio(servizioEntity);
        }
        
        ServizioAnnoEntity savedEntity = servizioAnnoRepository.save(entityToSave);
        return this.entityMapper.fromEntityToModel(savedEntity);
	}

	@Override
	public Page<ServizioAnnoModel> search(ServizioAnnoCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search ServizioAnno: {}", criteria);
        Page<ServizioAnnoEntity> entities = servizioAnnoRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }
	
	@Override
	public void delete(UUID id) {
		servizioAnnoRepository.deleteById(id);
	}
}
