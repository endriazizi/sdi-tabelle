package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity;

import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(IstitutoEntity.class)
public abstract class IstitutoEntity_ {

	public static volatile SingularAttribute<IstitutoEntity, Integer> numeroClassi;
	public static volatile SingularAttribute<IstitutoEntity, Short> flagTempoProlungato;
	public static volatile SingularAttribute<IstitutoEntity, String> referente;
	public static volatile SingularAttribute<IstitutoEntity, UUID> idTipologiaIstituto;
	public static volatile SingularAttribute<IstitutoEntity, String> indirizzo;
	public static volatile SingularAttribute<IstitutoEntity, String> sicraCivico;
	public static volatile SingularAttribute<IstitutoEntity, String> meccanograficoPlesso;
	public static volatile SingularAttribute<IstitutoEntity, Short> flagTipoIstituto;
	public static volatile SingularAttribute<IstitutoEntity, Short> flagElimina;
	public static volatile SingularAttribute<IstitutoEntity, Double> latitudine;
	public static volatile SingularAttribute<IstitutoEntity, Short> flagPosticipo;
	public static volatile SingularAttribute<IstitutoEntity, Date> dataFine;
	public static volatile SingularAttribute<IstitutoEntity, Integer> sicraCodiceVia;
	public static volatile SingularAttribute<IstitutoEntity, UUID> idEnte;
	public static volatile SingularAttribute<IstitutoEntity, String> denominazione;
	public static volatile SingularAttribute<IstitutoEntity, UUID> id;
	public static volatile SingularAttribute<IstitutoEntity, String> telefono;
	public static volatile SingularAttribute<IstitutoEntity, String> fax;
	public static volatile SingularAttribute<IstitutoEntity, String> email;
	public static volatile SingularAttribute<IstitutoEntity, UUID> idStradario;
	public static volatile SingularAttribute<IstitutoEntity, String> civico;
	public static volatile SingularAttribute<IstitutoEntity, String> meccanograficoScuola;
	public static volatile SingularAttribute<IstitutoEntity, Short> flagAnticipo;
	public static volatile SingularAttribute<IstitutoEntity, Date> dataInizio;
	public static volatile SingularAttribute<IstitutoEntity, String> codiceEsterno;
	public static volatile SingularAttribute<IstitutoEntity, String> partitaIva;
	public static volatile SingularAttribute<IstitutoEntity, Integer> numeroAlunni;
	public static volatile SingularAttribute<IstitutoEntity, Double> longitudine;

	public static final String NUMERO_CLASSI = "numeroClassi";
	public static final String FLAG_TEMPO_PROLUNGATO = "flagTempoProlungato";
	public static final String REFERENTE = "referente";
	public static final String ID_TIPOLOGIA_ISTITUTO = "idTipologiaIstituto";
	public static final String INDIRIZZO = "indirizzo";
	public static final String SICRA_CIVICO = "sicraCivico";
	public static final String MECCANOGRAFICO_PLESSO = "meccanograficoPlesso";
	public static final String FLAG_TIPO_ISTITUTO = "flagTipoIstituto";
	public static final String FLAG_ELIMINA = "flagElimina";
	public static final String LATITUDINE = "latitudine";
	public static final String FLAG_POSTICIPO = "flagPosticipo";
	public static final String DATA_FINE = "dataFine";
	public static final String SICRA_CODICE_VIA = "sicraCodiceVia";
	public static final String ID_ENTE = "idEnte";
	public static final String DENOMINAZIONE = "denominazione";
	public static final String ID = "id";
	public static final String TELEFONO = "telefono";
	public static final String FAX = "fax";
	public static final String EMAIL = "email";
	public static final String ID_STRADARIO = "idStradario";
	public static final String CIVICO = "civico";
	public static final String MECCANOGRAFICO_SCUOLA = "meccanograficoScuola";
	public static final String FLAG_ANTICIPO = "flagAnticipo";
	public static final String DATA_INIZIO = "dataInizio";
	public static final String CODICE_ESTERNO = "codiceEsterno";
	public static final String PARTITA_IVA = "partitaIva";
	public static final String NUMERO_ALUNNI = "numeroAlunni";
	public static final String LONGITUDINE = "longitudine";

}

