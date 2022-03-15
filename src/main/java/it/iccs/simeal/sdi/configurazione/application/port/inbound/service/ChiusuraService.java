package it.iccs.simeal.sdi.configurazione.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ChiusuraCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ChiusuraCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ChiusuraDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ChiusuraUpdateDTO;

public interface ChiusuraService {
	
	ChiusuraDTO create(ChiusuraCreateDTO dto);
	
	List<ChiusuraDTO> findByIds(List<UUID> ids);
	
	Page<ChiusuraDTO> search(ChiusuraCriteria criteria, Pageable pageRequest);
	
	ChiusuraDTO update(ChiusuraUpdateDTO dto);
	
	ChiusuraDTO delete(UUID id);
	
}
