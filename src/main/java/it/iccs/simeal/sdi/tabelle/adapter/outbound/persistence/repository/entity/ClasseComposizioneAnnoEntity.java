package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity;

import java.io.Serializable;
import java.util.UUID;

import javax.persistence.CascadeType;
import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.JoinColumn;
import javax.persistence.ManyToOne;
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
@Table(name = "sdi_cnf_classe_composizione_anno")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Accessors(chain = true)
public class ClasseComposizioneAnnoEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;

	@Column(name = "anno")
	private Integer anno;
	
	@NotNull
	@JoinColumn(name = "id_turno", referencedColumnName = "id")
	@OneToOne(cascade = CascadeType.PERSIST)
	@Fetch(FetchMode.SELECT)
	private TurnoEntity turno;
	
	@NotNull
	@JoinColumn(name = "id_refettorio", referencedColumnName = "id")
	@OneToOne(cascade = CascadeType.PERSIST)
	@Fetch(FetchMode.SELECT)
	private RefettorioEntity refettorio;
	
	@NotNull
	@JoinColumn(name = "id_classe_composizione", referencedColumnName = "id")
	@ManyToOne(cascade = CascadeType.PERSIST)
	@Fetch(FetchMode.SELECT)
	private ClasseComposizioneEntity classeComposizione;
	
	@Column(name = "flag_visibile")
	private Short flagVisibile;

}
