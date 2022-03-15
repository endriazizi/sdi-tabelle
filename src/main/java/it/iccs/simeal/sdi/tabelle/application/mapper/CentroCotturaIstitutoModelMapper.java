package it.iccs.simeal.sdi.tabelle.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.tabelle.application.model.CentroCotturaIstitutoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaIstitutoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaIstitutoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaIstitutoUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface CentroCotturaIstitutoModelMapper extends ModelMapper<CentroCotturaIstitutoDTO, CentroCotturaIstitutoModel> {
	
	default CentroCotturaIstitutoModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new CentroCotturaIstitutoModel().setId(id);
	}
	
	CentroCotturaIstitutoDTO fromCreateDto(CentroCotturaIstitutoCreateDTO dto);

	CentroCotturaIstitutoDTO fromUpdateDto(CentroCotturaIstitutoUpdateDTO dto);
	
}
