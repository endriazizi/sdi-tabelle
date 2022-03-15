package it.iccs.simeal.sdi.tabelle.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.iccs.simeal.sdi.tabelle.application.mapper.ChiusuraModelMapper;
import it.iccs.simeal.sdi.tabelle.application.model.ChiusuraModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.ChiusuraService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ChiusuraCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ChiusuraCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ChiusuraDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ChiusuraUpdateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.ChiusuraPersistence;
import it.iccs.simeal.sdi.tabelle.utils.DataValidation;
import it.iccs.simeal.sdi.tabelle.web.rest.errors.BadRequestException;
import it.iccs.simeal.sdi.tabelle.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ChiusuraServiceImpl implements ChiusuraService {

	@Autowired
	private ChiusuraModelMapper chiusuraModelMapper;
	
	@Autowired
	private ChiusuraPersistence chiusuraPersistence;
		
	@Override
	public ChiusuraDTO create(ChiusuraCreateDTO dto) {
		ChiusuraDTO chiusuraDTO = chiusuraModelMapper.fromCreateDto(dto);
		this.checkValidate(chiusuraDTO);
        ChiusuraModel chiusuraModel = chiusuraModelMapper.toModel(chiusuraDTO);
        ChiusuraModel model = chiusuraPersistence.save(chiusuraModel);
        return chiusuraModelMapper.toDto(model);
	}

	@Override
	public List<ChiusuraDTO> findByIds(List<UUID> ids) {
		ChiusuraCriteria criteria = new ChiusuraCriteria().setId(ids);
		Page<ChiusuraModel> models = chiusuraPersistence.search(criteria, PageRequest.ofSize(10));
		return models.map(model -> chiusuraModelMapper.toDto(model)).getContent();
	}

	@Override
	public Page<ChiusuraDTO> search(ChiusuraCriteria criteria, Pageable pageRequest) {
		Page<ChiusuraModel> models = chiusuraPersistence.search(criteria, pageRequest);
		return models.map(model -> this.chiusuraModelMapper.toDto(model));
	}

	@Override
	public ChiusuraDTO update(ChiusuraUpdateDTO dto) {
		ChiusuraDTO chiusuraDTO = chiusuraModelMapper.fromUpdateDto(dto);
		this.checkValidate(chiusuraDTO);
        this.checkChiusuraExists(chiusuraDTO.getId());		
        ChiusuraModel chiusuraModel = chiusuraModelMapper.toModel(chiusuraDTO);
        chiusuraPersistence.save(chiusuraModel);
        
        ChiusuraCriteria criteria = new ChiusuraCriteria().setId(Collections.singletonList(chiusuraDTO.getId()));
		Page<ChiusuraModel> models = chiusuraPersistence.search(criteria, PageRequest.ofSize(1));
		ChiusuraModel model = models
				.getContent()
				.stream()
                .findAny()
                .orElse(null);
        return chiusuraModelMapper.toDto(model);
	}
	
	@Override
	public ChiusuraDTO delete(UUID id) {
		this.checkChiusuraExists(id);
		ChiusuraDTO chiusuraDTO = this.findByIds(Collections.singletonList(id))
				.stream()
				.findAny()
				.orElse(null);
		chiusuraDTO.setFlagElimina((short)1);
		
		ChiusuraModel chiusuraModel = chiusuraModelMapper.toModel(chiusuraDTO);
        chiusuraPersistence.save(chiusuraModel);
        
        ChiusuraCriteria criteria = new ChiusuraCriteria().setId(Collections.singletonList(chiusuraDTO.getId()));
		Page<ChiusuraModel> models = chiusuraPersistence.search(criteria, PageRequest.ofSize(1));
		ChiusuraModel model = models
				.getContent()
				.stream()
                .findAny()
                .orElse(null);
        return chiusuraModelMapper.toDto(model);
	}
	
	private void checkChiusuraExists(UUID id) {
		ChiusuraCriteria criteria = new ChiusuraCriteria().setId(Collections.singletonList(id));
		if (chiusuraPersistence.search(criteria, PageRequest.ofSize(10)).isEmpty()) {
			log.warn("Chiusura {} not found", id);
			throw new NotFoundException(String.format("Chiusura %s not found", id));
		}
	}
	
	private void checkValidate(ChiusuraDTO chiusuraDTO) {
		
		Boolean error=false;
		String error_validate="";
		
		if((chiusuraDTO.getAnno()==null || chiusuraDTO.getAnno()==0))
		{
			if(error_validate!="")
				error_validate+=", ";
				
			error_validate+="Anno";
			error=true;
		}
		
		if((chiusuraDTO.getDataInizio()==null))
		{
			if(error_validate!="")
				error_validate+=", ";
				
			error_validate+="Data inizio";
			error=true;
		}

		if((chiusuraDTO.getDataFine()==null))
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
			
			dataValidation.validatePeriod(chiusuraDTO.getDataInizio(), chiusuraDTO.getDataFine());
		}
		
	}
}
