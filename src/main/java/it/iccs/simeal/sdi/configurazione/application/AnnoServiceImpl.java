package it.iccs.simeal.sdi.configurazione.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import io.github.jhipster.service.filter.IntegerFilter;
import it.iccs.simeal.sdi.configurazione.application.mapper.AnnoModelMapper;
import it.iccs.simeal.sdi.configurazione.application.model.AnnoModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.AnnoService;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AnnoCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AnnoCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AnnoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AnnoUpdateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence.AnnoPersistence;
import it.iccs.simeal.sdi.configurazione.web.rest.errors.BadRequestException;
import it.iccs.simeal.sdi.configurazione.web.rest.errors.ConstraintsViolateException;
import it.iccs.simeal.sdi.configurazione.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class AnnoServiceImpl implements AnnoService {

	@Autowired
	private AnnoModelMapper annoModelMapper;
	
	@Autowired
	private AnnoPersistence annoPersistence;
	
	@Override
	public AnnoDTO create(AnnoCreateDTO dto) {
		AnnoDTO annoDTO = annoModelMapper.fromCreateDto(dto);
		this.checkValidate(annoDTO);
		this.checkConstraint(annoDTO);
        AnnoModel annoModel = annoModelMapper.toModel(annoDTO);
        AnnoModel model = annoPersistence.save(annoModel);
        return annoModelMapper.toDto(model);
	}

	@Override
	public List<AnnoDTO> findByIds(List<UUID> ids) {
		List<AnnoModel> models = annoPersistence.findByIds(ids);
		return annoModelMapper.toDto(models);
	}

	@Override
	public Page<AnnoDTO> search(AnnoCriteria criteria, Pageable pageRequest) {
		Page<AnnoModel> models = annoPersistence.search(criteria, pageRequest);
		return models.map(model -> this.annoModelMapper.toDto(model));
	}

	@Override
	public AnnoDTO update(AnnoUpdateDTO dto) {
		AnnoDTO annoDTO = annoModelMapper.fromUpdateDto(dto);
		this.checkValidate(annoDTO);
		this.checkAnnoExists(annoDTO.getId());		
		this.checkConstraint(annoDTO);
        AnnoModel annoModel = annoModelMapper.toModel(annoDTO);
        annoPersistence.save(annoModel);
        AnnoModel model = annoPersistence.findByIds(Collections.singletonList(annoDTO.getId()))
                .stream()
                .findAny()
                .orElse(null);
        return annoModelMapper.toDto(model);
	}
	
	@Override
	public void delete(UUID id) {
		this.checkAnnoExists(id);
		annoPersistence.delete(id);
	}
	
	private void checkAnnoExists(UUID id) {
		if (annoPersistence.findByIds(Collections.singletonList(id)).isEmpty()) {
			log.warn("Anno {} not found", id);
			throw new NotFoundException(String.format("Anno %s not found", id));
		}
	}
	
	private void checkValidate(AnnoDTO annoDTO) {
		
		Boolean error=false;
		String error_validate="";
		
		if((annoDTO.getAnno()==null || annoDTO.getAnno()==0))
		{
			if(error_validate!="")
				error_validate+=", ";
				
			error_validate+="Anno";
			error=true;
		}

		if((annoDTO.getDescrizione()==null || annoDTO.getDescrizione()==""))
		{
			if(error_validate!="")
				error_validate+=", ";
				
			error_validate+="Descrizione";
			error=true;
		}
		
		if(error)
		{					
			log.warn("CentroCottura error: {}", error_validate);
			throw new BadRequestException(String.format("Errore creazione Anno error: %s", error_validate));
		}
		
	}
	
	private void checkConstraint(AnnoDTO annoDTO) {
		
		AnnoCriteria criteria= new AnnoCriteria();
		IntegerFilter anno_filter=new IntegerFilter();

		anno_filter.setEquals(annoDTO.getAnno());
		criteria.setAnno(Collections.singletonList(anno_filter));
		
		AnnoModel found = annoPersistence.search(criteria, Pageable.unpaged()).stream().findAny().orElse(null);
				
		if (found != null && !found.getId().equals(annoDTO.getId())) {
			log.warn("Configurazione per anno {} già presente", annoDTO.getAnno());
			throw new ConstraintsViolateException("Errore creazione Anno error: esiste già una configurazione per l'anno selezionato. Modificare la configurazione esistente.");
		}

	}

}
