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
public abstract class AbstractClasseComposizioneAnnoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected Integer anno;

	@Valid
	protected TurnoInnerDTO turno;

	@Valid
	protected RefettorioInnerDTO refettorio;

	@Valid
	protected ClasseComposizioneInnerDTO classeComposizione;
	
	@Data
	@Accessors(chain = true)
	@EqualsAndHashCode
	public static class TurnoInnerDTO {
		@NotNull
		private UUID id;
	}
	
	@Data
	@Accessors(chain = true)
	@EqualsAndHashCode
	public static class RefettorioInnerDTO {
		@NotNull
		private UUID id;
	}
	
	@Data
	@Accessors(chain = true)
	@EqualsAndHashCode
	public static class ClasseComposizioneInnerDTO {
		@NotNull
		private UUID id;
	}

}
