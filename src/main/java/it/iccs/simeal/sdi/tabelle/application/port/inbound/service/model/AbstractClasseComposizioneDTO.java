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
public abstract class AbstractClasseComposizioneDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	protected UUID idEnte;

	@Valid
	protected IstitutoInnerDTO istituto;

	@Valid
	protected ClasseInnerDTO classe;

	@Valid
	protected SezioneInnerDTO sezione;
	
	@Valid
	protected IstitutoInnerDTO istitutoSuccessiva;

	@Valid
	protected ClasseInnerDTO classeSuccessiva;

	@Valid
	protected SezioneInnerDTO sezioneSuccessiva;
	
	@Data
	@Accessors(chain = true)
	@EqualsAndHashCode
	public static class IstitutoInnerDTO {
		@NotNull
		private UUID id;
	}
	
	@Data
	@Accessors(chain = true)
	@EqualsAndHashCode
	public static class ClasseInnerDTO {
		@NotNull
		private UUID id;
	}
	
	@Data
	@Accessors(chain = true)
	@EqualsAndHashCode
	public static class SezioneInnerDTO {
		@NotNull
		private UUID id;
	}

}
