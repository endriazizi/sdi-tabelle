package it.iccs.simeal.sdi.tabelle.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.SezioneCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.SezioneCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.SezioneDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.SezioneUpdateDTO;

public interface SezioneService {
	
	SezioneDTO create(SezioneCreateDTO dto);
	
	List<SezioneDTO> findByIds(List<UUID> ids);
	
	Page<SezioneDTO> search(SezioneCriteria criteria, Pageable pageRequest);
	
	SezioneDTO update(SezioneUpdateDTO dto);
	
	void delete(UUID id);
	
}
