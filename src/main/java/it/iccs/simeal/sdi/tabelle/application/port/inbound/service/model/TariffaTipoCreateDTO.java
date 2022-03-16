package it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model;

import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.NoArgsConstructor;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
@NoArgsConstructor
@AllArgsConstructor
public class TariffaTipoCreateDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID idEnte;

    @NotNull
    private ServizioInnerDTO servizio;

    @NotNull
    private String descrizione;

    @NotNull
    private Short flagRilevazione;

    @NotNull
    private Short flagPresenzaGenitore;

    private String descrizioneRilevazione;

    @Data
    @Accessors(chain = true)
    @EqualsAndHashCode
    public static class ServizioInnerDTO {
        @NotNull
        private UUID id;
    }


}
