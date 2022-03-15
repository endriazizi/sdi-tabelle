package it.iccs.simeal.sdi.tabelle.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.tabelle.application.model.PastoAlternativoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.PastoAlternativoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.PastoAlternativoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.PastoAlternativoUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface PastoAlternativoModelMapper extends ModelMapper<PastoAlternativoDTO, PastoAlternativoModel> {
	
	default PastoAlternativoModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new PastoAlternativoModel().setId(id);
	}
	
	PastoAlternativoDTO fromCreateDto(PastoAlternativoCreateDTO dto);

	PastoAlternativoDTO fromUpdateDto(PastoAlternativoUpdateDTO dto);
	
}
