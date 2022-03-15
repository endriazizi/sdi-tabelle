package it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.github.jhipster.service.filter.StringFilter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class SezioneCriteria {
	
	List<UUID> id = new ArrayList<>();
	List<StringFilter> descrizione = new ArrayList<>();
 
}
