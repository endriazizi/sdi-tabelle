package it.iccs.simeal.sdi.configurazione.application.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors (chain = true)
@EqualsAndHashCode
public class CentroCotturaIstitutoModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private UUID id;
	
	private Integer anno;
	
	private IstitutoModel istituto;
	
	private CentroCotturaModel centroCottura;
	
	private LocalDate dataInizio;
	
	private LocalDate dataFine;
	
}
