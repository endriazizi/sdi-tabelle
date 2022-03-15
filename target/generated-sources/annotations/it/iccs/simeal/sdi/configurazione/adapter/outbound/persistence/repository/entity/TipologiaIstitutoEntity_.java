package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(TipologiaIstitutoEntity.class)
public abstract class TipologiaIstitutoEntity_ {

	public static volatile SingularAttribute<TipologiaIstitutoEntity, String> descrizione;
	public static volatile SingularAttribute<TipologiaIstitutoEntity, Short> flagElimina;
	public static volatile SingularAttribute<TipologiaIstitutoEntity, UUID> id;

	public static final String DESCRIZIONE = "descrizione";
	public static final String FLAG_ELIMINA = "flagElimina";
	public static final String ID = "id";

}

