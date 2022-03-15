package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository;

import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ChiusuraEntity;

@Repository
public interface ChiusuraRepository extends JpaRepository<ChiusuraEntity, UUID>, JpaSpecificationExecutor<ChiusuraEntity> {
	
	List<ChiusuraEntity> findBySezione_Id(UUID id);
	
}
