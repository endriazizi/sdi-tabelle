package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.CentroCotturaEntity;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaCriteria;

public class CentroCotturaSpecification extends AbstractSpecification<CentroCotturaEntity> {
	
	public Specification<CentroCotturaEntity> filter(CentroCotturaCriteria criteria) {

		String flagName = "flagElimina";
		Short flagValue = 0;
		
		Specification<CentroCotturaEntity> specification =
				super.flagSpecification(flagName, flagValue)
				.and(super.applyInUUIDFilter(criteria.getId(), "id"))
        		.and(super.applySearchFilter(criteria.getDenominazione(), "denominazione"));
        return specification;
	}
	
}
