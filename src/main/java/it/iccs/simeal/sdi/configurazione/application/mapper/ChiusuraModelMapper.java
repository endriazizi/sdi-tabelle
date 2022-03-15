package it.iccs.simeal.sdi.configurazione.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.configurazione.application.model.ChiusuraModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ChiusuraCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ChiusuraDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ChiusuraUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface ChiusuraModelMapper extends ModelMapper<ChiusuraDTO, ChiusuraModel> {
	
	default ChiusuraModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new ChiusuraModel().setId(id);
	}
	
	ChiusuraDTO fromCreateDto(ChiusuraCreateDTO dto);

	ChiusuraDTO fromUpdateDto(ChiusuraUpdateDTO dto);
	
}
