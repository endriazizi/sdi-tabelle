package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.ChiusuraEntity;
import it.iccs.simeal.sdi.tabelle.application.model.ChiusuraModel;

@Component
@Mapper
public interface ChiusuraEntityMapper extends EntityMapper<ChiusuraEntity, ChiusuraModel> {
	
	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	ChiusuraEntity fromModelToEntity(ChiusuraModel model);

}
