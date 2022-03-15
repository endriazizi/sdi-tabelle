package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.IstitutoEntity;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.IstitutoCriteria;

public class IstitutoSpecification extends AbstractSpecification<IstitutoEntity> {
	
	public Specification<IstitutoEntity> filter(IstitutoCriteria criteria) {

		String flagName = "flagElimina";
		Short flagValue = 0;
		
		Specification<IstitutoEntity> specification =
				super.flagSpecification(flagName, flagValue)
				.and(super.applyInUUIDFilter(criteria.getId(), "id"))
        		.and(super.applySearchFilter(criteria.getDenominazione(), "denominazione"))
				.and(super.applySearchFilter(criteria.getMeccanograficoPlesso(), "meccanograficoPlesso"))
				.and(super.applySearchFilter(criteria.getMeccanograficoScuola(), "meccanograficoScuola"))
				.and(super.applyInUUIDFilter(criteria.getIdTipologiaIstituto(), "idTipologiaIstituto"));
        return specification;
	}
	
}
