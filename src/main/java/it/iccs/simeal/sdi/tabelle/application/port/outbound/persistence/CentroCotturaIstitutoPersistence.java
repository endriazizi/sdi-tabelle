package it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence;

import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.model.CentroCotturaIstitutoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaIstitutoCriteria;

public interface CentroCotturaIstitutoPersistence {
	
	CentroCotturaIstitutoModel save(CentroCotturaIstitutoModel model);
	
	Page<CentroCotturaIstitutoModel> search(CentroCotturaIstitutoCriteria criteria, Pageable pageRequest);

	void delete(UUID id);
}
