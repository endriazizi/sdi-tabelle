package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.ServizioEntity;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioCriteria;

public class ServizioSpecification extends AbstractSpecification<ServizioEntity> {
	
	public Specification<ServizioEntity> filter(ServizioCriteria criteria) {

		String flagName = "flagElimina";
		Short flagValue = 0;
		
		Specification<ServizioEntity> specification =
				super.flagSpecification(flagName, flagValue)
				.and(super.applyInUUIDFilter(criteria.getId(), "id"))
				.and(super.applySearchFilter(criteria.getDescrizione(), "descrizione"))
				.and(super.applyInIntegerFilter(criteria.getCodice(), "codice"));
        return specification;
	}
	
}
