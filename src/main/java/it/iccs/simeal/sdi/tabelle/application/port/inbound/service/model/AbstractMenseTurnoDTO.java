package it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model;

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
public abstract class AbstractMenseTurnoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected String descrizione;
	
	@Valid
	protected MensaGiroInnerDTO mensaGiro;
	
	@Data
	@Accessors(chain = true)
	@EqualsAndHashCode
	public static class MensaGiroInnerDTO {
		@NotNull
		private UUID id;
	}

}
