package it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class ClasseComposizioneCriteria {
	
	List<UUID> id = new ArrayList<>();
	List<UUID> istituto = new ArrayList<>();
	List<UUID> classe = new ArrayList<>();
	List<UUID> sezione = new ArrayList<>();
	List<UUID> istitutoSuccessiva = new ArrayList<>();
	List<UUID> classeSuccessiva = new ArrayList<>();
	List<UUID> sezioneSuccessiva = new ArrayList<>();
	
}
