package it.iccs.simeal.sdi.tabelle.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.tabelle.application.model.TipologiaIstitutoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaIstitutoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaIstitutoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaIstitutoUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface TipologiaIstitutoModelMapper extends ModelMapper<TipologiaIstitutoDTO, TipologiaIstitutoModel> {
	
	default TipologiaIstitutoModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new TipologiaIstitutoModel().setId(id);
	}
	
	TipologiaIstitutoDTO fromCreateDto(TipologiaIstitutoCreateDTO dto);

	TipologiaIstitutoDTO fromUpdateDto(TipologiaIstitutoUpdateDTO dto);
	
}
