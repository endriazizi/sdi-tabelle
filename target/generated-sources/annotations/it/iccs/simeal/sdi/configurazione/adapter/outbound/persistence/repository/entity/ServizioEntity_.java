package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ServizioEntity.class)
public abstract class ServizioEntity_ {

	public static volatile SingularAttribute<ServizioEntity, String> descrizione;
	public static volatile SingularAttribute<ServizioEntity, Short> flagElimina;
	public static volatile SingularAttribute<ServizioEntity, Short> codice;
	public static volatile SingularAttribute<ServizioEntity, UUID> idEnte;
	public static volatile SingularAttribute<ServizioEntity, UUID> id;

	public static final String DESCRIZIONE = "descrizione";
	public static final String FLAG_ELIMINA = "flagElimina";
	public static final String CODICE = "codice";
	public static final String ID_ENTE = "idEnte";
	public static final String ID = "id";

}

