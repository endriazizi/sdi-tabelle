package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.CentroCotturaEntity;
import it.iccs.simeal.sdi.configurazione.application.model.CentroCotturaModel;

@Component
@Mapper
public interface CentroCotturaEntityMapper extends EntityMapper<CentroCotturaEntity, CentroCotturaModel> {
	
	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	CentroCotturaEntity fromModelToEntity(CentroCotturaModel model);
	
}
