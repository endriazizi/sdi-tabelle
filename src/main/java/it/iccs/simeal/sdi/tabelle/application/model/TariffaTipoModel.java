package it.iccs.simeal.sdi.tabelle.application.model;

import java.io.Serializable;
import java.util.UUID;

import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class TariffaTipoModel implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;

    private UUID id_ente;

    private String descrizione;

    private UUID id_servizio;

    private Short flagElimina;

    private Short flagRilevazione;

    private Short flagPresenzaGenitore;

    private String descrizioneRilevazione;

}
