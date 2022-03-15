package it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class CentroCotturaIstitutoDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private UUID id;
	
	private IstitutoDTO istituto;
	
	private CentroCotturaDTO centroCottura;
	
	private LocalDate dataInizio;
	
	private LocalDate dataFine;
	
}
