package it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.configurazione.application.model.TipologiaRiduzioneModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TipologiaRiduzioneCriteria;

public interface TipologiaRiduzionePersistence  {
	
	TipologiaRiduzioneModel save(TipologiaRiduzioneModel model);
	
	Page<TipologiaRiduzioneModel> search(TipologiaRiduzioneCriteria criteria, Pageable pageRequest);
	
}
