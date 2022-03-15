package it.iccs.simeal.sdi.configurazione.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AnnoCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AnnoCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AnnoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AnnoUpdateDTO;

public interface AnnoService {
	
	AnnoDTO create(AnnoCreateDTO dto);
	
	List<AnnoDTO> findByIds(List<UUID> ids);
	
	Page<AnnoDTO> search(AnnoCriteria criteria, Pageable pageRequest);
	
	AnnoDTO update(AnnoUpdateDTO dto);
	
	void delete(UUID id);
	
}
