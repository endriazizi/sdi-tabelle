package it.iccs.simeal.sdi.tabelle.application.model;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors (chain = true)
@EqualsAndHashCode
public class ClasseComposizioneModel implements Serializable {
	
	private static final long serialVersionUID = 1L;

	private UUID id;
	
	private UUID idEnte;
	
	private IstitutoModel istituto;
	
	private ClasseModel classe;
	
	private SezioneModel sezione;
	
	private IstitutoModel istitutoSuccessiva;
	
	private ClasseModel classeSuccessiva;
	
	private SezioneModel sezioneSuccessiva;
	
	private Short flagElimina;

}
