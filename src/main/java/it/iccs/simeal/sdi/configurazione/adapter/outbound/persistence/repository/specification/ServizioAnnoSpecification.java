package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ServizioAnnoEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ServizioAnnoEntity_;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ServizioEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ServizioEntity_;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioAnnoCriteria;

public class ServizioAnnoSpecification extends AbstractSpecification<ServizioAnnoEntity> {
	
	public Specification<ServizioAnnoEntity> filter(ServizioAnnoCriteria criteria) {
		

		Specification<ServizioAnnoEntity> specification =
				super.applyInUUIDFilter(criteria.getId(), "id")
				.and(this.buildServizioSpecification(criteria))
				.and(super.applyIntegerFilter(criteria.getAnno(), "anno"))
				.and(super.applyIntegerFilter(criteria.getTipologiaRilevazione(), "tipologiaRilevazione"));
        return specification;
	}
	
	protected Specification<ServizioAnnoEntity> buildServizioSpecification(ServizioAnnoCriteria criteria) {
		return (root, criteriaQuery, criteriaBuilder) -> {

			Specification<ServizioAnnoEntity> specification = Specification.where(null);

			if (criteria.getServizio() != null && !criteria.getServizio().isEmpty()) {

				// costruisco la join per applicare i criteri di ricerca sul servizio
				Join<ServizioAnnoEntity, ServizioEntity> joinServizio = root
						.join(ServizioAnnoEntity_.SERVIZIO, JoinType.INNER);

				specification = super.applyJoinInFilterGeneric(criteria.getServizio(),
						ServizioEntity_.ID, joinServizio);
			}
			return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
		};
	}

}
