package it.iccs.simeal.sdi.configurazione.utils;

import java.time.LocalDate;

import it.iccs.simeal.sdi.configurazione.web.rest.errors.BadRequestException;

public class DataValidation {
	
	public void validatePeriod(LocalDate dataInizio, LocalDate dataFine) {
		if (dataFine != null) {
			if (dataFine.compareTo(dataInizio) <= 0) {
				throw new BadRequestException("La data 'dataFine' deve essere maggiore della data 'dataInizio'");
			}
		}
	}
}
