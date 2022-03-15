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
@Table(name = "sdi_cnf_centro_cottura")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Accessors(chain = true)
public class CentroCotturaEntity implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
	private UUID id;
	
	@Size(max = 100)
	@Column(name = "denominazione")
	private String denominazione;
	
	@Size(max = 100)
	@Column(name = "indirizzo")
	private String indirizzo;
	
	@Size(max = 100)
	@Column(name = "civico")
	private String civico;
	
	@Size(max = 100)
	@Column(name = "citta")
	private String citta;
	
	@Size(max = 2)
	@Column(name = "provincia")
	private String provincia;
	
	@Size(max = 100)
	@Column(name = "referente")
	private String referente;
	
	@Size(max = 100)
	@Column(name = "telefono")
	private String telefono;
	
	@Size(max = 100)
	@Column(name = "fax")
	private String fax;
	
	@Size(max = 100)
	@Column(name = "email")
	private String email;
	
	@Size(max = 100)
	@Column(name = "pec")
	private String pec;
	
	@Column(name = "flag_elimina")
	private Short flagElimina;

}