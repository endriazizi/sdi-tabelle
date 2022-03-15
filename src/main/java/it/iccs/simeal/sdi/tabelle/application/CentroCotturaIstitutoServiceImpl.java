package it.iccs.simeal.sdi.tabelle.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.iccs.simeal.sdi.tabelle.application.mapper.CentroCotturaIstitutoModelMapper;
import it.iccs.simeal.sdi.tabelle.application.model.CentroCotturaIstitutoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.CentroCotturaIstitutoService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaIstitutoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaIstitutoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaIstitutoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.CentroCotturaIstitutoUpdateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.CentroCotturaIstitutoPersistence;
import it.iccs.simeal.sdi.tabelle.web.rest.errors.BadRequestException;
import it.iccs.simeal.sdi.tabelle.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class CentroCotturaIstitutoServiceImpl implements CentroCotturaIstitutoService {

	@Autowired
	private CentroCotturaIstitutoModelMapper centroCotturaIstitutoModelMapper;
	
	@Autowired
	private CentroCotturaIstitutoPersistence centroCotturaIstitutoPersistence;
	
	@Override
	public CentroCotturaIstitutoDTO create(CentroCotturaIstitutoCreateDTO dto) {
		CentroCotturaIstitutoDTO centroCotturaIstitutoDTO = centroCotturaIstitutoModelMapper.fromCreateDto(dto);
		this.checkValidate(centroCotturaIstitutoDTO);
        CentroCotturaIstitutoModel centroCotturaIstitutoModel = centroCotturaIstitutoModelMapper.toModel(centroCotturaIstitutoDTO);
        CentroCotturaIstitutoModel model = centroCotturaIstitutoPersistence.save(centroCotturaIstitutoModel);
        return centroCotturaIstitutoModelMapper.toDto(model);
	}

	@Override
	public List<CentroCotturaIstitutoDTO> findByIds(List<UUID> ids) {
		CentroCotturaIstitutoCriteria criteria = new CentroCotturaIstitutoCriteria().setId(ids);
		Page<CentroCotturaIstitutoModel> models = centroCotturaIstitutoPersistence.search(criteria, PageRequest.ofSize(10));
		return models.map(model -> centroCotturaIstitutoModelMapper.toDto(model)).getContent();
	}

	@Override
	public Page<CentroCotturaIstitutoDTO> search(CentroCotturaIstitutoCriteria criteria, Pageable pageRequest) {
		Page<CentroCotturaIstitutoModel> models = centroCotturaIstitutoPersistence.search(criteria, pageRequest);
		return models.map(model -> this.centroCotturaIstitutoModelMapper.toDto(model));
	}

	@Override
	public CentroCotturaIstitutoDTO update(CentroCotturaIstitutoUpdateDTO dto) {
		CentroCotturaIstitutoDTO centroCotturaIstitutoDTO = centroCotturaIstitutoModelMapper.fromUpdateDto(dto);
		this.checkValidate(centroCotturaIstitutoDTO);
        this.checkCentroCotturaIstitutoExists(centroCotturaIstitutoDTO.getId());		
        CentroCotturaIstitutoModel centroCotturaIstitutoModel = centroCotturaIstitutoModelMapper.toModel(centroCotturaIstitutoDTO);
        centroCotturaIstitutoPersistence.save(centroCotturaIstitutoModel);
        
        CentroCotturaIstitutoCriteria criteria = new CentroCotturaIstitutoCriteria().setId(Collections.singletonList(centroCotturaIstitutoDTO.getId()));
		Page<CentroCotturaIstitutoModel> models = centroCotturaIstitutoPersistence.search(criteria, PageRequest.ofSize(1));
		CentroCotturaIstitutoModel model = models
				.getContent()
				.stream()
                .findAny()
                .orElse(null);
        return centroCotturaIstitutoModelMapper.toDto(model);
	}
	
	
	@Override
	public void delete(UUID id) {
		this.checkCentroCotturaIstitutoExists(id);
		
		centroCotturaIstitutoPersistence.delete(id);
	}
	
	private void checkCentroCotturaIstitutoExists(UUID id) {
		CentroCotturaIstitutoCriteria criteria = new CentroCotturaIstitutoCriteria().setId(Collections.singletonList(id));
		if (centroCotturaIstitutoPersistence.search(criteria, PageRequest.ofSize(10)).isEmpty()) {
			log.warn("CentroCotturaIstituto {} not found", id);
			throw new NotFoundException(String.format("CentroCotturaIstituto %s not found", id));
		}
	}
	
	private void checkValidate(CentroCotturaIstitutoDTO centroCotturaIstitutoDTO) {
		
		Boolean error=false;
		String error_validate="";
		
		if(centroCotturaIstitutoDTO.getCentroCottura()==null)
		{
			if(error_validate!="")
				error_validate+=", ";
				
			error_validate+="Centro Cottura";
			error=true;
		}
		
		if(centroCotturaIstitutoDTO.getIstituto()==null)
		{
			if(error_validate!="")
				error_validate+=", ";
				
			error_validate+="Istituto";
			error=true;
		}

		if(error)
		{					
			log.warn("CentroCotturaIstituto error: {}", error_validate);
			throw new BadRequestException(String.format("Errore creazione CentroCotturaIstituto error: %s", error_validate));
		}
		
	}

}
