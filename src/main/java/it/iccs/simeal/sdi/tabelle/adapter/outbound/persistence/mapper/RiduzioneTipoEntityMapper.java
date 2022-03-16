package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.mapper;


import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.RiduzioneTipoEntity;
import it.iccs.simeal.sdi.tabelle.application.model.RiduzioneTipoModel;

@Component
@Mapper
public interface RiduzioneTipoEntityMapper extends EntityMapper<RiduzioneTipoEntity, RiduzioneTipoModel> {

    @Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
    RiduzioneTipoEntity fromModelToEntity(RiduzioneTipoModel model);

}
