package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.ClasseComposizioneEntity_;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.ClasseEntity_;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.IstitutoEntity_;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.SezioneEntity_;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.ClasseComposizioneEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.ClasseEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.IstitutoEntity;
import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.SezioneEntity;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseComposizioneCriteria;

public class ClasseComposizioneSpecification extends AbstractSpecification<ClasseComposizioneEntity> {
	
	public Specification<ClasseComposizioneEntity> filter(ClasseComposizioneCriteria criteria) {
		
		String flagName = "flagElimina";
		Short flagValue = 0;
		
		Specification<ClasseComposizioneEntity> specification =
				super.flagSpecification(flagName, flagValue)
				.and(super.applyInUUIDFilter(criteria.getId(), "id"))
				.and(this.buildIstitutoSpecification(criteria))
				.and(this.buildClasseSpecification(criteria))
				.and(this.buildSezioneSpecification(criteria))
				.and(this.buildIstitutoSuccessivaSpecification(criteria))
				.and(this.buildClasseSuccessivaSpecification(criteria))
				.and(this.buildSezioneSuccessivaSpecification(criteria));
        return specification;
	}
	
	protected Specification<ClasseComposizioneEntity> buildIstitutoSpecification(ClasseComposizioneCriteria criteria) {
		return (root, criteriaQuery, criteriaBuilder) -> {

			Specification<ClasseComposizioneEntity> specification = Specification.where(null);

			if (criteria.getIstituto() != null && !criteria.getIstituto().isEmpty()) {

				// costruisco la join per applicare i criteri di ricerca sull'istituto
				Join<ClasseComposizioneEntity, IstitutoEntity> joinIstituto = root
						.join(ClasseComposizioneEntity_.ISTITUTO, JoinType.LEFT);

				specification = super.applyJoinInFilterGeneric(criteria.getIstituto(),
						IstitutoEntity_.ID, joinIstituto);
			}
			return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
		};
	}
	
	protected Specification<ClasseComposizioneEntity> buildClasseSpecification(ClasseComposizioneCriteria criteria) {
		return (root, criteriaQuery, criteriaBuilder) -> {

			Specification<ClasseComposizioneEntity> specification = Specification.where(null);

			if (criteria.getClasse() != null && !criteria.getClasse().isEmpty()) {

				// costruisco la join per applicare i criteri di ricerca sulla classe
				Join<ClasseComposizioneEntity, ClasseEntity> joinClasse = root
						.join(ClasseComposizioneEntity_.CLASSE, JoinType.LEFT);

				specification = super.applyJoinInFilterGeneric(criteria.getClasse(),
						ClasseEntity_.ID, joinClasse);
			}
			return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
		};
	}
	
	protected Specification<ClasseComposizioneEntity> buildSezioneSpecification(ClasseComposizioneCriteria criteria) {
		return (root, criteriaQuery, criteriaBuilder) -> {

			Specification<ClasseComposizioneEntity> specification = Specification.where(null);

			if (criteria.getSezione() != null && !criteria.getSezione().isEmpty()) {

				// costruisco la join per applicare i criteri di ricerca sulla sezione
				Join<ClasseComposizioneEntity, SezioneEntity> joinSezione = root
						.join(ClasseComposizioneEntity_.SEZIONE, JoinType.LEFT);

				specification = super.applyJoinInFilterGeneric(criteria.getSezione(),
						SezioneEntity_.ID, joinSezione);
			}
			return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
		};
	}
	
	protected Specification<ClasseComposizioneEntity> buildIstitutoSuccessivaSpecification(ClasseComposizioneCriteria criteria) {
		return (root, criteriaQuery, criteriaBuilder) -> {

			Specification<ClasseComposizioneEntity> specification = Specification.where(null);

			if (criteria.getIstitutoSuccessiva() != null && !criteria.getIstitutoSuccessiva().isEmpty()) {

				// costruisco la join per applicare i criteri di ricerca sull'istituto
				Join<ClasseComposizioneEntity, IstitutoEntity> joinIstituto = root
						.join(ClasseComposizioneEntity_.ISTITUTO_SUCCESSIVA, JoinType.LEFT);

				specification = super.applyJoinInFilterGeneric(criteria.getIstitutoSuccessiva(),
						IstitutoEntity_.ID, joinIstituto);
			}
			return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
		};
	}
	
	protected Specification<ClasseComposizioneEntity> buildClasseSuccessivaSpecification(ClasseComposizioneCriteria criteria) {
		return (root, criteriaQuery, criteriaBuilder) -> {

			Specification<ClasseComposizioneEntity> specification = Specification.where(null);

			if (criteria.getClasseSuccessiva() != null && !criteria.getClasseSuccessiva().isEmpty()) {

				// costruisco la join per applicare i criteri di ricerca sulla classe
				Join<ClasseComposizioneEntity, ClasseEntity> joinClasse = root
						.join(ClasseComposizioneEntity_.CLASSE_SUCCESSIVA, JoinType.LEFT);

				specification = super.applyJoinInFilterGeneric(criteria.getClasseSuccessiva(),
						ClasseEntity_.ID, joinClasse);
			}
			return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
		};
	}
	
	protected Specification<ClasseComposizioneEntity> buildSezioneSuccessivaSpecification(ClasseComposizioneCriteria criteria) {
		return (root, criteriaQuery, criteriaBuilder) -> {

			Specification<ClasseComposizioneEntity> specification = Specification.where(null);

			if (criteria.getSezioneSuccessiva() != null && !criteria.getSezioneSuccessiva().isEmpty()) {

				// costruisco la join per applicare i criteri di ricerca sulla sezione
				Join<ClasseComposizioneEntity, SezioneEntity> joinSezione = root
						.join(ClasseComposizioneEntity_.SEZIONE_SUCCESSIVA, JoinType.LEFT);

				specification = super.applyJoinInFilterGeneric(criteria.getSezioneSuccessiva(),
						SezioneEntity_.ID, joinSezione);
			}
			return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
		};
	}
	
}
