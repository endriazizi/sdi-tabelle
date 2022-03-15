package it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.configurazione.application.model.AperturaModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AperturaCriteria;

public interface AperturaPersistence {
	
	AperturaModel save(AperturaModel model);
	
	Page<AperturaModel> search(AperturaCriteria criteria, Pageable pageRequest);

}
