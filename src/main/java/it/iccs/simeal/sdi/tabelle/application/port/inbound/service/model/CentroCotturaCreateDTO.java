package it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model;

import java.io.Serializable;
import java.util.UUID;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class CentroCotturaCreateDTO implements Serializable {

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

}
