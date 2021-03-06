package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.DietaEntity;
import it.iccs.simeal.sdi.tabelle.application.model.DietaModel;

@Component
@Mapper
public interface DietaEntityMapper extends EntityMapper<DietaEntity, DietaModel> {
	
	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	DietaEntity fromModelToEntity(DietaModel model);
	
}
