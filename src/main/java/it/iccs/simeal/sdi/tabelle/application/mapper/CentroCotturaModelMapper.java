package it.iccs.simeal.sdi.tabelle.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.tabelle.application.model.CentroCotturaModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface CentroCotturaModelMapper extends ModelMapper<CentroCotturaDTO, CentroCotturaModel> {
	
	default CentroCotturaModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new CentroCotturaModel().setId(id);
	}
	
	CentroCotturaDTO fromCreateDto(CentroCotturaCreateDTO dto);

	CentroCotturaDTO fromUpdateDto(CentroCotturaUpdateDTO dto);
	
}
