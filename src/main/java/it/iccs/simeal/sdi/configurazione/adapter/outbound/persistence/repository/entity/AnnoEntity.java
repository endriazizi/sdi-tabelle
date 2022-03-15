package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity;

import java.io.Serializable;
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
@Table(name = "sdi_cnf_anno")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Accessors(chain = true)
public class AnnoEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
	
	@Column(name = "anno")
	private Integer anno;

	@Size(max = 20)
	@Column(name = "descrizione")
	private String descrizione;

	@Column(name = "anno_corrente")
	private Short annoCorrente;

	@Column(name = "flag_congela_anno")
	private Short flagCongelaAnno;

	@Column(name = "flag_isee_calcolo")
	private Short flagIseeCalcolo;
	
}
