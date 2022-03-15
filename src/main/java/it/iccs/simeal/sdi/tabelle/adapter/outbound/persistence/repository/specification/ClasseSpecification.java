package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.ClasseEntity;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseCriteria;

public class ClasseSpecification extends AbstractSpecification<ClasseEntity> {
	
	public Specification<ClasseEntity> filter(ClasseCriteria criteria) {
		
		String flagName = "flagElimina";
		Short flagValue = 0;
		
		Specification<ClasseEntity> specification =
				super.flagSpecification(flagName, flagValue)
				.and(super.applyInUUIDFilter(criteria.getId(), "id"))
				.and(super.applySearchFilter(criteria.getDescrizione(), "descrizione"));
        return specification;
	}
	
}
