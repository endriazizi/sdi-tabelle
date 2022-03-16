package it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.model.RiduzioneTipoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RiduzioneTipoCriteria;

public interface RiduzioneTipoPersistence  {

    RiduzioneTipoModel save(RiduzioneTipoModel model);

    Page<RiduzioneTipoModel> search(RiduzioneTipoCriteria criteria, Pageable pageRequest);

}