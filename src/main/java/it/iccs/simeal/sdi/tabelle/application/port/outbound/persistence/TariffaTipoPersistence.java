package it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.model.TariffaTipoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TariffaTipoCriteria;

public interface TariffaTipoPersistence  {

    TariffaTipoModel save(TariffaTipoModel model);

    Page<TariffaTipoModel> search(TariffaTipoCriteria criteria, Pageable pageRequest);

}