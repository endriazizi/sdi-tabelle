package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.ServizioAnnoEntity;
import it.iccs.simeal.sdi.tabelle.application.model.ServizioAnnoModel;

@Component
@Mapper
public interface ServizioAnnoEntityMapper extends EntityMapper<ServizioAnnoEntity, ServizioAnnoModel> {
	
	ServizioAnnoEntity fromModelToEntity(ServizioAnnoModel model);

}
