package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity;

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
@Table(name = "sdi_cnf_menu")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Accessors(chain = true)
public class MenuEntity implements Serializable {

	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;
	
	@Column(name = "id_ente")
	private UUID idEnte;
	
	@Column(name = "anno")
	private Integer anno;

	@Size(max = 50)
	@Column(name = "descrizione")
	private String descrizione;
	
	@Column(name = "data_inizio")
	private Date dataInizio;

	@Column(name = "data_fine")
	private Date dataFine;
	
	@Column(name = "filenameMenu")
	private String filenameMenu;
	
	@Column(name = "flag_elimina")
	private Short flagElimina;
	
}
