package it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.model.TipologiaIstitutoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaIstitutoCriteria;

public interface TipologiaIstitutoPersistence {
	
	TipologiaIstitutoModel save(TipologiaIstitutoModel model);
	
	Page<TipologiaIstitutoModel> search(TipologiaIstitutoCriteria criteria, Pageable pageRequest);
	
}
