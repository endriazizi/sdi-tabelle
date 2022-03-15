package it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.configurazione.application.model.IstitutoModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.IstitutoCriteria;

public interface IstitutoPersistence {
	
	IstitutoModel save(IstitutoModel model);
	
	Page<IstitutoModel> search(IstitutoCriteria criteria, Pageable pageRequest);
	
}
