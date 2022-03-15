package it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.model.DietaModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.DietaCriteria;

public interface DietaPersistence  {
	
	DietaModel save(DietaModel model);
	
	Page<DietaModel> search(DietaCriteria criteria, Pageable pageRequest);
	
}
