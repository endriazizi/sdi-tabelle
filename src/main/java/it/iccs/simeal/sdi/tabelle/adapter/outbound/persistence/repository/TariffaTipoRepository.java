package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.TariffaTipoEntity;

@Repository
public interface TariffaTipoRepository extends JpaRepository<TariffaTipoEntity, UUID>, JpaSpecificationExecutor<TariffaTipoEntity> {

}