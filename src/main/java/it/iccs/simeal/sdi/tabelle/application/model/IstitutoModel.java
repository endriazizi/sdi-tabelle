package it.iccs.simeal.sdi.tabelle.application.model;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class IstitutoModel implements Serializable {

	private static final long serialVersionUID = 1L;

	private UUID id;
		
	private UUID idEnte;
	
	private String denominazione;
	
	private String partitaIva;

	private String indirizzo;
	
	private UUID idStradario;

	private String civico;
	
	private Integer numeroClassi;
	
	private Integer numeroAlunni;
	
	private String referente;
	
	private String telefono;
	
	private String fax;
	
	private String email;
	
	private UUID idTipologiaIstituto;
	
	private Date dataInizio;
	
	private Date dataFine;
	
	private String meccanograficoPlesso;
	
	private String meccanograficoScuola;
	
	private Double latitudine;
	
	private Double longitudine;
	
	private Short flagTipoIstituto;
	
	private Short flagAnticipo;
	
	private Short flagPosticipo;
	
	private Short flagTempoProlungato;
	
	private Integer sicraCodiceVia;
	
	private String sicraCivico;
	
	private String codiceEsterno;

	private Short flagElimina;

}