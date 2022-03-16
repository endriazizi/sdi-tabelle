package it.iccs.simeal.sdi.tabelle.application.mapper;

import java.util.UUID;

import org.mapstruct.Mapper;

import it.iccs.simeal.sdi.tabelle.application.model.TariffaTipoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TariffaTipoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TariffaTipoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TariffaTipoUpdateDTO;

@Mapper(componentModel = "spring", uses = {})
public interface TariffaTipoModelMapper extends ModelMapper<TariffaTipoDTO, TariffaTipoModel> {

    default TariffaTipoModel fromId(UUID id) {
        if (id == null) {
            return null;
        }
        return new TariffaTipoModel().setId(id);
    }

    TariffaTipoDTO fromCreateDto(TariffaTipoCreateDTO dto);

    TariffaTipoDTO fromUpdateDto(TariffaTipoUpdateDTO dto);

}
