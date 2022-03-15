package it.iccs.simeal.sdi.tabelle.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.tabelle.application.model.MenuModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.MenuCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.MenuDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.MenuUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface MenuModelMapper extends ModelMapper<MenuDTO, MenuModel> {
	
	default MenuModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new MenuModel().setId(id);
	}
	
	MenuDTO fromCreateDto(MenuCreateDTO dto);

	MenuDTO fromUpdateDto(MenuUpdateDTO dto);
	
}
