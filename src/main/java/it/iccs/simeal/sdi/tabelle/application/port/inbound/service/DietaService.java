package it.iccs.simeal.sdi.tabelle.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.DietaCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.DietaCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.DietaDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.DietaUpdateDTO;

public interface DietaService {
	
	DietaDTO create(DietaCreateDTO dto);
	
	List<DietaDTO> findByIds(List<UUID> ids);
	
	Page<DietaDTO> search(DietaCriteria criteria, Pageable pageRequest);
	
	DietaDTO update(DietaUpdateDTO dto);
	
	void delete(UUID id);

}
