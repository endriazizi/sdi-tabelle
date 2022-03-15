package it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.configurazione.application.model.ClasseModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseCriteria;

public interface ClassePersistence {
	
	ClasseModel save(ClasseModel model);
	
	Page<ClasseModel> search(ClasseCriteria criteria, Pageable pageRequest);
	
}
