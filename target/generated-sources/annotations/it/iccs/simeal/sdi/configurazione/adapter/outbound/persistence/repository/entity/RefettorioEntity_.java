package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(RefettorioEntity.class)
public abstract class RefettorioEntity_ {

	public static volatile SingularAttribute<RefettorioEntity, String> descrizione;
	public static volatile SingularAttribute<RefettorioEntity, Short> flagElimina;
	public static volatile SingularAttribute<RefettorioEntity, UUID> idEnte;
	public static volatile SingularAttribute<RefettorioEntity, UUID> id;

	public static final String DESCRIZIONE = "descrizione";
	public static final String FLAG_ELIMINA = "flagElimina";
	public static final String ID_ENTE = "idEnte";
	public static final String ID = "id";

}

