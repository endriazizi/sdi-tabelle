package it.iccs.simeal.sdi.configurazione.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.configurazione.application.model.ClasseComposizioneAnnoModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneAnnoCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneAnnoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneAnnoUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface ClasseComposizioneAnnoModelMapper extends ModelMapper<ClasseComposizioneAnnoDTO, ClasseComposizioneAnnoModel> {
	
	default ClasseComposizioneAnnoModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new ClasseComposizioneAnnoModel().setId(id);
	}
	
	ClasseComposizioneAnnoDTO fromCreateDto(ClasseComposizioneAnnoCreateDTO dto);

	ClasseComposizioneAnnoDTO fromUpdateDto(ClasseComposizioneAnnoUpdateDTO dto);
	
}
