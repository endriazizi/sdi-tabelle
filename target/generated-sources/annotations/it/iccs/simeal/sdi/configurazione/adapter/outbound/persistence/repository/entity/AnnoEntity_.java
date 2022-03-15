package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity;

import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(AnnoEntity.class)
public abstract class AnnoEntity_ {

	public static volatile SingularAttribute<AnnoEntity, Short> flagCongelaAnno;
	public static volatile SingularAttribute<AnnoEntity, String> descrizione;
	public static volatile SingularAttribute<AnnoEntity, Integer> anno;
	public static volatile SingularAttribute<AnnoEntity, Short> annoCorrente;
	public static volatile SingularAttribute<AnnoEntity, Short> flagIseeCalcolo;
	public static volatile SingularAttribute<AnnoEntity, UUID> id;

	public static final String FLAG_CONGELA_ANNO = "flagCongelaAnno";
	public static final String DESCRIZIONE = "descrizione";
	public static final String ANNO = "anno";
	public static final String ANNO_CORRENTE = "annoCorrente";
	public static final String FLAG_ISEE_CALCOLO = "flagIseeCalcolo";
	public static final String ID = "id";

}

