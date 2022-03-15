package it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
@NoArgsConstructor
public class CentroCotturaUpdateDTO implements Serializable {
	
	private static final long serialVersionUID = 1L;

	@NotNull
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

}
