package it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.configurazione.application.model.RefettorioModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.RefettorioCriteria;

public interface RefettorioPersistence {
	
	RefettorioModel save(RefettorioModel model);
	
	Page<RefettorioModel> search(RefettorioCriteria criteria, Pageable pageRequest);

}
