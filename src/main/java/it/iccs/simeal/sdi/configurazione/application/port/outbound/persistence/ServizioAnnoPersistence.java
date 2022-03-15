package it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.ServizioAnnoRepository;
import it.iccs.simeal.sdi.configurazione.application.model.ServizioAnnoModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioAnnoCriteria;

public interface ServizioAnnoPersistence {
	
	ServizioAnnoModel save(ServizioAnnoModel model);
	
	Page<ServizioAnnoModel> search(ServizioAnnoCriteria criteria, Pageable pageRequest);
		
	void delete(UUID id);

}
