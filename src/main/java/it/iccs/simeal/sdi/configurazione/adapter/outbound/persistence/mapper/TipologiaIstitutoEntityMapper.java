package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.TipologiaIstitutoEntity;
import it.iccs.simeal.sdi.configurazione.application.model.TipologiaIstitutoModel;

@Component
@Mapper
public interface TipologiaIstitutoEntityMapper extends EntityMapper<TipologiaIstitutoEntity, TipologiaIstitutoModel> {
	
	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	TipologiaIstitutoEntity fromModelToEntity(TipologiaIstitutoModel model);
	
}
