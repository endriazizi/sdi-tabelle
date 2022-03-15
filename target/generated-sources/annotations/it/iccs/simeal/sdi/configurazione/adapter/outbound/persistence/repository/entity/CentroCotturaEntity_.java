package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CentroCotturaEntity.class)
public abstract class CentroCotturaEntity_ {

	public static volatile SingularAttribute<CentroCotturaEntity, String> referente;
	public static volatile SingularAttribute<CentroCotturaEntity, Short> flagElimina;
	public static volatile SingularAttribute<CentroCotturaEntity, String> indirizzo;
	public static volatile SingularAttribute<CentroCotturaEntity, String> denominazione;
	public static volatile SingularAttribute<CentroCotturaEntity, UUID> id;
	public static volatile SingularAttribute<CentroCotturaEntity, String> civico;
	public static volatile SingularAttribute<CentroCotturaEntity, String> provincia;
	public static volatile SingularAttribute<CentroCotturaEntity, String> telefono;
	public static volatile SingularAttribute<CentroCotturaEntity, String> fax;
	public static volatile SingularAttribute<CentroCotturaEntity, String> email;
	public static volatile SingularAttribute<CentroCotturaEntity, String> citta;
	public static volatile SingularAttribute<CentroCotturaEntity, String> pec;

	public static final String REFERENTE = "referente";
	public static final String FLAG_ELIMINA = "flagElimina";
	public static final String INDIRIZZO = "indirizzo";
	public static final String DENOMINAZIONE = "denominazione";
	public static final String ID = "id";
	public static final String CIVICO = "civico";
	public static final String PROVINCIA = "provincia";
	public static final String TELEFONO = "telefono";
	public static final String FAX = "fax";
	public static final String EMAIL = "email";
	public static final String CITTA = "citta";
	public static final String PEC = "pec";

}

