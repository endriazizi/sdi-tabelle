package it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.model.PastoAlternativoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.PastoAlternativoCriteria;

public interface PastoAlternativoPersistence {
	
	PastoAlternativoModel save(PastoAlternativoModel model);
	
	Page<PastoAlternativoModel> search(PastoAlternativoCriteria criteria, Pageable pageRequest);
	
}
