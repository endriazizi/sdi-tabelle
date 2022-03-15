package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.MenuEntity;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.MenuCriteria;

public class MenuSpecification extends AbstractSpecification<MenuEntity> {
	
	public Specification<MenuEntity> filter(MenuCriteria criteria) {

		String flagName = "flagElimina";
		Short flagValue = 0;
		
		Specification<MenuEntity> specification =
				super.flagSpecification(flagName, flagValue)
				.and(super.applyInUUIDFilter(criteria.getId(), "id"))
				.and(super.applySearchFilter(criteria.getDescrizione(), "descrizione"))
				.and(super.applyInIntegerFilter(criteria.getAnno(), "anno"))
				;
		return specification;
	}
	
}
