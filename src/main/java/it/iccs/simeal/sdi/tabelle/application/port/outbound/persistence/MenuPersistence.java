package it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.model.MenuModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.MenuCriteria;

public interface MenuPersistence {
	
	MenuModel save(MenuModel model);
	
	Page<MenuModel> search(MenuCriteria criteria, Pageable pageRequest);
	
}
