package it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model;



import java.io.Serializable;
import java.util.UUID;

import javax.validation.constraints.NotNull;

import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TariffaTipoCreateDTO.ServizioInnerDTO;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.experimental.Accessors;

@Data
@Accessors(chain = true)
@EqualsAndHashCode
public class TariffaTipoDTO implements Serializable {

    private static final long serialVersionUID = 1L;

    private UUID id;

    private UUID idEnte;

    @NotNull
    private ServizioInnerDTO servizio;

    @NotNull
    private String descrizione;

    private Short flagElimina;

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
