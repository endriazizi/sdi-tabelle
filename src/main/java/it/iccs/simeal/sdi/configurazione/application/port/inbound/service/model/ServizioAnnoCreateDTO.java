package it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class ServizioAnnoCreateDTO {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
	private ServizioInnerDTO servizio;
	
	@NotNull
	private Integer anno;
	
	@NotNull
	private Integer tipologiaRilevazione;
	
	@Data
	@Accessors(chain = true)
	@EqualsAndHashCode
	public static class ServizioInnerDTO {
		@NotNull
		private UUID id;
	}
	

}
