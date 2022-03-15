package it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class MenuDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID id;
	
	private UUID idEnte;
	
	private Integer anno;
	
	private String descrizione;
	
	private Date dataInizio;
	
	private Date dataFine;
	
	private String filenameMenu;

	private Short flagElimina;

}
