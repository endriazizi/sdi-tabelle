package it.iccs.simeal.sdi.configurazione.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.configurazione.application.model.DietaModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.DietaCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.DietaDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.DietaUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface DietaModelMapper extends ModelMapper<DietaDTO, DietaModel> {
	
	default DietaModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new DietaModel().setId(id);
	}
	
	DietaDTO fromCreateDto(DietaCreateDTO dto);

	DietaDTO fromUpdateDto(DietaUpdateDTO dto);
	
}
