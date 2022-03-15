package it.iccs.simeal.sdi.configurazione.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.configurazione.application.model.SezioneModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.SezioneCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.SezioneDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.SezioneUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface SezioneModelMapper extends ModelMapper<SezioneDTO, SezioneModel> {
	
	default SezioneModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new SezioneModel().setId(id);
	}
	
	SezioneDTO fromCreateDto(SezioneCreateDTO dto);

	SezioneDTO fromUpdateDto(SezioneUpdateDTO dto);
	
}
