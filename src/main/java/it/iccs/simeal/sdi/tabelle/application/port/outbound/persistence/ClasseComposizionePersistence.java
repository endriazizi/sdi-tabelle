package it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.model.ClasseComposizioneModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseComposizioneCriteria;

public interface ClasseComposizionePersistence {
	
	ClasseComposizioneModel save(ClasseComposizioneModel model);
	
	Page<ClasseComposizioneModel> search(ClasseComposizioneCriteria criteria, Pageable pageRequest);

}
