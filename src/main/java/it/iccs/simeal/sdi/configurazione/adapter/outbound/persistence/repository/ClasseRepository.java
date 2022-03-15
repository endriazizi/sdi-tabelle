package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ClasseEntity;

@Repository
public interface ClasseRepository extends JpaRepository<ClasseEntity, UUID>, JpaSpecificationExecutor<ClasseEntity> {

}
