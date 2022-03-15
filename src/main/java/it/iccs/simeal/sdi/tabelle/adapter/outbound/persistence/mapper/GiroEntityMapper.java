package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.GiroEntity;
import it.iccs.simeal.sdi.tabelle.application.model.GiroModel;

@Component
@Mapper
public interface GiroEntityMapper extends EntityMapper<GiroEntity, GiroModel> {
	
	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	GiroEntity fromModelToEntity(GiroModel model);
	
}
