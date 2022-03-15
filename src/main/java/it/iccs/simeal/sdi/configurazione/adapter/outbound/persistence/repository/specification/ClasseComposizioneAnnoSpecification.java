package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.specification;

import javax.persistence.criteria.Join;
import javax.persistence.criteria.JoinType;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ClasseComposizioneAnnoEntity_;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ClasseComposizioneEntity_;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.RefettorioEntity_;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.TurnoEntity_;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ClasseComposizioneAnnoEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ClasseComposizioneEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.RefettorioEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.TurnoEntity;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneAnnoCriteria;

public class ClasseComposizioneAnnoSpecification extends AbstractSpecification<ClasseComposizioneAnnoEntity> {
	
	public Specification<ClasseComposizioneAnnoEntity> filter(ClasseComposizioneAnnoCriteria criteria) {

		String flagName = "flagVisibile";
		Short flagValue = 1;
		
		Specification<ClasseComposizioneAnnoEntity> specification =
				super.flagSpecification(flagName, flagValue)
				.and(super.applyInUUIDFilter(criteria.getId(), "id"))
				.and(super.applyInIntegerFilter(criteria.getAnno(), "anno"))
                .and(this.buildTurnoSpecification(criteria))
				.and(this.buildRefettorioSpecification(criteria))
				.and(this.buildClasseComposizioneSpecification(criteria));
        return specification;
	}

	private Specification<ClasseComposizioneAnnoEntity> buildTurnoSpecification(ClasseComposizioneAnnoCriteria criteria) {
		return (root, criteriaQuery, criteriaBuilder) -> {

			Specification<ClasseComposizioneAnnoEntity> specification = Specification.where(null);

			if (criteria.getTurno() != null && !criteria.getTurno().isEmpty()) {

				// costruisco la join per applicare i criteri di ricerca sul turno mensa
				Join<ClasseComposizioneAnnoEntity, TurnoEntity> joinTurno = root
						.join(ClasseComposizioneAnnoEntity_.TURNO, JoinType.LEFT);

				specification = super.applyJoinInFilterGeneric(criteria.getTurno(),
						TurnoEntity_.ID, joinTurno);
			}
			return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
		};
	}

	private Specification<ClasseComposizioneAnnoEntity> buildRefettorioSpecification(ClasseComposizioneAnnoCriteria criteria) {
		return (root, criteriaQuery, criteriaBuilder) -> {

			Specification<ClasseComposizioneAnnoEntity> specification = Specification.where(null);

			if (criteria.getRefettorio() != null && !criteria.getRefettorio().isEmpty()) {

				// costruisco la join per applicare i criteri di ricerca sul refettorio mensa
				Join<ClasseComposizioneAnnoEntity, RefettorioEntity> joinRefettorio = root
						.join(ClasseComposizioneAnnoEntity_.REFETTORIO, JoinType.LEFT);

				specification = super.applyJoinInFilterGeneric(criteria.getRefettorio(),
						RefettorioEntity_.ID, joinRefettorio);
			}
			return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
		};
	}
	
	private Specification<ClasseComposizioneAnnoEntity> buildClasseComposizioneSpecification(ClasseComposizioneAnnoCriteria criteria) {
		return (root, criteriaQuery, criteriaBuilder) -> {

			Specification<ClasseComposizioneAnnoEntity> specification = Specification.where(null);

			if (criteria.getClasseComposizione() != null && !criteria.getClasseComposizione().isEmpty()) {

				// costruisco la join per applicare i criteri di ricerca sul refettorio mensa
				Join<ClasseComposizioneAnnoEntity, ClasseComposizioneEntity> joinClasseComposizione = root
						.join(ClasseComposizioneAnnoEntity_.CLASSE_COMPOSIZIONE, JoinType.LEFT);

				specification = super.applyJoinInFilterGeneric(criteria.getClasseComposizione(),
						ClasseComposizioneEntity_.ID, joinClasseComposizione);
			}
			return specification.toPredicate(root, criteriaQuery, criteriaBuilder);
		};
	}

}
