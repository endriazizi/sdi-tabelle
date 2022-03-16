package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.mapper.TariffaTipoEntityMapper;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.TariffaTipoRepository;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.TariffaTipoEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification.TariffaTipoSpecification;
import it.iccs.simeal.sdi.tabelle.application.model.TariffaTipoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TariffaTipoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.TariffaTipoPersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class TariffaTipoPersistenceImpl extends TariffaTipoSpecification implements TariffaTipoPersistence {

    private final Logger log = LoggerFactory.getLogger(TariffaTipoPersistenceImpl.class);

    @Autowired
    private TariffaTipoRepository tariffaTipoRepository;

    @Autowired
    private TariffaTipoEntityMapper entityMapper;

    @Override
    public TariffaTipoModel save(TariffaTipoModel tariffaTipoModel) {
        log.debug("Request to save TipologiaTariffa: {}", tariffaTipoModel);
        TariffaTipoEntity entityToSave = this.entityMapper.fromModelToEntity(tariffaTipoModel);
        TariffaTipoEntity savedEntity = tariffaTipoRepository.save(entityToSave);
        return this.entityMapper.fromEntityToModel(savedEntity);
    }

    @Override
    public Page<TariffaTipoModel> search(TariffaTipoCriteria criteria, Pageable pageRequest) {
        log.debug("Request to search TipologiaTariffa: {}", criteria);
        Page<TariffaTipoEntity> entities = tariffaTipoRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }

}
