package it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.github.jhipster.service.filter.IntegerFilter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class ServizioAnnoCriteria {
	
	List<UUID> id = new ArrayList<>();
	List<UUID> servizio = new ArrayList<>();
	List<IntegerFilter> anno = new ArrayList<>();
	List<IntegerFilter> tipologiaRilevazione = new ArrayList<>();

}
