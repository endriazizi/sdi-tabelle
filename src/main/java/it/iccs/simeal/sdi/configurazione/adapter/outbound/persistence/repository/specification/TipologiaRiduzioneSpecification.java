package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.TipologiaRiduzioneEntity;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TipologiaRiduzioneCriteria;

public class TipologiaRiduzioneSpecification extends AbstractSpecification<TipologiaRiduzioneEntity> {
	
	public Specification<TipologiaRiduzioneEntity> filter(TipologiaRiduzioneCriteria criteria) {
		
		String flagName = "flagElimina";
		Short flagValue = 0;
		
		Specification<TipologiaRiduzioneEntity> specification =
				super.flagSpecification(flagName, flagValue)
				.and(super.applyInUUIDFilter(criteria.getId(), "id"))
				.and(super.applySearchFilter(criteria.getDescrizione(), "descrizione"));
        return specification;
	}

}
