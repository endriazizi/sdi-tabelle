package it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class MenuCreateDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID id;
	
	private UUID idEnte;
	
	private Integer anno;
	
	private String descrizione;
	
	private Date dataInizio;
	
	private Date dataFine;
	
	private String filenameMenu;

}
