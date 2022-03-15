package it.iccs.simeal.sdi.tabelle.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.tabelle.application.model.ClasseModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface ClasseModelMapper extends ModelMapper<ClasseDTO, ClasseModel> {
	
	default ClasseModel fromId(UUID id) {
		if (id == null) {
			return null;
		}
		return new ClasseModel().setId(id);
	}
	
	ClasseDTO fromCreateDto(ClasseCreateDTO dto);

	ClasseDTO fromUpdateDto(ClasseUpdateDTO dto);
	
}
