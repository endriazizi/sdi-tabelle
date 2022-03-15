package it.iccs.simeal.sdi.tabelle.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RefettorioCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RefettorioCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RefettorioDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RefettorioUpdateDTO;

public interface RefettorioService {
	
	RefettorioDTO create(RefettorioCreateDTO dto);
	
	List<RefettorioDTO> findByIds(List<UUID> ids);
	
	Page<RefettorioDTO> search(RefettorioCriteria criteria, Pageable pageRequest);
	
	RefettorioDTO update(RefettorioUpdateDTO dto);
	
	void delete(UUID id);
	
}
