package it.iccs.simeal.sdi.configurazione.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.configurazione.application.model.RefettorioModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.RefettorioCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.RefettorioDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.RefettorioUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface RefettorioModelMapper extends ModelMapper<RefettorioDTO, RefettorioModel> {
	
	default RefettorioModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new RefettorioModel().setId(id);
	}
	
	RefettorioDTO fromCreateDto(RefettorioCreateDTO dto);

	RefettorioDTO fromUpdateDto(RefettorioUpdateDTO dto);
	
}
