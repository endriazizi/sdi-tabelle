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
public class RefettorioCreateDTO implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID idEnte;
	
	private String descrizione;

}
