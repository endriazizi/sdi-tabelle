package it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class AperturaDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	private UUID id;
	
	private Integer anno;
	
	private ServizioDTO servizio;

	private IstitutoDTO istituto;
	
	private ClasseDTO classe;
	
	private SezioneDTO sezione;
	
	private String descrizione;
	
	private LocalDate dataInizio;
	
	private LocalDate dataFine;

	private Short flagElimina;

}
