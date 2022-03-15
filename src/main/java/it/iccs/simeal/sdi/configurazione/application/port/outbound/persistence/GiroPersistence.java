package it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.configurazione.application.model.GiroModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.GiroCriteria;

public interface GiroPersistence  {
	
	GiroModel save(GiroModel model);
	
	Page<GiroModel> search(GiroCriteria criteria, Pageable pageRequest);
	
}
