package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity;

import java.io.Serializable;
import java.util.Date;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name = "sdi_cnf_istituto")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Accessors(chain = true)
public class IstitutoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;

	@Column(name = "id_ente")
	private UUID idEnte;

	@Size(max = 100)
	@Column(name = "denominazione")
	private String denominazione;

	@Size(max = 11)
	@Column(name = "partita_iva")
	private String partitaIva;

	@Size(max = 100)
	@Column(name = "indirizzo")
	private String indirizzo;

	@Column(name = "id_stradario")
	private UUID idStradario;

	@Size(max = 11)
	@Column(name = "civico")
	private String civico;

	@Column(name = "numero_classi")
	private Integer numeroClassi;

	@Column(name = "numero_alunni")
	private Integer numeroAlunni;

	@Size(max = 100)
	@Column(name = "referente")
	private String referente;

	@Size(max = 15)
	@Column(name = "telefono")
	private String telefono;

	@Size(max = 15)
	@Column(name = "fax")
	private String fax;

	@Size(max = 15)
	@Column(name = "email")
	private String email;

	@Column(name = "id_tipologia_istituto")
	private UUID idTipologiaIstituto;

	@Column(name = "data_inizio")
	private Date dataInizio;

	@Column(name = "data_fine")
	private Date dataFine;

	@Size(max = 50)
	@Column(name = "meccanografico_plesso")
	private String meccanograficoPlesso;

	@Size(max = 50)
	@Column(name = "meccanografico_scuola")
	private String meccanograficoScuola;

	@Column(name = "latitudine")
	private Double latitudine;

	@Column(name = "longitudine")
	private Double longitudine;

	@Column(name = "flag_tipo_istituto")
	private Short flagTipoIstituto;

	@Column(name = "flag_anticipo")
	private Short flagAnticipo;

	@Column(name = "flag_posticipo")
	private Short flagPosticipo;

	@Column(name = "flag_tempo_prolungato")
	private Short flagTempoProlungato;

	@Column(name = "sicra_codice_via")
	private Integer sicraCodiceVia;

	@Size(max = 10)
	@Column(name = "sicra_civico")
	private String sicraCivico;

	@Size(max = 20)
	@Column(name = "codice_esterno")
	private String codiceEsterno;
	
	@Column(name = "flag_elimina")
	private Short flagElimina;

}