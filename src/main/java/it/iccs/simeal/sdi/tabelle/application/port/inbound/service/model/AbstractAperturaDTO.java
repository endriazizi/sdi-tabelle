package it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model;

import java.io.Serializable;
import java.time.LocalDate;
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
public abstract class AbstractAperturaDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Valid
	protected Integer anno;
	
	@Valid
	protected ServizioInnerDTO servizio;

	@Valid
	protected IstitutoInnerDTO istituto;

	@Valid
	protected ClasseInnerDTO classe;

	@Valid
	protected SezioneInnerDTO sezione;
	
	protected String descrizione;
	
	@NotNull
	protected LocalDate dataInizio;
	
	@NotNull
	protected LocalDate dataFine;
	
	@NotNull
	protected Short flagElimina;
	
	@Data
	@Accessors(chain = true)
	@EqualsAndHashCode
	public static class ServizioInnerDTO {
		private UUID id;
	}
	
	
	@Data
	@Accessors(chain = true)
	@EqualsAndHashCode
	public static class IstitutoInnerDTO {
		private UUID id;
	}
	
	@Data
	@Accessors(chain = true)
	@EqualsAndHashCode
	public static class ClasseInnerDTO {
		private UUID id;
	}
	
	@Data
	@Accessors(chain = true)
	@EqualsAndHashCode
	public static class SezioneInnerDTO {
		private UUID id;
	}

}
