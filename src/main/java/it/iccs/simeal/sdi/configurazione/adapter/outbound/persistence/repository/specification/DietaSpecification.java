package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.DietaEntity;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.DietaCriteria;

public class DietaSpecification extends AbstractSpecification<DietaEntity> {
	
	public Specification<DietaEntity> filter(DietaCriteria criteria) {
		
		String flagName = "flagElimina";
		Short flagValue = 0;
		
		Specification<DietaEntity> specification =
				super.flagSpecification(flagName, flagValue)
				.and(super.applyInUUIDFilter(criteria.getId(), "id"))
				.and(super.applySearchFilter(criteria.getDescrizione(), "descrizione"));
        return specification;
	}

}
