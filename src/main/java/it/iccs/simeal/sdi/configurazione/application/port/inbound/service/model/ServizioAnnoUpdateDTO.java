package it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model;

import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class ServizioAnnoUpdateDTO extends AbstractServizioDTO {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
    private UUID id;
	
	public ServizioInnerDTO getServizio() {
		return servizio;
	}
	
	public Integer getAnno() {
		return anno;
	}
	
	public Integer getTipologiaRilevazione() {
		return tipologiaRilevazione;
	}
}
