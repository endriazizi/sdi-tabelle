package it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model;

import java.util.ArrayList;
import java.util.List;
import java.util.UUID;

import io.github.jhipster.service.filter.LocalDateFilter;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class CentroCotturaIstitutoCriteria {
	
	List<UUID> id = new ArrayList<>();
	List<UUID> istituto = new ArrayList<>();
	List<UUID> centroCottura = new ArrayList<>();
	LocalDateFilter dataInizio = new LocalDateFilter();
	LocalDateFilter dataFine = new LocalDateFilter();

}
