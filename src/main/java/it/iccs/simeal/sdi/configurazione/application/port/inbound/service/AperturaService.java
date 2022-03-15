package it.iccs.simeal.sdi.configurazione.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AperturaCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AperturaCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AperturaDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AperturaUpdateDTO;

public interface AperturaService {
	
	AperturaDTO create(AperturaCreateDTO dto);
	
	List<AperturaDTO> findByIds(List<UUID> ids);
	
	Page<AperturaDTO> search(AperturaCriteria criteria, Pageable pageRequest);
	
	AperturaDTO update(AperturaUpdateDTO dto);
	
	AperturaDTO delete(UUID id);
	
}
