package it.iccs.simeal.sdi.tabelle.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.github.jhipster.service.filter.IntegerFilter;
import it.iccs.simeal.sdi.tabelle.application.mapper.ServizioAnnoModelMapper;
import it.iccs.simeal.sdi.tabelle.application.model.ServizioAnnoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.ServizioAnnoService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioAnnoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioAnnoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioAnnoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioAnnoUpdateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.ServizioAnnoPersistence;
import it.iccs.simeal.sdi.tabelle.web.rest.errors.BadRequestException;
import it.iccs.simeal.sdi.tabelle.web.rest.errors.ConstraintsViolateException;
import it.iccs.simeal.sdi.tabelle.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ServizioAnnoServiceImpl implements ServizioAnnoService {

	@Autowired
	private ServizioAnnoModelMapper servizioAnnoModelMapper;
	
	@Autowired
	private ServizioAnnoPersistence servizioAnnoPersistence;
	
	@Override
	public ServizioAnnoDTO create(ServizioAnnoCreateDTO dto) {
		ServizioAnnoDTO servizioAnnoDTO = servizioAnnoModelMapper.fromCreateDto(dto);
		
		this.checkValidate(servizioAnnoDTO);
		
		this.checkConstraint(servizioAnnoDTO);
		
		ServizioAnnoModel servizioAnnoModel = servizioAnnoModelMapper.toModel(servizioAnnoDTO);
        ServizioAnnoModel model = servizioAnnoPersistence.save(servizioAnnoModel);
        return servizioAnnoModelMapper.toDto(model);
	}

	@Override
	public List<ServizioAnnoDTO> findByIds(List<UUID> ids) {
		ServizioAnnoCriteria criteria = new ServizioAnnoCriteria().setId(ids);
		Page<ServizioAnnoModel> models = servizioAnnoPersistence.search(criteria, PageRequest.ofSize(10));
		return models.map(model -> servizioAnnoModelMapper.toDto(model)).getContent();
	}

	@Override
	public Page<ServizioAnnoDTO> search(ServizioAnnoCriteria criteria, Pageable pageRequest) {
		Page<ServizioAnnoModel> models = servizioAnnoPersistence.search(criteria, pageRequest);
		return models.map(model -> this.servizioAnnoModelMapper.toDto(model));
	}
	
	@Override
	public ServizioAnnoDTO update(ServizioAnnoUpdateDTO dto) {
		ServizioAnnoDTO servizioAnnoDTO = servizioAnnoModelMapper.fromUpdateDto(dto);
		this.checkValidate(servizioAnnoDTO);
        this.checkServizioAnnoExists(servizioAnnoDTO.getId());
        this.checkConstraint(servizioAnnoDTO);
        ServizioAnnoModel servizioAnnoModel = servizioAnnoModelMapper.toModel(servizioAnnoDTO);
        servizioAnnoPersistence.save(servizioAnnoModel);
        
        ServizioAnnoCriteria criteria = new ServizioAnnoCriteria().setId(Collections.singletonList(servizioAnnoDTO.getId()));
		Page<ServizioAnnoModel> models = servizioAnnoPersistence.search(criteria, PageRequest.ofSize(1));
		ServizioAnnoModel model = models
				.getContent()
				.stream()
                .findAny()
                .orElse(null);
        return servizioAnnoModelMapper.toDto(model);
	}
	
	@Override
	public void delete(UUID id) {
		this.checkServizioAnnoExists(id);
		
		servizioAnnoPersistence.delete(id);
	}
	
	private void checkServizioAnnoExists(UUID id) {
		ServizioAnnoCriteria criteria = new ServizioAnnoCriteria().setId(Collections.singletonList(id));
		if (servizioAnnoPersistence.search(criteria, PageRequest.ofSize(10)).isEmpty()) {
			log.warn("ServizioAnno {} not found", id);
			throw new NotFoundException(String.format("ServizioAnno %s not found", id));
		}
	}
	
	private void checkValidate(ServizioAnnoDTO servizioAnnoDTO) {
		
		Boolean error=false;
		String error_validate="";
		
		if((servizioAnnoDTO.getAnno()==null || servizioAnnoDTO.getAnno()==0))
		{
			if(error_validate!="")
				error_validate+=", ";
				
			error_validate+="Anno non rilevato";
			error=true;
		}
		
		if(servizioAnnoDTO.getServizio()==null)
		{
			if(error_validate!="")
				error_validate+=", ";
			
			error_validate+="Servizio non rilevato";
			error=true;
		}
			
		if((servizioAnnoDTO.getTipologiaRilevazione()==null || servizioAnnoDTO.getTipologiaRilevazione()==0))
		{
			if(error_validate!="")
				error_validate+=", ";
			
			error_validate+="TipologiaRilevazione non rilevata";
			error=true;
		}
		
		if(error)
		{					
			log.warn("ServizioAnno error: {}", error_validate);
			throw new BadRequestException(String.format("Errore creazione ServizioAnno error: %s", error_validate));
		}
		
	}
	
	private void checkConstraint(ServizioAnnoDTO servizioAnnoDTO) {
						
		ServizioAnnoCriteria criteria= new ServizioAnnoCriteria();
		IntegerFilter anno_filter=new IntegerFilter();
		
		anno_filter.setEquals(servizioAnnoDTO.getAnno());
				
		criteria.setAnno(Collections.singletonList(anno_filter));
		criteria.setServizio(Collections.singletonList(servizioAnnoDTO.getServizio().getId()));
		
		ServizioAnnoModel found = servizioAnnoPersistence.search(criteria, Pageable.unpaged()).stream().findAny().orElse(null);
		
		System.out.print("SERVIZIO: "+servizioAnnoDTO);
		
		if (found != null && !found.getId().equals(servizioAnnoDTO.getId())) {
			log.warn("Servizio anno per id anno {} e servizio id: {} già presente", servizioAnnoDTO.getAnno(), servizioAnnoDTO.getServizio().getId());
			throw new ConstraintsViolateException("Errore creazione ServizioAnno error: esiste già una configurazione per il servizio e l'anno selezionati. Modificare la configurazione esistente.");
		}

	}

}
