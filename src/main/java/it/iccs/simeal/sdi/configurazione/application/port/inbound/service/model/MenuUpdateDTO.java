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
public class MenuUpdateDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	@NotNull
	private UUID id;
	
	private UUID idEnte;
	
	private Integer anno;
	
	private String descrizione;
	
	private Date dataInizio;
	
	private Date dataFine;
	
	private String filenameMenu;

}
