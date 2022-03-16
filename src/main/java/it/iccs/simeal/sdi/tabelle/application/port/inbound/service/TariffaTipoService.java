package it.iccs.simeal.sdi.tabelle.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TariffaTipoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TariffaTipoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TariffaTipoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TariffaTipoUpdateDTO;

public interface TariffaTipoService {

    TariffaTipoDTO create(TariffaTipoCreateDTO dto);

    List<TariffaTipoDTO> findByIds(List<UUID> ids);

    Page<TariffaTipoDTO> search(TariffaTipoCriteria criteria, Pageable pageRequest);

    TariffaTipoDTO update(TariffaTipoUpdateDTO dto);

    void delete(UUID id);

}