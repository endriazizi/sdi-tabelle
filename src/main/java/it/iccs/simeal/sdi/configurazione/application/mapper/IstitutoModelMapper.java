package it.iccs.simeal.sdi.configurazione.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.configurazione.application.model.IstitutoModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.IstitutoCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.IstitutoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.IstitutoUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface IstitutoModelMapper extends ModelMapper<IstitutoDTO, IstitutoModel> {
	
	default IstitutoModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new IstitutoModel().setId(id);
	}
	
	IstitutoDTO fromCreateDto(IstitutoCreateDTO dto);

	IstitutoDTO fromUpdateDto(IstitutoUpdateDTO dto);
	
}
