package it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model;

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
public class IstitutoCriteria {
	
	List<UUID> id = new ArrayList<>();
	List<StringFilter> 	denominazione = new ArrayList<>();
	List<StringFilter> meccanograficoPlesso = new ArrayList<>();
	List<StringFilter> meccanograficoScuola = new ArrayList<>();
	List<UUID> idTipologiaIstituto = new ArrayList<>();

}
