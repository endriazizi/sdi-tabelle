package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ClasseComposizioneEntity.class)
public abstract class ClasseComposizioneEntity_ {

	public static volatile SingularAttribute<ClasseComposizioneEntity, IstitutoEntity> istitutoSuccessiva;
	public static volatile SingularAttribute<ClasseComposizioneEntity, ClasseEntity> classeSuccessiva;
	public static volatile SingularAttribute<ClasseComposizioneEntity, ClasseEntity> classe;
	public static volatile SingularAttribute<ClasseComposizioneEntity, IstitutoEntity> istituto;
	public static volatile SingularAttribute<ClasseComposizioneEntity, Short> flagElimina;
	public static volatile SingularAttribute<ClasseComposizioneEntity, UUID> idEnte;
	public static volatile SingularAttribute<ClasseComposizioneEntity, UUID> id;
	public static volatile SingularAttribute<ClasseComposizioneEntity, SezioneEntity> sezione;
	public static volatile SingularAttribute<ClasseComposizioneEntity, SezioneEntity> sezioneSuccessiva;

	public static final String ISTITUTO_SUCCESSIVA = "istitutoSuccessiva";
	public static final String CLASSE_SUCCESSIVA = "classeSuccessiva";
	public static final String CLASSE = "classe";
	public static final String ISTITUTO = "istituto";
	public static final String FLAG_ELIMINA = "flagElimina";
	public static final String ID_ENTE = "idEnte";
	public static final String ID = "id";
	public static final String SEZIONE = "sezione";
	public static final String SEZIONE_SUCCESSIVA = "sezioneSuccessiva";

}

