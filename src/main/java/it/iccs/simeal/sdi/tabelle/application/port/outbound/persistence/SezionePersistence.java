package it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.model.SezioneModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.SezioneCriteria;

public interface SezionePersistence {
	
	SezioneModel save(SezioneModel model);
	
//	List<SezioneModel> findByIds(List<UUID> ids);
	
	Page<SezioneModel> search(SezioneCriteria criteria, Pageable pageRequest);
	
//	void delete(UUID id);

}
