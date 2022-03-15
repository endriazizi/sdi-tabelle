package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.TurnoEntity;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TurnoCriteria;

public class TurnoSpecification extends AbstractSpecification<TurnoEntity> {
	
	public Specification<TurnoEntity> filter(TurnoCriteria criteria) {
		
		String flagName = "flagElimina";
		Short flagValue = 0;
		
		Specification<TurnoEntity> specification =
				super.flagSpecification(flagName, flagValue)
				.and(super.applyInUUIDFilter(criteria.getId(), "id"))
				.and(super.applySearchFilter(criteria.getDescrizione(), "descrizione"))
				.and(super.applyInUUIDFilter(criteria.getGiro(), "servizioGiro"));
						
        return specification;
	}
	
}
