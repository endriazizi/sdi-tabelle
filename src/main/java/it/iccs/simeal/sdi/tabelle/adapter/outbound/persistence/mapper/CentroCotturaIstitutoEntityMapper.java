package it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.mapper;

import org.mapstruct.Mapper;
import org.springframework.stereotype.Component;

import it.iccs.simeal.sdi.tabelle.adapter.outbound.persistence.repository.entity.CentroCotturaIstitutoEntity;
import it.iccs.simeal.sdi.tabelle.application.model.CentroCotturaIstitutoModel;

@Component
@Mapper
public interface CentroCotturaIstitutoEntityMapper
		extends EntityMapper<CentroCotturaIstitutoEntity, CentroCotturaIstitutoModel> {

	CentroCotturaIstitutoEntity fromModelToEntity(CentroCotturaIstitutoModel model);

}
