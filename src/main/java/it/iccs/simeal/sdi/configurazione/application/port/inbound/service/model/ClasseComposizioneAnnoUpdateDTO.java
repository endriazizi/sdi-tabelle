package it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class ClasseComposizioneAnnoUpdateDTO extends AbstractClasseComposizioneAnnoDTO {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
    private UUID id;
	
	public Integer getAnno() {
		return anno;
	}
	
	public TurnoInnerDTO getTurno() {
		return turno;
	}
	
	public RefettorioInnerDTO getRefettorio() {
		return refettorio;
	}
	
	public ClasseComposizioneInnerDTO getClasseComposizione() {
		return classeComposizione;
	}

}
