package it.iccs.simeal.sdi.tabelle.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.tabelle.application.model.TipologiaRiduzioneModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaRiduzioneCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaRiduzioneDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaRiduzioneUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface TipologiaRiduzioneModelMapper extends ModelMapper<TipologiaRiduzioneDTO, TipologiaRiduzioneModel> {
	
	default TipologiaRiduzioneModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new TipologiaRiduzioneModel().setId(id);
	}
	
	TipologiaRiduzioneDTO fromCreateDto(TipologiaRiduzioneCreateDTO dto);

	TipologiaRiduzioneDTO fromUpdateDto(TipologiaRiduzioneUpdateDTO dto);
	
}
