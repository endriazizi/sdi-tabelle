package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.AnnoEntity;
import it.iccs.simeal.sdi.configurazione.application.model.AnnoModel;

@Component
@Mapper
public interface AnnoEntityMapper extends EntityMapper<AnnoEntity, AnnoModel> {
	
	@Mapping(target = "anno", source="anno", defaultValue = "0")
	@Mapping(target = "annoCorrente", source="annoCorrente", defaultValue = "0")
	@Mapping(target = "flagCongelaAnno", source="flagCongelaAnno", defaultValue = "0")
	@Mapping(target = "flagIseeCalcolo", source="flagIseeCalcolo", defaultValue = "0")
	AnnoEntity fromModelToEntity(AnnoModel model);

}
