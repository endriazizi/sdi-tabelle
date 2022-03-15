package it.iccs.simeal.sdi.configurazione.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.iccs.simeal.sdi.configurazione.application.mapper.MenuModelMapper;
import it.iccs.simeal.sdi.configurazione.application.model.MenuModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.MenuService;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.MenuCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.MenuCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.MenuDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.MenuUpdateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence.MenuPersistence;
import it.iccs.simeal.sdi.configurazione.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class MenuServiceImpl implements MenuService {

	@Autowired
	private MenuModelMapper menuModelMapper;
	
	@Autowired
	private MenuPersistence menuPersistence;
	
	@Override
	public MenuDTO create(MenuCreateDTO dto) {
		MenuDTO menuDTO = menuModelMapper.fromCreateDto(dto);
        MenuModel menuModel = menuModelMapper.toModel(menuDTO);
        MenuModel model = menuPersistence.save(menuModel);
        return menuModelMapper.toDto(model);
	}

	@Override
	public List<MenuDTO> findByIds(List<UUID> ids) {
		MenuCriteria criteria = new MenuCriteria().setId(ids);
		Page<MenuModel> models = menuPersistence.search(criteria, PageRequest.ofSize(10));
		return models.map(model -> this.menuModelMapper.toDto(model)).getContent();
	}

	@Override
	public Page<MenuDTO> search(MenuCriteria criteria, Pageable pageRequest) {
		Page<MenuModel> models = menuPersistence.search(criteria, pageRequest);
		return models.map(model -> this.menuModelMapper.toDto(model));
	}

	@Override
	public MenuDTO update(MenuUpdateDTO dto) {
		MenuDTO menuDTO = menuModelMapper.fromUpdateDto(dto);
        this.checkMenuExists(menuDTO.getId());		
        MenuModel menuModel = menuModelMapper.toModel(menuDTO);
        menuPersistence.save(menuModel);
        
        MenuCriteria criteria = new MenuCriteria().setId(Collections.singletonList(menuDTO.getId()));
		Page<MenuModel> models = menuPersistence.search(criteria, PageRequest.ofSize(10));
        MenuModel model = models
        		.getContent()
                .stream()
                .findAny()
                .orElse(null);
        return menuModelMapper.toDto(model);
	}
	
	@Override
	public void delete(UUID id) {
		this.checkMenuExists(id);
		MenuDTO menuDTO = this.findByIds(Collections.singletonList(id))
				.stream()
				.findAny()
				.orElse(null);
		menuDTO.setFlagElimina((short)1);
		
		MenuModel menuModel = menuModelMapper.toModel(menuDTO);
		menuPersistence.save(menuModel);
	}
	
	private void checkMenuExists(UUID id) {
		MenuCriteria criteria = new MenuCriteria().setId(Collections.singletonList(id));
		if (menuPersistence.search(criteria, PageRequest.ofSize(10)).isEmpty()) {
			log.warn("Menu {} not found", id);
			throw new NotFoundException(String.format("Menu %s not found", id));
		}
	}

}
