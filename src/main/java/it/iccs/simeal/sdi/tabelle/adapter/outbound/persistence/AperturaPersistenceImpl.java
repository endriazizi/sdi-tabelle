package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.mapper.AperturaEntityMapper;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.AperturaRepository;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.ClasseRepository;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.IstitutoRepository;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.ServizioRepository;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.SezioneRepository;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.AperturaEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.ClasseEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.IstitutoEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.ServizioEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.SezioneEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification.AperturaSpecification;
import it.iccs.simeal.sdi.tabelle.application.model.AperturaModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.AperturaCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.AperturaPersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class AperturaPersistenceImpl extends AperturaSpecification implements AperturaPersistence {
	
	private final Logger log = LoggerFactory.getLogger(AperturaPersistenceImpl.class);
	
	@Autowired
	private AperturaRepository aperturaRepository;
	
	@Autowired
	private AperturaEntityMapper entityMapper;
	
	@Autowired
	private ServizioRepository servizioRepository;
	
	@Autowired
	private IstitutoRepository istitutoRepository;
	
	@Autowired
	private ClasseRepository classeRepository;
	
	@Autowired
	private SezioneRepository sezioneRepository;
	
	@Override
	public AperturaModel save(AperturaModel aperturaModel) {
		log.debug("Request to save Apertura: {}", aperturaModel);
        AperturaEntity entityToSave = this.entityMapper.fromModelToEntity(aperturaModel);
        
        if (aperturaModel.getServizio() != null && aperturaModel.getServizio().getId() != null) {
        	ServizioEntity servizioEntity = servizioRepository.findById(aperturaModel.getServizio().getId())
        			.stream()
        			.findAny()
        			.orElse(null);
        	entityToSave.setServizio(servizioEntity);
        }
        
        if (aperturaModel.getIstituto() != null && aperturaModel.getIstituto().getId() != null) {
        	IstitutoEntity istitutoEntity = istitutoRepository.findById(aperturaModel.getIstituto().getId())
        			.stream()
        			.findAny()
        			.orElse(null);
        	entityToSave.setIstituto(istitutoEntity);
        }
        
        if (aperturaModel.getClasse() != null && aperturaModel.getClasse().getId() != null) {
        	ClasseEntity classeEntity = classeRepository.findById(aperturaModel.getClasse().getId())
        			.stream()
        			.findAny()
        			.orElse(null);
        	entityToSave.setClasse(classeEntity);
        }
        
        if (aperturaModel.getSezione() != null && aperturaModel.getSezione().getId() != null) {
        	SezioneEntity sezioneEntity = sezioneRepository.findById(aperturaModel.getSezione().getId())
        			.stream()
        			.findAny()
        			.orElse(null);
        	entityToSave.setSezione(sezioneEntity);
        }
        
        
        AperturaEntity savedEntity = aperturaRepository.save(entityToSave);
        return this.entityMapper.fromEntityToModel(savedEntity);
	}

	@Override
	public Page<AperturaModel> search(AperturaCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search Apertura: {}", criteria);
        Page<AperturaEntity> entities = aperturaRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }

}
