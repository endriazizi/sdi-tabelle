package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity;

import java.time.LocalDate;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ChiusuraEntity.class)
public abstract class ChiusuraEntity_ {

	public static volatile SingularAttribute<ChiusuraEntity, ClasseEntity> classe;
	public static volatile SingularAttribute<ChiusuraEntity, String> descrizione;
	public static volatile SingularAttribute<ChiusuraEntity, LocalDate> dataInizio;
	public static volatile SingularAttribute<ChiusuraEntity, Integer> anno;
	public static volatile SingularAttribute<ChiusuraEntity, IstitutoEntity> istituto;
	public static volatile SingularAttribute<ChiusuraEntity, Short> flagElimina;
	public static volatile SingularAttribute<ChiusuraEntity, ServizioEntity> servizio;
	public static volatile SingularAttribute<ChiusuraEntity, LocalDate> dataFine;
	public static volatile SingularAttribute<ChiusuraEntity, UUID> id;
	public static volatile SingularAttribute<ChiusuraEntity, SezioneEntity> sezione;

	public static final String CLASSE = "classe";
	public static final String DESCRIZIONE = "descrizione";
	public static final String DATA_INIZIO = "dataInizio";
	public static final String ANNO = "anno";
	public static final String ISTITUTO = "istituto";
	public static final String FLAG_ELIMINA = "flagElimina";
	public static final String SERVIZIO = "servizio";
	public static final String DATA_FINE = "dataFine";
	public static final String ID = "id";
	public static final String SEZIONE = "sezione";

}

