package it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.github.jhipster.service.filter.LocalDateFilter;
import io.github.jhipster.service.filter.StringFilter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class AperturaCriteria {
	
	List<UUID> id = new ArrayList<>();
	List<Integer> anno = new ArrayList<>();
	List<UUID> servizio = new ArrayList<>();
	List<UUID> istituto = new ArrayList<>();
	List<UUID> classe = new ArrayList<>();
	List<UUID> sezione = new ArrayList<>();
	List<StringFilter> 	descrizione = new ArrayList<>();
	LocalDateFilter dataInizio = new LocalDateFilter();
	LocalDateFilter dataFine = new LocalDateFilter();

}
