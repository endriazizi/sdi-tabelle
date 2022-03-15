package it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class ClasseComposizioneUpdateDTO extends AbstractClasseComposizioneDTO {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
    private UUID id;
	
	public UUID getIdEnte() {
		return idEnte;
	}
	
	public IstitutoInnerDTO getIstituto() {
		return istituto;
	}
	
	public ClasseInnerDTO getClasse() {
		return classe;
	}
	
	public SezioneInnerDTO getSezione() {
		return sezione;
	}
	
	public IstitutoInnerDTO getIstitutoSuccessiva() {
		return istitutoSuccessiva;
	}
	
	public ClasseInnerDTO getClasseSuccessiva() {
		return classeSuccessiva;
	}
	
	public SezioneInnerDTO getSezioneSuccessiva() {
		return sezioneSuccessiva;
	}

}
