package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.mapper.RiduzioneTipoEntityMapper;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.RiduzioneTipoRepository;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.RiduzioneTipoEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification.RiduzioneTipoSpecification;
import it.iccs.simeal.sdi.tabelle.application.model.RiduzioneTipoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RiduzioneTipoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.RiduzioneTipoPersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class RiduzioneTipoPersistenceImpl extends RiduzioneTipoSpecification implements RiduzioneTipoPersistence {

    private final Logger log = LoggerFactory.getLogger(RiduzioneTipoPersistenceImpl.class);

    @Autowired
    private RiduzioneTipoRepository riduzioneTipoRepository;

    @Autowired
    private RiduzioneTipoEntityMapper entityMapper;

    @Override
    public RiduzioneTipoModel save(RiduzioneTipoModel riduzioneTipoModel) {
        log.debug("Request to save TipologiaRiduzione: {}", riduzioneTipoModel);
        RiduzioneTipoEntity entityToSave = this.entityMapper.fromModelToEntity(riduzioneTipoModel);
        RiduzioneTipoEntity savedEntity = riduzioneTipoRepository.save(entityToSave);
        return this.entityMapper.fromEntityToModel(savedEntity);
    }

    @Override
    public Page<RiduzioneTipoModel> search(RiduzioneTipoCriteria criteria, Pageable pageRequest) {
        log.debug("Request to search TipologiaRiduzione: {}", criteria);
        Page<RiduzioneTipoEntity> entities = riduzioneTipoRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }

}