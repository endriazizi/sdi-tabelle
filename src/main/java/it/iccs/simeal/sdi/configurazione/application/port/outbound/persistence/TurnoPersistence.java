package it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.configurazione.application.model.TurnoModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TurnoCriteria;

public interface TurnoPersistence {
	
	TurnoModel save(TurnoModel model);
	
	Page<TurnoModel> search(TurnoCriteria criteria, Pageable pageRequest);

}
