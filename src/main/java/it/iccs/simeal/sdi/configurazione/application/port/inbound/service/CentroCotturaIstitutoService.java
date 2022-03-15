package it.iccs.simeal.sdi.configurazione.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.CentroCotturaIstitutoCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.CentroCotturaIstitutoCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.CentroCotturaIstitutoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.CentroCotturaIstitutoUpdateDTO;

public interface CentroCotturaIstitutoService {
	
	CentroCotturaIstitutoDTO create(CentroCotturaIstitutoCreateDTO dto);
	
	List<CentroCotturaIstitutoDTO> findByIds(List<UUID> ids);
	
	Page<CentroCotturaIstitutoDTO> search(CentroCotturaIstitutoCriteria criteria, Pageable pageRequest);
	
	CentroCotturaIstitutoDTO update(CentroCotturaIstitutoUpdateDTO dto);
	
	void delete(UUID id);

}
