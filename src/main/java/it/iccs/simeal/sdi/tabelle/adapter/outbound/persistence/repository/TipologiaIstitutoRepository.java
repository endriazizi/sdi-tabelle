package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.TipologiaIstitutoEntity;

@Repository
public interface TipologiaIstitutoRepository extends JpaRepository<TipologiaIstitutoEntity, UUID>, JpaSpecificationExecutor<TipologiaIstitutoEntity> {
	
}
