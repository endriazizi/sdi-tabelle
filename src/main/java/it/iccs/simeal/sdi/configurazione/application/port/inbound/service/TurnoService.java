package it.iccs.simeal.sdi.configurazione.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TurnoCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TurnoCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TurnoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TurnoUpdateDTO;

public interface TurnoService {
	
	TurnoDTO create(TurnoCreateDTO dto);
	
	List<TurnoDTO> findByIds(List<UUID> ids);
	
	Page<TurnoDTO> search(TurnoCriteria criteria, Pageable pageRequest);
	
	TurnoDTO update(TurnoUpdateDTO dto);
	
	void delete(UUID id);
	
}
