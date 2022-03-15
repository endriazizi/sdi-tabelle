package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity;

import java.time.LocalDate;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(CentroCotturaIstitutoEntity.class)
public abstract class CentroCotturaIstitutoEntity_ {

	public static volatile SingularAttribute<CentroCotturaIstitutoEntity, LocalDate> dataInizio;
	public static volatile SingularAttribute<CentroCotturaIstitutoEntity, IstitutoEntity> istituto;
	public static volatile SingularAttribute<CentroCotturaIstitutoEntity, LocalDate> dataFine;
	public static volatile SingularAttribute<CentroCotturaIstitutoEntity, UUID> id;
	public static volatile SingularAttribute<CentroCotturaIstitutoEntity, CentroCotturaEntity> centroCottura;

	public static final String DATA_INIZIO = "dataInizio";
	public static final String ISTITUTO = "istituto";
	public static final String DATA_FINE = "dataFine";
	public static final String ID = "id";
	public static final String CENTRO_COTTURA = "centroCottura";

}

