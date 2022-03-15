package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(ServizioAnnoEntity.class)
public abstract class ServizioAnnoEntity_ {

	public static volatile SingularAttribute<ServizioAnnoEntity, Integer> anno;
	public static volatile SingularAttribute<ServizioAnnoEntity, ServizioEntity> servizio;
	public static volatile SingularAttribute<ServizioAnnoEntity, UUID> id;
	public static volatile SingularAttribute<ServizioAnnoEntity, Integer> tipologiaRilevazione;

	public static final String ANNO = "anno";
	public static final String SERVIZIO = "servizio";
	public static final String ID = "id";
	public static final String TIPOLOGIA_RILEVAZIONE = "tipologiaRilevazione";

}

