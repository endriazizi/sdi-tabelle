package it.iccs.simeal.sdi.configurazione.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.configurazione.application.model.ServizioModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface ServizioModelMapper extends ModelMapper<ServizioDTO, ServizioModel> {
	
	default ServizioModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new ServizioModel().setId(id);
	}
	
	ServizioDTO fromCreateDto(ServizioCreateDTO dto);

	ServizioDTO fromUpdateDto(ServizioUpdateDTO dto);
	
}
