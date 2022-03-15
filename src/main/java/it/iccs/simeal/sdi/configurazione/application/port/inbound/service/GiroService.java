package it.iccs.simeal.sdi.configurazione.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioGiroCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.GiroCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.GiroDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.GiroUpdateDTO;

public interface GiroService {
	
	GiroDTO create(ServizioGiroCreateDTO dto);
	
	List<GiroDTO> findByIds(List<UUID> ids);
	
	Page<GiroDTO> search(GiroCriteria criteria, Pageable pageRequest);
	
	GiroDTO update(GiroUpdateDTO dto);
	
	void delete(UUID id);

}
