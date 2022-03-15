package it.iccs.simeal.sdi.configurazione.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.iccs.simeal.sdi.configurazione.application.mapper.AperturaModelMapper;
import it.iccs.simeal.sdi.configurazione.application.model.AperturaModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.AperturaService;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AperturaCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AperturaCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AperturaDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AperturaUpdateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence.AperturaPersistence;
import it.iccs.simeal.sdi.configurazione.utils.DataValidation;
import it.iccs.simeal.sdi.configurazione.web.rest.errors.BadRequestException;
import it.iccs.simeal.sdi.configurazione.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AperturaServiceImpl implements AperturaService {

	@Autowired
	private AperturaModelMapper aperturaModelMapper;
	
	@Autowired
	private AperturaPersistence aperturaPersistence;
		
	@Override
	public AperturaDTO create(AperturaCreateDTO dto) {
		AperturaDTO aperturaDTO = aperturaModelMapper.fromCreateDto(dto);
		this.checkValidate(aperturaDTO);
        AperturaModel aperturaModel = aperturaModelMapper.toModel(aperturaDTO);
        AperturaModel model = aperturaPersistence.save(aperturaModel);
        return aperturaModelMapper.toDto(model);
	}

	@Override
	public List<AperturaDTO> findByIds(List<UUID> ids) {
		AperturaCriteria criteria = new AperturaCriteria().setId(ids);
		Page<AperturaModel> models = aperturaPersistence.search(criteria, PageRequest.ofSize(10));
		return models.map(model -> aperturaModelMapper.toDto(model)).getContent();
	}

	@Override
	public Page<AperturaDTO> search(AperturaCriteria criteria, Pageable pageRequest) {
		Page<AperturaModel> models = aperturaPersistence.search(criteria, pageRequest);
		return models.map(model -> this.aperturaModelMapper.toDto(model));
	}

	@Override
	public AperturaDTO update(AperturaUpdateDTO dto) {
		AperturaDTO aperturaDTO = aperturaModelMapper.fromUpdateDto(dto);
		this.checkValidate(aperturaDTO);
        this.checkAperturaExists(aperturaDTO.getId());		
        AperturaModel aperturaModel = aperturaModelMapper.toModel(aperturaDTO);
        aperturaPersistence.save(aperturaModel);
        
        AperturaCriteria criteria = new AperturaCriteria().setId(Collections.singletonList(aperturaDTO.getId()));
		Page<AperturaModel> models = aperturaPersistence.search(criteria, PageRequest.ofSize(1));
		AperturaModel model = models
				.getContent()
				.stream()
                .findAny()
                .orElse(null);
        return aperturaModelMapper.toDto(model);
	}
	
	@Override
	public AperturaDTO delete(UUID id) {
		this.checkAperturaExists(id);
		AperturaDTO aperturaDTO = this.findByIds(Collections.singletonList(id))
				.stream()
				.findAny()
				.orElse(null);
		aperturaDTO.setFlagElimina((short)1);
		
		AperturaModel aperturaModel = aperturaModelMapper.toModel(aperturaDTO);
        aperturaPersistence.save(aperturaModel);
        
        AperturaCriteria criteria = new AperturaCriteria().setId(Collections.singletonList(aperturaDTO.getId()));
		Page<AperturaModel> models = aperturaPersistence.search(criteria, PageRequest.ofSize(1));
		AperturaModel model = models
				.getContent()
				.stream()
                .findAny()
                .orElse(null);
        return aperturaModelMapper.toDto(model);
	}
	
	private void checkAperturaExists(UUID id) {
		AperturaCriteria criteria = new AperturaCriteria().setId(Collections.singletonList(id));
		if (aperturaPersistence.search(criteria, PageRequest.ofSize(10)).isEmpty()) {
			log.warn("Apertura {} not found", id);
			throw new NotFoundException(String.format("Apertura %s not found", id));
		}
	}
	
	private void checkValidate(AperturaDTO aperturaDTO) {
		
		Boolean error=false;
		String error_validate="";
		
		if((aperturaDTO.getAnno()==null || aperturaDTO.getAnno()==0))
		{
			if(error_validate!="")
				error_validate+=", ";
				
			error_validate+="Anno";
			error=true;
		}
		
		if((aperturaDTO.getDataInizio()==null))
		{
			if(error_validate!="")
				error_validate+=", ";
				
			error_validate+="Data inizio";
			error=true;
		}

		if((aperturaDTO.getDataFine()==null))
		{
			if(error_validate!="")
				error_validate+=", ";
				
			error_validate+="Data fine";
			error=true;
		}
		
		if(error)
		{					
			log.warn("Apertura error: {}", error_validate);
			throw new BadRequestException(String.format("Errore creazione Apertura error: %s", error_validate));
		}
		else
		{
			DataValidation dataValidation = new DataValidation();
			
			dataValidation.validatePeriod(aperturaDTO.getDataInizio(), aperturaDTO.getDataFine());
		}
		
	}
}
