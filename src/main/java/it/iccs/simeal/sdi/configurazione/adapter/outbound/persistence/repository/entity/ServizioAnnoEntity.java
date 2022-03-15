package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.OneToOne;
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
@Table(name = "sdi_cnf_servizio_anno")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Accessors(chain = true)
public class ServizioAnnoEntity implements Serializable {
	
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
	@OneToOne(cascade = CascadeType.PERSIST)
	@Fetch(FetchMode.SELECT)
	private ServizioEntity servizio;
	
	@NotNull
	@Column(name = "tipologia_rilevazione")
	private Integer tipologiaRilevazione;

}
