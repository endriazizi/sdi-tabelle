package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.SezioneEntity;
import it.iccs.simeal.sdi.configurazione.application.model.SezioneModel;

@Component
@Mapper
public interface SezioneEntityMapper extends EntityMapper<SezioneEntity, SezioneModel> {
	
	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	SezioneEntity fromModelToEntity(SezioneModel model);
	
}
