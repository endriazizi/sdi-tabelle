package it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.configurazione.application.model.ClasseComposizioneAnnoModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneAnnoCriteria;

public interface ClasseComposizioneAnnoPersistence {
	
	ClasseComposizioneAnnoModel save(ClasseComposizioneAnnoModel model);
	
	Page<ClasseComposizioneAnnoModel> search(ClasseComposizioneAnnoCriteria criteria, Pageable pageRequest);

}
