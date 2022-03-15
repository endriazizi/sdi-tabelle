package it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.Valid;
import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Setter;
import lombok.experimental.Accessors;

@Setter
@Accessors(chain = true)
@EqualsAndHashCode
public abstract class AbstractServizioDTO implements Serializable {

	private static final long serialVersionUID = 1L;	

	@Valid
	protected ServizioInnerDTO servizio;

	protected Integer anno;
	
	protected Integer tipologiaRilevazione;
	
	@Data
	@Accessors(chain = true)
	@EqualsAndHashCode
	public static class ServizioInnerDTO {
		@NotNull
		private UUID id;
	}

}
