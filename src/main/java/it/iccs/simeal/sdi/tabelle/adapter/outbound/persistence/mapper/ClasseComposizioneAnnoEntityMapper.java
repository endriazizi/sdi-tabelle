package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.ClasseComposizioneAnnoEntity;
import it.iccs.simeal.sdi.tabelle.application.model.ClasseComposizioneAnnoModel;

@Component
@Mapper
public interface ClasseComposizioneAnnoEntityMapper extends EntityMapper<ClasseComposizioneAnnoEntity, ClasseComposizioneAnnoModel> {
	
	@Mapping(target = "flagVisibile", source="flagVisibile", defaultValue = "1")
	ClasseComposizioneAnnoEntity fromModelToEntity(ClasseComposizioneAnnoModel model);
	
}
