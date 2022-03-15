package it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence;

import java.util.List;
import java.util.UUID;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;

import it.iccs.simeal.sdi.tabelle.application.model.AnnoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.AnnoCriteria;

public interface AnnoPersistence {
	
	AnnoModel save(AnnoModel model);
	
	List<AnnoModel> findByIds(List<UUID> ids);
	
	Page<AnnoModel> search(AnnoCriteria criteria, Pageable pageRequest);
	
	void delete(UUID id);

}
