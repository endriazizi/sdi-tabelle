package it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.github.jhipster.service.filter.IntegerFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class AnnoCriteria {
	
	List<UUID> id = new ArrayList<>();
	List<IntegerFilter> anno = new ArrayList<>();
	List<StringFilter> descrizione = new ArrayList<>();

}