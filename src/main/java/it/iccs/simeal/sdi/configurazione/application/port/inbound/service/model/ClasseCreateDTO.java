package it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model;

import java.io.Serializable;

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
public class ClasseCreateDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	private String descrizione;

}
