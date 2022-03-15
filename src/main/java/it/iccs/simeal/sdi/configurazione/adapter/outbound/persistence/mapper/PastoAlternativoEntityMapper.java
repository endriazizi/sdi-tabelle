package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.PastoAlternativoEntity;
import it.iccs.simeal.sdi.configurazione.application.model.PastoAlternativoModel;

@Component
@Mapper
public interface PastoAlternativoEntityMapper extends EntityMapper<PastoAlternativoEntity, PastoAlternativoModel> {
	
	@Mapping(target = "flagAbilitato", source="flagAbilitato", defaultValue = "1")
	PastoAlternativoEntity fromModelToEntity(PastoAlternativoModel model);
	
}
