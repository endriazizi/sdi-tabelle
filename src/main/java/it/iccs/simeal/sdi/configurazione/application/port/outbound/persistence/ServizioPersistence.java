package it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.configurazione.application.model.ServizioModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioCriteria;

public interface ServizioPersistence {
	
	ServizioModel save(ServizioModel model);
	
//	List<SezioneModel> findByIds(List<UUID> ids);
	
	Page<ServizioModel> search(ServizioCriteria criteria, Pageable pageRequest);

	
//	void delete(UUID id);

}
