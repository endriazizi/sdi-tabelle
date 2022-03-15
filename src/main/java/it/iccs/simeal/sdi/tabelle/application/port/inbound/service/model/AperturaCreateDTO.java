package it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class AperturaCreateDTO extends AbstractAperturaDTO {
	
	private static final long serialVersionUID = 1L;
	
	public Integer getAnno() {
		return anno;
	}
	
	public ServizioInnerDTO getServizio() {
		return servizio;
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
	
	public String getDescrizione() {
		return descrizione;
	}
	
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	
	public LocalDate getDataFine() {
		return dataFine;
	}
	
	public Short getFlagElimina() {
		return flagElimina;
	}
	

}
