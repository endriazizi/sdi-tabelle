package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.AperturaEntity_;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.ClasseEntity_;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.IstitutoEntity_;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.SezioneEntity_;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.AperturaEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.ClasseEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.IstitutoEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.SezioneEntity;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.AperturaCriteria;

public class AperturaSpecification extends AbstractSpecification<AperturaEntity> {
	
	public Specification<AperturaEntity> filter(AperturaCriteria criteria) {
		
		String flagName = "flagElimina";
		Short flagValue = 0;
		
		Specification<AperturaEntity> specification =
				super.flagSpecification(flagName, flagValue)
				.and(super.applyInUUIDFilter(criteria.getId(), "id"))
				.and(this.buildServizioSpecification(criteria))
				.and(this.buildIstitutoSpecification(criteria))
				.and(this.buildClasseSpecification(criteria))
				.and(this.buildSezioneSpecification(criteria))
				.and(super.applyInIntegerFilter(criteria.getAnno(), "anno"));
		
		if (criteria.getDataInizio() != null) {
            specification = specification.and(buildRangeSpecification(criteria.getDataInizio(), AperturaEntity_.dataInizio));
        }
		
		if (criteria.getDataFine() != null) {
            specification = specification.and(buildRangeSpecification(criteria.getDataFine(), AperturaEntity_.dataFine));
        }
		
        return specification;
	}
	
	protected Specification<AperturaEntity> buildServizioSpecification(AperturaCriteria criteria) {
		return (root, criteriaQuery, criteriaBuilder) -> {

			Specification<AperturaEntity> specification = Specification.where(null);

			if (criteria.getServizio() != null && !criteria.getServizio().isEmpty()) {

				// costruisco la join per applicare i criteri di ricerca sul servizio
				Join<AperturaEntity, IstitutoEntity> joinServizio = root
						.join(AperturaEntity_.SERVIZIO, JoinType.LEFT);

				specification = super.applyJoinInFilterGeneric(criteria.getServizio(),
						IstitutoEntity_.ID, joinServizio);
			}
			return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
		};
	}
	
	protected Specification<AperturaEntity> buildIstitutoSpecification(AperturaCriteria criteria) {
		return (root, criteriaQuery, criteriaBuilder) -> {

			Specification<AperturaEntity> specification = Specification.where(null);

			if (criteria.getIstituto() != null && !criteria.getIstituto().isEmpty()) {

				// costruisco la join per applicare i criteri di ricerca sull'istituto
				Join<AperturaEntity, IstitutoEntity> joinIstituto = root
						.join(AperturaEntity_.ISTITUTO, JoinType.LEFT);

				specification = super.applyJoinInFilterGeneric(criteria.getIstituto(),
						IstitutoEntity_.ID, joinIstituto);
			}
			return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
		};
	}
	
	protected Specification<AperturaEntity> buildClasseSpecification(AperturaCriteria criteria) {
		return (root, criteriaQuery, criteriaBuilder) -> {

			Specification<AperturaEntity> specification = Specification.where(null);

			if (criteria.getClasse() != null && !criteria.getClasse().isEmpty()) {

				// costruisco la join per applicare i criteri di ricerca sulla classe
				Join<AperturaEntity, ClasseEntity> joinClasse = root
						.join(AperturaEntity_.CLASSE, JoinType.LEFT);

				specification = super.applyJoinInFilterGeneric(criteria.getClasse(),
						ClasseEntity_.ID, joinClasse);
			}
			return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
		};
	}
	
	protected Specification<AperturaEntity> buildSezioneSpecification(AperturaCriteria criteria) {
		return (root, criteriaQuery, criteriaBuilder) -> {

			Specification<AperturaEntity> specification = Specification.where(null);

			if (criteria.getSezione() != null && !criteria.getSezione().isEmpty()) {

				// costruisco la join per applicare i criteri di ricerca sulla sezione
				Join<AperturaEntity, SezioneEntity> joinSezione = root
						.join(AperturaEntity_.SEZIONE, JoinType.LEFT);

				specification = super.applyJoinInFilterGeneric(criteria.getSezione(),
						SezioneEntity_.ID, joinSezione);
			}
			return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
		};
	}
	
}
