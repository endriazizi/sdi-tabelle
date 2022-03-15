package it.iccs.simeal.sdi.tabelle.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.tabelle.application.model.ServizioAnnoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioAnnoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioAnnoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioAnnoUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface ServizioAnnoModelMapper extends ModelMapper<ServizioAnnoDTO, ServizioAnnoModel> {
	
	default ServizioAnnoModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new ServizioAnnoModel().setId(id);
	}
	
	ServizioAnnoDTO fromCreateDto(ServizioAnnoCreateDTO dto);
	
	ServizioAnnoDTO fromUpdateDto(ServizioAnnoUpdateDTO dto);
	
}
