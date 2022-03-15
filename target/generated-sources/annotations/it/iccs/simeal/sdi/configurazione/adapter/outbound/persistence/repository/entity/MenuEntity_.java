package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity;

import java.util.Date;
import java.util.UUID;
import javax.annotation.Generated;
import javax.persistence.metamodel.SingularAttribute;
import javax.persistence.metamodel.StaticMetamodel;

@Generated(value = "org.hibernate.jpamodelgen.JPAMetaModelEntityProcessor")
@StaticMetamodel(MenuEntity.class)
public abstract class MenuEntity_ {

	public static volatile SingularAttribute<MenuEntity, String> descrizione;
	public static volatile SingularAttribute<MenuEntity, Date> dataInizio;
	public static volatile SingularAttribute<MenuEntity, Integer> anno;
	public static volatile SingularAttribute<MenuEntity, Short> flagElimina;
	public static volatile SingularAttribute<MenuEntity, String> filenameMenu;
	public static volatile SingularAttribute<MenuEntity, Date> dataFine;
	public static volatile SingularAttribute<MenuEntity, UUID> idEnte;
	public static volatile SingularAttribute<MenuEntity, UUID> id;

	public static final String DESCRIZIONE = "descrizione";
	public static final String DATA_INIZIO = "dataInizio";
	public static final String ANNO = "anno";
	public static final String FLAG_ELIMINA = "flagElimina";
	public static final String FILENAME_MENU = "filenameMenu";
	public static final String DATA_FINE = "dataFine";
	public static final String ID_ENTE = "idEnte";
	public static final String ID = "id";

}

