package it.iccs.simeal.sdi.tabelle.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseComposizioneAnnoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseComposizioneAnnoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseComposizioneAnnoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseComposizioneAnnoUpdateDTO;

public interface ClasseComposizioneAnnoService {
	
	ClasseComposizioneAnnoDTO create(ClasseComposizioneAnnoCreateDTO dto);
	
	List<ClasseComposizioneAnnoDTO> findByIds(List<UUID> ids);
	
	Page<ClasseComposizioneAnnoDTO> search(ClasseComposizioneAnnoCriteria criteria, Pageable pageRequest);
	
	ClasseComposizioneAnnoDTO update(ClasseComposizioneAnnoUpdateDTO dto);
	
	void delete(UUID id);

}
