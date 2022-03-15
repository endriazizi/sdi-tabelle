package it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.model.ServizioModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioCriteria;

public interface ServizioPersistence {
	
	ServizioModel save(ServizioModel model);
	
//	List<SezioneModel> findByIds(List<UUID> ids);
	
	Page<ServizioModel> search(ServizioCriteria criteria, Pageable pageRequest);

	
//	void delete(UUID id);

}
