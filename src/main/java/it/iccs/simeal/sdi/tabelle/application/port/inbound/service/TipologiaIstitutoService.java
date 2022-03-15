package it.iccs.simeal.sdi.tabelle.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaIstitutoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaIstitutoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaIstitutoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaIstitutoUpdateDTO;

public interface TipologiaIstitutoService {
	
	TipologiaIstitutoDTO create(TipologiaIstitutoCreateDTO dto);
	
	List<TipologiaIstitutoDTO> findByIds(List<UUID> ids);
	
	Page<TipologiaIstitutoDTO> search(TipologiaIstitutoCriteria criteria, Pageable pageRequest);
	
	TipologiaIstitutoDTO update(TipologiaIstitutoUpdateDTO dto);
	
	void delete(UUID id);
	
}
