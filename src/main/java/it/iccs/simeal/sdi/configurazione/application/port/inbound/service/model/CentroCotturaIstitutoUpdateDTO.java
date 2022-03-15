package it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model;

import java.time.LocalDate;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class CentroCotturaIstitutoUpdateDTO extends AbstractCentroCotturaIstitutoDTO {
	
	private static final long serialVersionUID = 1L;
	
	@NotNull
    private UUID id;
	
	public CentroCotturaInnerDTO getCentroCottura() {
		return centroCottura;
	}
	
	public IstitutoInnerDTO getIstituto() {
		return istituto;
	}
	
	public LocalDate getDataInizio() {
		return dataInizio;
	}
	
	public LocalDate getDataFine() {
		return dataFine;
	}
}
