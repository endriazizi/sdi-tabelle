package it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model;

import java.io.Serializable;
import java.util.Date;
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
public class AnnoCreateDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private Integer anno;
	
	private String descrizione;
	
	private Short annoCorrente;
	
	private Short flagCongelaAnno;
	
	private Short flagIseeCalcolo;

}
