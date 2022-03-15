package it.iccs.simeal.sdi.tabelle.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioAnnoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioAnnoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioAnnoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioAnnoUpdateDTO;

public interface ServizioAnnoService {
	
	ServizioAnnoDTO create(ServizioAnnoCreateDTO dto);
	
	List<ServizioAnnoDTO> findByIds(List<UUID> ids);
	
	Page<ServizioAnnoDTO> search(ServizioAnnoCriteria criteria, Pageable pageRequest);
	
	ServizioAnnoDTO update(ServizioAnnoUpdateDTO dto);
	
	void delete(UUID id);
	
}
