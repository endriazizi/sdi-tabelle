package it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.configurazione.application.model.ChiusuraModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ChiusuraCriteria;

public interface ChiusuraPersistence {
	
	ChiusuraModel save(ChiusuraModel model);
	
	Page<ChiusuraModel> search(ChiusuraCriteria criteria, Pageable pageRequest);

}
