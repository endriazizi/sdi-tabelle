package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper.ChiusuraEntityMapper;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.ChiusuraRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.ClasseRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.IstitutoRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.ServizioRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.SezioneRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ChiusuraEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ClasseEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.IstitutoEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ServizioEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.SezioneEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.specification.ChiusuraSpecification;
import it.iccs.simeal.sdi.configurazione.application.model.ChiusuraModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ChiusuraCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence.ChiusuraPersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class ChiusuraPersistenceImpl extends ChiusuraSpecification implements ChiusuraPersistence {
	
	private final Logger log = LoggerFactory.getLogger(ChiusuraPersistenceImpl.class);
	
	@Autowired
	private ChiusuraRepository chiusuraRepository;
	
	@Autowired
	private ChiusuraEntityMapper entityMapper;
	
	@Autowired
	private ServizioRepository servizioRepository;
	
	@Autowired
	private IstitutoRepository istitutoRepository;
	
	@Autowired
	private ClasseRepository classeRepository;
	
	@Autowired
	private SezioneRepository sezioneRepository;
	
	@Override
	public ChiusuraModel save(ChiusuraModel chiusuraModel) {
		log.debug("Request to save Chiusura: {}", chiusuraModel);
        ChiusuraEntity entityToSave = this.entityMapper.fromModelToEntity(chiusuraModel);
        
        if (chiusuraModel.getServizio() != null && chiusuraModel.getServizio().getId() != null) {
        	ServizioEntity servizioEntity = servizioRepository.findById(chiusuraModel.getServizio().getId())
        			.stream()
        			.findAny()
        			.orElse(null);
        	entityToSave.setServizio(servizioEntity);
        }
        
        if (chiusuraModel.getIstituto() != null && chiusuraModel.getIstituto().getId() != null) {
        	IstitutoEntity istitutoEntity = istitutoRepository.findById(chiusuraModel.getIstituto().getId())
        			.stream()
        			.findAny()
        			.orElse(null);
        	entityToSave.setIstituto(istitutoEntity);
        }
        
        if (chiusuraModel.getClasse() != null && chiusuraModel.getClasse().getId() != null) {
        	ClasseEntity classeEntity = classeRepository.findById(chiusuraModel.getClasse().getId())
        			.stream()
        			.findAny()
        			.orElse(null);
        	entityToSave.setClasse(classeEntity);
        }
        
        if (chiusuraModel.getSezione() != null && chiusuraModel.getSezione().getId() != null) {
        	SezioneEntity sezioneEntity = sezioneRepository.findById(chiusuraModel.getSezione().getId())
        			.stream()
        			.findAny()
        			.orElse(null);
        	entityToSave.setSezione(sezioneEntity);
        }
        
        
        ChiusuraEntity savedEntity = chiusuraRepository.save(entityToSave);
        return this.entityMapper.fromEntityToModel(savedEntity);
	}

	@Override
	public Page<ChiusuraModel> search(ChiusuraCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search Chiusura: {}", criteria);
        Page<ChiusuraEntity> entities = chiusuraRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }

}
