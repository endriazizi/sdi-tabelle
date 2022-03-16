package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.RiduzioneTipoEntity;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RiduzioneTipoCriteria;

public class RiduzioneTipoSpecification extends AbstractSpecification<RiduzioneTipoEntity> {

    public Specification<RiduzioneTipoEntity> filter(RiduzioneTipoCriteria criteria) {

        String flagName = "flagElimina";
        Short flagValue = 0;

        Specification<RiduzioneTipoEntity> specification =
                super.flagSpecification(flagName, flagValue)
                        .and(super.applyInUUIDFilter(criteria.getId(), "id"))
                        .and(super.applySearchFilter(criteria.getDescrizione(), "descrizione"));
        return specification;
    }

}