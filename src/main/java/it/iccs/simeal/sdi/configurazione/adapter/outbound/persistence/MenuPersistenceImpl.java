package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper.MenuEntityMapper;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.MenuRepository;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.MenuEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.specification.MenuSpecification;
import it.iccs.simeal.sdi.configurazione.application.model.MenuModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.MenuCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence.MenuPersistence;
import lombok.RequiredArgsConstructor;

@Service
@Transactional
@RequiredArgsConstructor
public class MenuPersistenceImpl extends MenuSpecification implements MenuPersistence {
	
	private final Logger log = LoggerFactory.getLogger(MenuPersistenceImpl.class);
	
	@Autowired
	private MenuRepository menuRepository;
	
	@Autowired
	private MenuEntityMapper entityMapper;
	
	@Override
	public MenuModel save(MenuModel menuModel) {
		log.debug("Request to save Menu: {}", menuModel);
        MenuEntity entityToSave = this.entityMapper.fromModelToEntity(menuModel);
        MenuEntity savedEntity = menuRepository.save(entityToSave);
        return this.entityMapper.fromEntityToModel(savedEntity);
	}
	
	@Override
	public Page<MenuModel> search(MenuCriteria criteria, Pageable pageRequest) {
		log.debug("Request to search Menu: {}", criteria);
        Page<MenuEntity> entities = menuRepository.findAll(this.filter(criteria), pageRequest);
        return entities.map(entity -> this.entityMapper.fromEntityToModel(entity));
    }

}
