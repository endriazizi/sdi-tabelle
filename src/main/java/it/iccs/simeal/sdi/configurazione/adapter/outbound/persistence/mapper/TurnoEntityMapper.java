package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.TurnoEntity;
import it.iccs.simeal.sdi.configurazione.application.model.TurnoModel;

@Component
@Mapper
public interface TurnoEntityMapper extends EntityMapper<TurnoEntity, TurnoModel> {
	
	// TODO rimuovere il mapping del giro quando sarà implementato
	
	@Mapping(target = "flagElimina", source = "flagElimina", defaultValue = "0")
	//@Mapping(target = "idGiro", source = "giro.id")
	TurnoEntity fromModelToEntity(TurnoModel model);
	

	//@Mapping(target = "giro.id", source = "idGiro")
	TurnoModel fromEntityToModel(TurnoEntity entity);
	
}
