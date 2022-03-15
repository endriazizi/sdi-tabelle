package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.TipologiaIstitutoEntity;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaIstitutoCriteria;

public class TipologiaIstitutoSpecification extends AbstractSpecification<TipologiaIstitutoEntity> {
	
	public Specification<TipologiaIstitutoEntity> filter(TipologiaIstitutoCriteria criteria) {

		String flagName = "flagElimina";
		Short flagValue = 0;
		
		Specification<TipologiaIstitutoEntity> specification =
				super.flagSpecification(flagName, flagValue)
				.and(super.applyInUUIDFilter(criteria.getId(), "id"))
				.and(super.applySearchFilter(criteria.getDescrizione(), "descrizione"));
        return specification;
	}
	
}
