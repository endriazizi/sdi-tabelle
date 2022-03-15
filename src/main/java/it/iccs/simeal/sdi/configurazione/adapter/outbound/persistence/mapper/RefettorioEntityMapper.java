package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.RefettorioEntity;
import it.iccs.simeal.sdi.configurazione.application.model.RefettorioModel;

@Component
@Mapper
public interface RefettorioEntityMapper extends EntityMapper<RefettorioEntity, RefettorioModel> {
	
	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	RefettorioEntity fromModelToEntity(RefettorioModel model);
	
}
