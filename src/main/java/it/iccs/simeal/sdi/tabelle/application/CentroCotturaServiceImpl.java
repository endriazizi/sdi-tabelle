package it.iccs.simeal.sdi.tabelle.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.iccs.simeal.sdi.tabelle.application.mapper.CentroCotturaModelMapper;
import it.iccs.simeal.sdi.tabelle.application.model.CentroCotturaModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.CentroCotturaService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaUpdateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.CentroCotturaPersistence;
import it.iccs.simeal.sdi.tabelle.web.rest.errors.BadRequestException;
import it.iccs.simeal.sdi.tabelle.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CentroCotturaServiceImpl implements CentroCotturaService {

	@Autowired
	private CentroCotturaModelMapper centroCotturaModelMapper;
	
	@Autowired
	private CentroCotturaPersistence centroCotturaPersistence;
	
	
	@Override
	public CentroCotturaDTO create(CentroCotturaCreateDTO dto) {
		CentroCotturaDTO centroCotturaDTO = centroCotturaModelMapper.fromCreateDto(dto);
		this.checkValidate(centroCotturaDTO);
        CentroCotturaModel centroCotturaModel = centroCotturaModelMapper.toModel(centroCotturaDTO);
        CentroCotturaModel model = centroCotturaPersistence.save(centroCotturaModel);
        return centroCotturaModelMapper.toDto(model);
	}

	@Override
	public List<CentroCotturaDTO> findByIds(List<UUID> ids) {
		CentroCotturaCriteria criteria = new CentroCotturaCriteria().setId(ids);
		Page<CentroCotturaModel> models = centroCotturaPersistence.search(criteria, PageRequest.ofSize(10));
		return models.map(model -> centroCotturaModelMapper.toDto(model)).getContent();
	}

	@Override
	public Page<CentroCotturaDTO> search(CentroCotturaCriteria criteria, Pageable pageRequest) {
		Page<CentroCotturaModel> models = centroCotturaPersistence.search(criteria, pageRequest);
		return models.map(model -> this.centroCotturaModelMapper.toDto(model));
	}

	@Override
	public CentroCotturaDTO update(CentroCotturaUpdateDTO dto) {
		CentroCotturaDTO centroCotturaDTO = centroCotturaModelMapper.fromUpdateDto(dto);
		this.checkValidate(centroCotturaDTO);
        this.checkCentroCotturaExists(centroCotturaDTO.getId());		
        CentroCotturaModel centroCotturaModel = centroCotturaModelMapper.toModel(centroCotturaDTO);
        centroCotturaPersistence.save(centroCotturaModel);
        
        CentroCotturaCriteria criteria = new CentroCotturaCriteria().setId(Collections.singletonList(centroCotturaDTO.getId()));
		Page<CentroCotturaModel> models = centroCotturaPersistence.search(criteria, PageRequest.ofSize(1));
		CentroCotturaModel model = models
				.getContent()
				.stream()
                .findAny()
                .orElse(null);
        return centroCotturaModelMapper.toDto(model);
	}
	
	@Override
	public void delete(UUID id) {
		this.checkCentroCotturaExists(id);
		CentroCotturaDTO centroCotturaDTO = this.findByIds(Collections.singletonList(id))
				.stream()
				.findAny()
				.orElse(null);
		centroCotturaDTO.setFlagElimina((short)1);
		
		CentroCotturaModel centroCotturaModel = centroCotturaModelMapper.toModel(centroCotturaDTO);
		centroCotturaPersistence.save(centroCotturaModel);
	}
	
	private void checkCentroCotturaExists(UUID id) {
		CentroCotturaCriteria criteria = new CentroCotturaCriteria().setId(Collections.singletonList(id));
		if (centroCotturaPersistence.search(criteria, PageRequest.ofSize(10)).isEmpty()) {
			log.warn("CentroCottura {} not found", id);
			throw new NotFoundException(String.format("CentroCottura %s not found", id));
		}
	}
	
	private void checkValidate(CentroCotturaDTO centroCotturaDTO) {
		
		Boolean error=false;
		String error_validate="";
		
		if((centroCotturaDTO.getDenominazione()==null || centroCotturaDTO.getDenominazione()==""))
		{
			if(error_validate!="")
				error_validate+=", ";
				
			error_validate+="Denominazione non rilevata";
			error=true;
		}

		
		if(error)
		{					
			log.warn("CentroCottura error: {}", error_validate);
			throw new BadRequestException(String.format("Errore creazione CentroCottura error: %s", error_validate));
		}
		
	}

}
