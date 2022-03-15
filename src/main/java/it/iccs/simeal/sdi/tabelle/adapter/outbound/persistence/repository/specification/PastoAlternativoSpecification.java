package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.PastoAlternativoEntity;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.PastoAlternativoCriteria;

public class PastoAlternativoSpecification extends AbstractSpecification<PastoAlternativoEntity> {
	
	public Specification<PastoAlternativoEntity> filter(PastoAlternativoCriteria criteria) {

		String flagName = "flagAbilitato";
		Short flagValue = 1;
		
		Specification<PastoAlternativoEntity> specification =
				super.flagSpecification(flagName, flagValue)
				.and(super.applyInUUIDFilter(criteria.getId(), "id"))
				.and(super.applySearchFilter(criteria.getDescrizione(), "descrizione"))
				.and(super.applyInIntegerFilter(criteria.getOrdinePasto(), "ordinePasto"));
        return specification;
	}
	
}
