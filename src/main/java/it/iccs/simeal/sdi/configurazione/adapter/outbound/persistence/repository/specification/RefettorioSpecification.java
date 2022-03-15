package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.RefettorioEntity;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.RefettorioCriteria;

public class RefettorioSpecification extends AbstractSpecification<RefettorioEntity> {
	
	public Specification<RefettorioEntity> filter(RefettorioCriteria criteria) {

		String flagName = "flagElimina";
		Short flagValue = 0;
		
		Specification<RefettorioEntity> specification =
				super.flagSpecification(flagName, flagValue)
				.and(super.applyInUUIDFilter(criteria.getId(), "id"))
				.and(super.applySearchFilter(criteria.getDescrizione(), "descrizione"));
        return specification;
	}
	
}
