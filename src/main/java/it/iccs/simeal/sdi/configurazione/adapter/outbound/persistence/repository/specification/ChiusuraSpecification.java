package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ChiusuraEntity_;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ClasseEntity_;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.IstitutoEntity_;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.SezioneEntity_;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ChiusuraEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ClasseEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.IstitutoEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.SezioneEntity;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ChiusuraCriteria;

public class ChiusuraSpecification extends AbstractSpecification<ChiusuraEntity> {
	
	public Specification<ChiusuraEntity> filter(ChiusuraCriteria criteria) {
		
		String flagName = "flagElimina";
		Short flagValue = 0;
		
		Specification<ChiusuraEntity> specification =
				super.flagSpecification(flagName, flagValue)
				.and(super.applyInUUIDFilter(criteria.getId(), "id"))
				.and(this.buildServizioSpecification(criteria))
				.and(this.buildIstitutoSpecification(criteria))
				.and(this.buildClasseSpecification(criteria))
				.and(this.buildSezioneSpecification(criteria))
				.and(super.applyInIntegerFilter(criteria.getAnno(), "anno"));
		
		if (criteria.getDataInizio() != null) {
            specification = specification.and(buildRangeSpecification(criteria.getDataInizio(), ChiusuraEntity_.dataInizio));
        }
		
		if (criteria.getDataFine() != null) {
            specification = specification.and(buildRangeSpecification(criteria.getDataFine(), ChiusuraEntity_.dataFine));
        }
		
        return specification;
	}
	
	protected Specification<ChiusuraEntity> buildServizioSpecification(ChiusuraCriteria criteria) {
		return (root, criteriaQuery, criteriaBuilder) -> {

			Specification<ChiusuraEntity> specification = Specification.where(null);

			if (criteria.getServizio() != null && !criteria.getServizio().isEmpty()) {

				// costruisco la join per applicare i criteri di ricerca sul servizio
				Join<ChiusuraEntity, IstitutoEntity> joinServizio = root
						.join(ChiusuraEntity_.SERVIZIO, JoinType.LEFT);

				specification = super.applyJoinInFilterGeneric(criteria.getServizio(),
						IstitutoEntity_.ID, joinServizio);
			}
			return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
		};
	}
	
	protected Specification<ChiusuraEntity> buildIstitutoSpecification(ChiusuraCriteria criteria) {
		return (root, criteriaQuery, criteriaBuilder) -> {

			Specification<ChiusuraEntity> specification = Specification.where(null);

			if (criteria.getIstituto() != null && !criteria.getIstituto().isEmpty()) {

				// costruisco la join per applicare i criteri di ricerca sull'istituto
				Join<ChiusuraEntity, IstitutoEntity> joinIstituto = root
						.join(ChiusuraEntity_.ISTITUTO, JoinType.LEFT);

				specification = super.applyJoinInFilterGeneric(criteria.getIstituto(),
						IstitutoEntity_.ID, joinIstituto);
			}
			return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
		};
	}
	
	protected Specification<ChiusuraEntity> buildClasseSpecification(ChiusuraCriteria criteria) {
		return (root, criteriaQuery, criteriaBuilder) -> {

			Specification<ChiusuraEntity> specification = Specification.where(null);

			if (criteria.getClasse() != null && !criteria.getClasse().isEmpty()) {

				// costruisco la join per applicare i criteri di ricerca sulla classe
				Join<ChiusuraEntity, ClasseEntity> joinClasse = root
						.join(ChiusuraEntity_.CLASSE, JoinType.LEFT);

				specification = super.applyJoinInFilterGeneric(criteria.getClasse(),
						ClasseEntity_.ID, joinClasse);
			}
			return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
		};
	}
	
	protected Specification<ChiusuraEntity> buildSezioneSpecification(ChiusuraCriteria criteria) {
		return (root, criteriaQuery, criteriaBuilder) -> {

			Specification<ChiusuraEntity> specification = Specification.where(null);

			if (criteria.getSezione() != null && !criteria.getSezione().isEmpty()) {

				// costruisco la join per applicare i criteri di ricerca sulla sezione
				Join<ChiusuraEntity, SezioneEntity> joinSezione = root
						.join(ChiusuraEntity_.SEZIONE, JoinType.LEFT);

				specification = super.applyJoinInFilterGeneric(criteria.getSezione(),
						SezioneEntity_.ID, joinSezione);
			}
			return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
		};
	}
	
}
