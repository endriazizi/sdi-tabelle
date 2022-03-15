package it.iccs.simeal.sdi.configurazione.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.configurazione.application.model.TurnoModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TurnoCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TurnoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TurnoUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface TurnoModelMapper extends ModelMapper<TurnoDTO, TurnoModel> {
	
	default TurnoModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new TurnoModel().setId(id);
	}
	
	TurnoDTO fromCreateDto(TurnoCreateDTO dto);

	TurnoDTO fromUpdateDto(TurnoUpdateDTO dto);
	
}
