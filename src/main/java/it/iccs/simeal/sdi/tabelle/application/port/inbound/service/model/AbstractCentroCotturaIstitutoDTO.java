package it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model;

import java.io.Serializable;
import java.time.LocalDate;
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
public abstract class AbstractCentroCotturaIstitutoDTO implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Valid
	protected CentroCotturaInnerDTO centroCottura;
	
	@Valid
	protected IstitutoInnerDTO istituto;

	protected LocalDate dataInizio;
	
	protected LocalDate dataFine;
	
	@Data
	@Accessors(chain = true)
	@EqualsAndHashCode
	public static class CentroCotturaInnerDTO {
		@NotNull
		private UUID id;
	}
	
	@Data
	@Accessors(chain = true)
	@EqualsAndHashCode
	public static class IstitutoInnerDTO {
		@NotNull
		private UUID id;
	}

}
