package it.iccs.simeal.sdi.tabelle.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseComposizioneCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseComposizioneCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseComposizioneDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseComposizioneUpdateDTO;

public interface ClasseComposizioneService {
	
	ClasseComposizioneDTO create(ClasseComposizioneCreateDTO dto);
	
	List<ClasseComposizioneDTO> findByIds(List<UUID> ids);
	
	Page<ClasseComposizioneDTO> search(ClasseComposizioneCriteria criteria, Pageable pageRequest);
	
	ClasseComposizioneDTO update(ClasseComposizioneUpdateDTO dto);
	
	ClasseComposizioneDTO delete(UUID id);
	
}
