package it.iccs.simeal.sdi.tabelle.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioUpdateDTO;

public interface ServizioService {
	
	ServizioDTO create(ServizioCreateDTO dto);
	
	List<ServizioDTO> findByIds(List<UUID> ids);
	
	Page<ServizioDTO> search(ServizioCriteria criteria, Pageable pageRequest);
	
	ServizioDTO update(ServizioUpdateDTO dto);
	
	void delete(UUID id);
	
}
