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
public class AperturaModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private UUID id;
	
	private Integer anno;
	
	private IstitutoModel istituto;
	
	private ClasseModel classe;
	
	private SezioneModel sezione;
	
	private ServizioModel servizio;
	
	private String descrizione;
	
	private LocalDate dataInizio;
	
	private LocalDate dataFine;
	
	private Short flagElimina;

}
