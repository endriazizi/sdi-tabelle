package it.iccs.simeal.sdi.tabelle.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.tabelle.application.model.AnnoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.AnnoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.AnnoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.AnnoUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface AnnoModelMapper extends ModelMapper<AnnoDTO, AnnoModel> {
	
	default AnnoModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new AnnoModel().setId(id);
	}
	
	AnnoDTO fromCreateDto(AnnoCreateDTO dto);

	AnnoDTO fromUpdateDto(AnnoUpdateDTO dto);
	
}
