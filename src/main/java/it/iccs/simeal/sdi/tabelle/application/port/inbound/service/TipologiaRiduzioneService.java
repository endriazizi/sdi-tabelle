package it.iccs.simeal.sdi.tabelle.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaRiduzioneCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaRiduzioneCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaRiduzioneDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaRiduzioneUpdateDTO;

public interface TipologiaRiduzioneService {
	
	TipologiaRiduzioneDTO create(TipologiaRiduzioneCreateDTO dto);
	
	List<TipologiaRiduzioneDTO> findByIds(List<UUID> ids);
	
	Page<TipologiaRiduzioneDTO> search(TipologiaRiduzioneCriteria criteria, Pageable pageRequest);
	
	TipologiaRiduzioneDTO update(TipologiaRiduzioneUpdateDTO dto);
	
	void delete(UUID id);

}
