package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.AnnoEntity;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AnnoCriteria;

public class AnnoSpecification extends AbstractSpecification<AnnoEntity> {
	
	public Specification<AnnoEntity> filter(AnnoCriteria criteria) {
		
		Specification<AnnoEntity> specification =
				super.applyInUUIDFilter(criteria.getId(), "id")
				.and(super.applyIntegerFilter(criteria.getAnno(), "anno"))
				.and(super.applySearchFilter(criteria.getDescrizione(), "descrizione"));
        return specification;
	}

}
