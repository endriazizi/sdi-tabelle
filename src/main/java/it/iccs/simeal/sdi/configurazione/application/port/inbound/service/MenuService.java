package it.iccs.simeal.sdi.configurazione.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.MenuCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.MenuCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.MenuDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.MenuUpdateDTO;

public interface MenuService {
	
	MenuDTO create(MenuCreateDTO dto);
	
	List<MenuDTO> findByIds(List<UUID> ids);
	
	Page<MenuDTO> search(MenuCriteria criteria, Pageable pageRequest);
	
	MenuDTO update(MenuUpdateDTO dto);
	
	void delete(UUID id);
	
}
