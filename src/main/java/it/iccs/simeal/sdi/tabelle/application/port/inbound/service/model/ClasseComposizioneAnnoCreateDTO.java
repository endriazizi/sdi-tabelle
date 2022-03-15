package it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class ClasseComposizioneAnnoCreateDTO extends AbstractClasseComposizioneAnnoDTO {
	
	private static final long serialVersionUID = 1L;
	
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
