package it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.model.CentroCotturaModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaCriteria;

public interface CentroCotturaPersistence {
	
	CentroCotturaModel save(CentroCotturaModel model);
	
	Page<CentroCotturaModel> search(CentroCotturaCriteria criteria, Pageable pageRequest);
	
}
