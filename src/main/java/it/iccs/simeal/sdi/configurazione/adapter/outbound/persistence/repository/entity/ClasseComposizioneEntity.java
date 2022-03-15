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
@Table(name = "sdi_cnf_classe_composizione")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Accessors(chain = true)
public class ClasseComposizioneEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;

	@Column(name = "id_ente")
	private UUID idEnte;
	
	@NotNull
	@JoinColumn(name = "id_istituto", referencedColumnName = "id")
	@OneToOne(cascade = CascadeType.PERSIST)
	@Fetch(FetchMode.SELECT)
	private IstitutoEntity istituto;
	
	@NotNull
	@JoinColumn(name = "id_classe", referencedColumnName = "id")
	@OneToOne(cascade = CascadeType.PERSIST)
	@Fetch(FetchMode.SELECT)
	private ClasseEntity classe;
	
	@NotNull
	@JoinColumn(name = "id_sezione", referencedColumnName = "id")
	@OneToOne(cascade = CascadeType.PERSIST)
	@Fetch(FetchMode.SELECT)
	private SezioneEntity sezione;
	
	@NotNull
	@JoinColumn(name = "id_istituto_successiva", referencedColumnName = "id")
	@OneToOne(cascade = CascadeType.PERSIST)
	@Fetch(FetchMode.SELECT)
	private IstitutoEntity istitutoSuccessiva;
	
	@NotNull
	@JoinColumn(name = "id_classe_successiva", referencedColumnName = "id")
	@OneToOne(cascade = CascadeType.PERSIST)
	@Fetch(FetchMode.SELECT)
	private ClasseEntity classeSuccessiva;
	
	@NotNull
	@JoinColumn(name = "id_sezione_successiva", referencedColumnName = "id")
	@OneToOne(cascade = CascadeType.PERSIST)
	@Fetch(FetchMode.SELECT)
	private SezioneEntity sezioneSuccessiva;
	
	@Column(name = "flag_elimina")
	private Short flagElimina;

}
