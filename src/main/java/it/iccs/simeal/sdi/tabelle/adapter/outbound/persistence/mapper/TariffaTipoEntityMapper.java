package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.TariffaTipoEntity;
import it.iccs.simeal.sdi.tabelle.application.model.TariffaTipoModel;

@Component
@Mapper
public interface TariffaTipoEntityMapper extends EntityMapper<TariffaTipoEntity, TariffaTipoModel> {

    @Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
    TariffaTipoEntity fromModelToEntity(TariffaTipoModel model);

}