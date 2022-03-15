package it.iccs.simeal.sdi.tabelle.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseUpdateDTO;

public interface ClasseService {
	
	ClasseDTO create(ClasseCreateDTO dto);
	
	List<ClasseDTO> findByIds(List<UUID> ids);
	
	Page<ClasseDTO> search(ClasseCriteria criteria, Pageable pageRequest);
	
	ClasseDTO update(ClasseUpdateDTO dto);
	
	void delete(UUID id);
	
}
