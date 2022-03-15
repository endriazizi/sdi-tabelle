package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ClasseComposizioneEntity;
import it.iccs.simeal.sdi.configurazione.application.model.ClasseComposizioneModel;

@Component
@Mapper
public interface ClasseComposizioneEntityMapper extends EntityMapper<ClasseComposizioneEntity, ClasseComposizioneModel> {
	
	@Mapping(target = "flagElimina", source="flagElimina", defaultValue = "0")
	ClasseComposizioneEntity fromModelToEntity(ClasseComposizioneModel model);

}
