package it.iccs.simeal.sdi.configurazione.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.configurazione.application.model.GiroModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioGiroCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.GiroDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.GiroUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface GiroModelMapper extends ModelMapper<GiroDTO, GiroModel> {
	
	default GiroModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new GiroModel().setId(id);
	}
	
	GiroDTO fromCreateDto(ServizioGiroCreateDTO dto);

	GiroDTO fromUpdateDto(GiroUpdateDTO dto);
	
}
