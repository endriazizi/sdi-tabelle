package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ServizioEntity;
import it.iccs.simeal.sdi.configurazione.application.model.ServizioModel;

@Component
@Mapper
public interface ServizioEntityMapper extends EntityMapper<ServizioEntity, ServizioModel> {
	
	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	ServizioEntity fromModelToEntity(ServizioModel model);
	
}
