package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.ClasseEntity;
import it.iccs.simeal.sdi.tabelle.application.model.ClasseModel;

@Component
@Mapper
public interface ClasseEntityMapper extends EntityMapper<ClasseEntity, ClasseModel> {
	
	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	ClasseEntity fromModelToEntity(ClasseModel model);
	
}
