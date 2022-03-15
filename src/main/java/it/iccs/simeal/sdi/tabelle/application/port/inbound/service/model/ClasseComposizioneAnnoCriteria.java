package it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class ClasseComposizioneAnnoCriteria {
	
	List<UUID> id = new ArrayList<>();
	List<Integer> anno = new ArrayList<>();
	List<UUID> turno = new ArrayList<>();
	List<UUID> refettorio = new ArrayList<>();
	List<UUID> classeComposizione = new ArrayList<>();

}
