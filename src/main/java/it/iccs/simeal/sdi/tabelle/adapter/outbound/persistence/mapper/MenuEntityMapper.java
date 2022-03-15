package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.MenuEntity;
import it.iccs.simeal.sdi.tabelle.application.model.MenuModel;

@Component
@Mapper
public interface MenuEntityMapper extends EntityMapper<MenuEntity, MenuModel> {
	
	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	MenuEntity fromModelToEntity(MenuModel model);
	
}
