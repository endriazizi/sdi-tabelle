package it.iccs.simeal.sdi.configurazione.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.configurazione.application.model.AperturaModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AperturaCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AperturaDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AperturaUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface AperturaModelMapper extends ModelMapper<AperturaDTO, AperturaModel> {
	
	default AperturaModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new AperturaModel().setId(id);
	}
	
	AperturaDTO fromCreateDto(AperturaCreateDTO dto);

	AperturaDTO fromUpdateDto(AperturaUpdateDTO dto);
	
}
