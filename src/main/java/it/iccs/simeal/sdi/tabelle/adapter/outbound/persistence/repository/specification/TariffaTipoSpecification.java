package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.specification;

import org.springframework.data.jpa.domain.Specification;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.TariffaTipoEntity;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TariffaTipoCriteria;

public class TariffaTipoSpecification extends AbstractSpecification<TariffaTipoEntity> {

    public Specification<TariffaTipoEntity> filter(TariffaTipoCriteria criteria) {

        String flagName = "flagElimina";
        Short flagValue = 0;

        Specification<TariffaTipoEntity> specification =
                super.flagSpecification(flagName, flagValue)
                        .and(super.applyInUUIDFilter(criteria.getId(), "id"))
                        .and(super.applySearchFilter(criteria.getDescrizione(), "descrizione"))
                        .and(super.applyInUUIDFilter(criteria.getIdServizio(), "id_servizio"))
                        .and(super.flagSpecification("flag_rilevazione", criteria.getFlagRilevazione()))
                        .and(super.flagSpecification("flag_presenza_genitore", criteria.getFlagPresenzaGenitore()));
        return specification;
    }

}