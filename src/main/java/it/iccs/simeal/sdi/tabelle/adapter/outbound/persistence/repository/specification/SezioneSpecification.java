package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.SezioneEntity;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.SezioneCriteria;

public class SezioneSpecification extends AbstractSpecification<SezioneEntity> {
	
	public Specification<SezioneEntity> filter(SezioneCriteria criteria) {

		String flagName = "flagElimina";
		Short flagValue = 0;
		
		Specification<SezioneEntity> specification =
				super.flagSpecification(flagName, flagValue)
				.and(super.applyInUUIDFilter(criteria.getId(), "id"))
				.and(super.applySearchFilter(criteria.getDescrizione(), "descrizione"));
        return specification;
	}
	
}
