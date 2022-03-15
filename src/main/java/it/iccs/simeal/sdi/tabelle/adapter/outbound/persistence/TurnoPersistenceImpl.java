package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.mapper.TurnoEntityMapper;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.TurnoRepository;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.TurnoEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification.TurnoSpecification;
import it.iccs.simeal.sdi.tabelle.application.model.TurnoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TurnoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.TurnoPersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class TurnoPersistenceImpl extends TurnoSpecification implements TurnoPersistence {
	
	private final Logger log = LoggerFactory.getLogger(TurnoPersistenceImpl.class);
	
	@Autowired
	private TurnoRepository turnoRepository;
	
	@Autowired
	private TurnoEntityMapper entityMapper;
	
	@Override
	public TurnoModel save(TurnoModel turnoModel) {
		log.debug("Request to save Turno: {}", turnoModel);
        TurnoEntity entityToSave = this.entityMapper.fromModelToEntity(turnoModel);
		TurnoEntity savedEntity = turnoRepository.save(entityToSave);
		return this.entityMapper.fromEntityToModel(savedEntity);
	}

	@Override
	public Page<TurnoModel> search(TurnoCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search Turno: {}", criteria);
        Page<TurnoEntity> entities = turnoRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }

}
