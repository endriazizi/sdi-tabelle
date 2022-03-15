package it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.configurazione.application.model.CentroCotturaModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.CentroCotturaCriteria;

public interface CentroCotturaPersistence {
	
	CentroCotturaModel save(CentroCotturaModel model);
	
	Page<CentroCotturaModel> search(CentroCotturaCriteria criteria, Pageable pageRequest);
	
}
