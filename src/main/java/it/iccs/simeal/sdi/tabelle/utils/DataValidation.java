package it.iccs.simeal.sdi.tabelle.utils;

import java.time.LocalDate;

import it.iccs.simeal.sdi.tabelle.web.rest.errors.BadRequestException;

public class DataValidation {
	
	public void validatePeriod(LocalDate dataInizio, LocalDate dataFine) {
		if (dataFine != null) {
			if (dataFine.compareTo(dataInizio) <= 0) {
				throw new BadRequestException("La data 'dataFine' deve essere maggiore della data 'dataInizio'");
			}
		}
	}
}
