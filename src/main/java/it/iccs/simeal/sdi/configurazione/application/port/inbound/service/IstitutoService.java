package it.iccs.simeal.sdi.configurazione.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.IstitutoCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.IstitutoCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.IstitutoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.IstitutoUpdateDTO;

public interface IstitutoService {
	
	IstitutoDTO create(IstitutoCreateDTO dto);
	
	List<IstitutoDTO> findByIds(List<UUID> ids);
	
	Page<IstitutoDTO> search(IstitutoCriteria criteria, Pageable pageRequest);
	
	IstitutoDTO update(IstitutoUpdateDTO dto);
	
	void delete(UUID id);
	
}
