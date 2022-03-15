package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity;

import java.time.LocalDate;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AperturaEntity.class)
public abstract class AperturaEntity_ {

	public static volatile SingularAttribute<AperturaEntity, ClasseEntity> classe;
	public static volatile SingularAttribute<AperturaEntity, String> descrizione;
	public static volatile SingularAttribute<AperturaEntity, LocalDate> dataInizio;
	public static volatile SingularAttribute<AperturaEntity, Integer> anno;
	public static volatile SingularAttribute<AperturaEntity, IstitutoEntity> istituto;
	public static volatile SingularAttribute<AperturaEntity, Short> flagElimina;
	public static volatile SingularAttribute<AperturaEntity, ServizioEntity> servizio;
	public static volatile SingularAttribute<AperturaEntity, LocalDate> dataFine;
	public static volatile SingularAttribute<AperturaEntity, UUID> id;
	public static volatile SingularAttribute<AperturaEntity, SezioneEntity> sezione;

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

