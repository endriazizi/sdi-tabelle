package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.AperturaEntity;
import it.iccs.simeal.sdi.configurazione.application.model.AperturaModel;

@Component
@Mapper
public interface AperturaEntityMapper extends EntityMapper<AperturaEntity, AperturaModel> {
	
	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	AperturaEntity fromModelToEntity(AperturaModel model);

}
