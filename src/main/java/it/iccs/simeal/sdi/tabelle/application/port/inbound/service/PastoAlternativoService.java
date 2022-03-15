package it.iccs.simeal.sdi.tabelle.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.PastoAlternativoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.PastoAlternativoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.PastoAlternativoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.PastoAlternativoUpdateDTO;

public interface PastoAlternativoService {
	
	PastoAlternativoDTO create(PastoAlternativoCreateDTO dto);
	
	List<PastoAlternativoDTO> findByIds(List<UUID> ids);
	
	Page<PastoAlternativoDTO> search(PastoAlternativoCriteria criteria, Pageable pageRequest);
	
	PastoAlternativoDTO update(PastoAlternativoUpdateDTO dto);
	
	void delete(UUID id);
	
}
