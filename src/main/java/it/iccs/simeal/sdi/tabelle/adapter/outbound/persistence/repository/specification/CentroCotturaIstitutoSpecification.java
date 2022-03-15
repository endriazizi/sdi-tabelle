package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.CentroCotturaIstitutoEntity_;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.CentroCotturaEntity_;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.IstitutoEntity_;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.CentroCotturaIstitutoEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.CentroCotturaEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.IstitutoEntity;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaIstitutoCriteria;

public class CentroCotturaIstitutoSpecification extends AbstractSpecification<CentroCotturaIstitutoEntity> {
	
	public Specification<CentroCotturaIstitutoEntity> filter(CentroCotturaIstitutoCriteria criteria) {

		Specification<CentroCotturaIstitutoEntity> specification =
				super.applyInUUIDFilter(criteria.getId(), "id")
                .and(this.buildIstitutoSpecification(criteria))
				.and(this.buildCentroCotturaSpecification(criteria));
		
		if (criteria.getDataInizio() != null) {
            specification = specification.and(buildRangeSpecification(criteria.getDataInizio(), CentroCotturaIstitutoEntity_.dataInizio));
        }
		
		if (criteria.getDataFine() != null) {
            specification = specification.and(buildRangeSpecification(criteria.getDataFine(), CentroCotturaIstitutoEntity_.dataFine));
        }
		
        return specification;
	}

	private Specification<CentroCotturaIstitutoEntity> buildIstitutoSpecification(CentroCotturaIstitutoCriteria criteria) {
		return (root, criteriaQuery, criteriaBuilder) -> {

			Specification<CentroCotturaIstitutoEntity> specification = Specification.where(null);

			if (criteria.getIstituto() != null && !criteria.getIstituto().isEmpty()) {

				// costruisco la join per applicare i criteri di ricerca sul turno mensa
				Join<CentroCotturaIstitutoEntity, IstitutoEntity> joinIstituto = root
						.join(CentroCotturaIstitutoEntity_.ISTITUTO, JoinType.LEFT);

				specification = super.applyJoinInFilterGeneric(criteria.getIstituto(),
						IstitutoEntity_.ID, joinIstituto);
			}
			return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
		};
	}

	private Specification<CentroCotturaIstitutoEntity> buildCentroCotturaSpecification(CentroCotturaIstitutoCriteria criteria) {
		return (root, criteriaQuery, criteriaBuilder) -> {

			Specification<CentroCotturaIstitutoEntity> specification = Specification.where(null);

			if (criteria.getCentroCottura() != null && !criteria.getCentroCottura().isEmpty()) {

				// costruisco la join per applicare i criteri di ricerca sul refettorio mensa
				Join<CentroCotturaIstitutoEntity, CentroCotturaEntity> joinCentroCottura = root
						.join(CentroCotturaIstitutoEntity_.CENTRO_COTTURA, JoinType.LEFT);

				specification = super.applyJoinInFilterGeneric(criteria.getCentroCottura(),
						CentroCotturaEntity_.ID, joinCentroCottura);
			}
			return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
		};
	}
	
}
