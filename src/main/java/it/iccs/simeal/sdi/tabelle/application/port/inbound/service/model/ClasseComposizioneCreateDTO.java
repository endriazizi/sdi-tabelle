package it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model;

import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class ClasseComposizioneCreateDTO extends AbstractClasseComposizioneDTO {
	
	private static final long serialVersionUID = 1L;
	
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
