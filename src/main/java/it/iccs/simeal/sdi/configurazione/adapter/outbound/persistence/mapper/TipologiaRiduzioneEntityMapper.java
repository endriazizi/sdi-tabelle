package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.TipologiaRiduzioneEntity;
import it.iccs.simeal.sdi.configurazione.application.model.TipologiaRiduzioneModel;

@Component
@Mapper
public interface TipologiaRiduzioneEntityMapper extends EntityMapper<TipologiaRiduzioneEntity, TipologiaRiduzioneModel> {
	
	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	TipologiaRiduzioneEntity fromModelToEntity(TipologiaRiduzioneModel model);
	
}
