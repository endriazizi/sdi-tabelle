package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity;


import java.io.Serializable;
import java.util.UUID;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;
import javax.validation.constraints.NotNull;
import javax.validation.constraints.Size;

import org.hibernate.annotations.Cache;
import org.hibernate.annotations.CacheConcurrencyStrategy;
import org.hibernate.annotations.GenericGenerator;

import lombok.Data;
import lombok.experimental.Accessors;

@Data
@Entity
@Table(name = "sdi_cnf_tariffa_tipo")
@Cache(usage = CacheConcurrencyStrategy.READ_WRITE)
@Accessors(chain = true)
public class TariffaTipoEntity implements Serializable {

    private static final long serialVersionUID = 1L;

    @Id
    @GeneratedValue(generator = "UUID")
    @GenericGenerator(name = "UUID", strategy = "org.hibernate.id.UUIDGenerator")
    private UUID id;

    @Column(name = "id_ente")
    private UUID idEnte;

    @NotNull
    @Size(max = 100)
    @Column(name = "descrizione")
    private String descrizione;

    @Column(name = "flag_elimina")
    private Short flagElimina;

    @NotNull
    @Column(name = "id_servizio")
    private UUID idServizio;

    @Column(name = "flag_rilevazione")
    private Short flagRilevazione;

    @Column(name = "flag_presenza_genitore")
    private Short flagPresenzaGenitore;

    @Size(max = 100)
    @Column(name = "descrizione_rilevazione")
    private String descrizioneRilevazione;

}
