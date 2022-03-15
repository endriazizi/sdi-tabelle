package it.iccs.simeal.sdi.configurazione.application.model;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class CentroCotturaModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID id;
	
	private String denominazione;

	private String indirizzo;
	
	private String civico;

	private String citta;

	private String provincia;
	
	private String referente;

	private String telefono;
	
	private String fax;

	private String email;

	private String pec;

	private Short flagElimina;

}