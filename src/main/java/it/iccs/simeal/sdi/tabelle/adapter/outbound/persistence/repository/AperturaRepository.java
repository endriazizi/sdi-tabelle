package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.AperturaEntity;

@Repository
public interface AperturaRepository extends JpaRepository<AperturaEntity, UUID>, JpaSpecificationExecutor<AperturaEntity> {
	
	List<AperturaEntity> findBySezione_Id(UUID id);
	
}
