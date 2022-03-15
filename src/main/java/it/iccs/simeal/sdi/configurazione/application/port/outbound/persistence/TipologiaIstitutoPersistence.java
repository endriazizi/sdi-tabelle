package it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.configurazione.application.model.TipologiaIstitutoModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TipologiaIstitutoCriteria;

public interface TipologiaIstitutoPersistence {
	
	TipologiaIstitutoModel save(TipologiaIstitutoModel model);
	
	Page<TipologiaIstitutoModel> search(TipologiaIstitutoCriteria criteria, Pageable pageRequest);
	
}
