package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ClasseEntity.class)
public abstract class ClasseEntity_ {

	public static volatile SingularAttribute<ClasseEntity, String> descrizione;
	public static volatile SingularAttribute<ClasseEntity, Short> flagElimina;
	public static volatile SingularAttribute<ClasseEntity, UUID> id;

	public static final String DESCRIZIONE = "descrizione";
	public static final String FLAG_ELIMINA = "flagElimina";
	public static final String ID = "id";

}

