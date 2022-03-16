package it.iccs.simeal.sdi.tabelle.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.tabelle.application.model.RiduzioneTipoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RiduzioneTipoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RiduzioneTipoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RiduzioneTipoUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface RiduzioneTipoModelMapper extends ModelMapper<RiduzioneTipoDTO, RiduzioneTipoModel> {

    default RiduzioneTipoModel fromId(UUID id) {
        if (id == null) {
            return null;
        }
        return new RiduzioneTipoModel().setId(id);
    }

    RiduzioneTipoDTO fromCreateDto(RiduzioneTipoCreateDTO dto);

    RiduzioneTipoDTO fromUpdateDto(RiduzioneTipoUpdateDTO dto);

}