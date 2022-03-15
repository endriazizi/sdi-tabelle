package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.CentroCotturaEntity;

@Repository
public interface CentroCotturaRepository extends JpaRepository<CentroCotturaEntity, UUID>, JpaSpecificationExecutor<CentroCotturaEntity> {

}
