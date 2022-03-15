package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.IstitutoEntity;
import it.iccs.simeal.sdi.tabelle.application.model.IstitutoModel;

@Component
@Mapper
public interface IstitutoEntityMapper extends EntityMapper<IstitutoEntity, IstitutoModel> {
	
	@Mapping(target = "sicraCodiceVia", source="sicraCodiceVia", defaultValue = "1")
	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	IstitutoEntity fromModelToEntity(IstitutoModel model);
	
}
