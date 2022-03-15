package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ClasseComposizioneAnnoEntity.class)
public abstract class ClasseComposizioneAnnoEntity_ {

	public static volatile SingularAttribute<ClasseComposizioneAnnoEntity, RefettorioEntity> refettorio;
	public static volatile SingularAttribute<ClasseComposizioneAnnoEntity, ClasseComposizioneEntity> classeComposizione;
	public static volatile SingularAttribute<ClasseComposizioneAnnoEntity, Integer> anno;
	public static volatile SingularAttribute<ClasseComposizioneAnnoEntity, Short> flagVisibile;
	public static volatile SingularAttribute<ClasseComposizioneAnnoEntity, UUID> id;
	public static volatile SingularAttribute<ClasseComposizioneAnnoEntity, TurnoEntity> turno;

	public static final String REFETTORIO = "refettorio";
	public static final String CLASSE_COMPOSIZIONE = "classeComposizione";
	public static final String ANNO = "anno";
	public static final String FLAG_VISIBILE = "flagVisibile";
	public static final String ID = "id";
	public static final String TURNO = "turno";

}

