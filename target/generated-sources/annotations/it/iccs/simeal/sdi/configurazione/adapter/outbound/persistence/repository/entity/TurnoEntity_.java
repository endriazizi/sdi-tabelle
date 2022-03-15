package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TurnoEntity.class)
public abstract class TurnoEntity_ {

	public static volatile SingularAttribute<TurnoEntity, String> descrizione;
	public static volatile SingularAttribute<TurnoEntity, Short> flagElimina;
	public static volatile SingularAttribute<TurnoEntity, UUID> idGiro;
	public static volatile SingularAttribute<TurnoEntity, UUID> id;

	public static final String DESCRIZIONE = "descrizione";
	public static final String FLAG_ELIMINA = "flagElimina";
	public static final String ID_GIRO = "idGiro";
	public static final String ID = "id";

}

