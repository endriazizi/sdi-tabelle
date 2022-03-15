package it.iccs.simeal.sdi.tabelle.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaUpdateDTO;

public interface CentroCotturaService {
	
	CentroCotturaDTO create(CentroCotturaCreateDTO dto);
	
	List<CentroCotturaDTO> findByIds(List<UUID> ids);
	
	Page<CentroCotturaDTO> search(CentroCotturaCriteria criteria, Pageable pageRequest);
	
	CentroCotturaDTO update(CentroCotturaUpdateDTO dto);
	
	void delete(UUID id);
	
}
