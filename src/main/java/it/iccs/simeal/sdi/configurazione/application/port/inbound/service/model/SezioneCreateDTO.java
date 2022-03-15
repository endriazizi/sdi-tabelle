package it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class SezioneCreateDTO implements Serializable {

	private static final long serialVersionUID = 1L;
		
	private String descrizione;

}
