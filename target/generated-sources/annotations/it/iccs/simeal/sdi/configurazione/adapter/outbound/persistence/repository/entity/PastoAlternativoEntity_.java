package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(PastoAlternativoEntity.class)
public abstract class PastoAlternativoEntity_ {

	public static volatile SingularAttribute<PastoAlternativoEntity, String> descrizione;
	public static volatile SingularAttribute<PastoAlternativoEntity, Short> flagAbilitato;
	public static volatile SingularAttribute<PastoAlternativoEntity, UUID> id;
	public static volatile SingularAttribute<PastoAlternativoEntity, Integer> ordinePasto;

	public static final String DESCRIZIONE = "descrizione";
	public static final String FLAG_ABILITATO = "flagAbilitato";
	public static final String ID = "id";
	public static final String ORDINE_PASTO = "ordinePasto";

}

