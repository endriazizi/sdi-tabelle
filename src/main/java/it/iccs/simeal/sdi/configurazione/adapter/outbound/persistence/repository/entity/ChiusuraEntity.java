package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity;

import java.io.Serializable;
import java.time.LocalDate;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.Fetch;
import org.hibernate.annotations.FetchMode;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name = "sdi_cnf_chiusura")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Accessors(chain = true)
public class ChiusuraEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	
	@NotNull
	@Column(name = "anno")
	private Integer anno;
	
	@NotNull
	@JoinColumn(name = "id_servizio", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.PERSIST)
	@Fetch(FetchMode.SELECT)
	private ServizioEntity servizio;
	
	@NotNull
	@JoinColumn(name = "id_istituto", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.PERSIST)
	@Fetch(FetchMode.SELECT)
	private IstitutoEntity istituto;
	
	@NotNull
	@JoinColumn(name = "id_classe", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.PERSIST)
	@Fetch(FetchMode.SELECT)
	private ClasseEntity classe;
	
	@NotNull
	@JoinColumn(name = "id_sezione", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.PERSIST)
	@Fetch(FetchMode.SELECT)
	private SezioneEntity sezione;
	
	@NotNull
	@Column(name = "descrizione")
	private String descrizione;
	
	@NotNull
	@Column(name = "data_inizio")
	private LocalDate dataInizio;

	@NotNull
	@Column(name = "data_fine")
	private LocalDate dataFine;
	
	@Column(name = "flag_elimina")
	private Short flagElimina;

}
