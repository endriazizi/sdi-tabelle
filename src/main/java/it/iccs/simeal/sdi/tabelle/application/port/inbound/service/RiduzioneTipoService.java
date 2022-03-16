package it.iccs.simeal.sdi.tabelle.application.port.inbound.service;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RiduzioneTipoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RiduzioneTipoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RiduzioneTipoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RiduzioneTipoUpdateDTO;

public interface RiduzioneTipoService {

    RiduzioneTipoDTO create(RiduzioneTipoCreateDTO dto);

    List<RiduzioneTipoDTO> findByIds(List<UUID> ids);

    Page<RiduzioneTipoDTO> search(RiduzioneTipoCriteria criteria, Pageable pageRequest);

    RiduzioneTipoDTO update(RiduzioneTipoUpdateDTO dto);

    void delete(UUID id);

}
