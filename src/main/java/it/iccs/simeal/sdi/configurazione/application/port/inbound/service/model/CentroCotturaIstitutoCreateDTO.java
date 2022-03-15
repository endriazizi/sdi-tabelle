package it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model;

import java.time.LocalDate;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class CentroCotturaIstitutoCreateDTO extends AbstractCentroCotturaIstitutoDTO {
	
	private static final long serialVersionUID = 1L;
	
	public IstitutoInnerDTO getIstituto() {
		return istituto;
	}
	
	public CentroCotturaInnerDTO getCentroCottura() {
		return centroCottura;
	}
	
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	
	public LocalDate getDataFine() {
		return dataFine;
	}
}
