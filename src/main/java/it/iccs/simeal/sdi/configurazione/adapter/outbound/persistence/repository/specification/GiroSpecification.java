package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.GiroEntity;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.GiroCriteria;

public class GiroSpecification extends AbstractSpecification<GiroEntity> {
	
	public Specification<GiroEntity> filter(GiroCriteria criteria) {
		
		String flagName = "flagElimina";
		Short flagValue = 0;
		
		Specification<GiroEntity> specification =
				super.flagSpecification(flagName, flagValue)
				.and(super.applyInUUIDFilter(criteria.getId(), "id"))
				.and(super.applySearchFilter(criteria.getDescrizione(), "descrizione"));
        return specification;
	}

}
