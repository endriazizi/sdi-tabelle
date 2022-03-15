package it.iccs.simeal.sdi.configurazione.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.configurazione.application.model.ClasseComposizioneModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface ClasseComposizioneModelMapper extends ModelMapper<ClasseComposizioneDTO, ClasseComposizioneModel> {
	
	default ClasseComposizioneModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new ClasseComposizioneModel().setId(id);
	}
	
	ClasseComposizioneDTO fromCreateDto(ClasseComposizioneCreateDTO dto);

	ClasseComposizioneDTO fromUpdateDto(ClasseComposizioneUpdateDTO dto);
	
}
