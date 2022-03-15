package it.iccs.simeal.sdi.tabelle.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.iccs.simeal.sdi.tabelle.application.mapper.TipologiaIstitutoModelMapper;
import it.iccs.simeal.sdi.tabelle.application.model.TipologiaIstitutoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.TipologiaIstitutoService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaIstitutoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaIstitutoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaIstitutoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaIstitutoUpdateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.TipologiaIstitutoPersistence;
import it.iccs.simeal.sdi.tabelle.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TipologiaIstitutoServiceImpl implements TipologiaIstitutoService {

	@Autowired
	private TipologiaIstitutoModelMapper tipologiaIstitutoModelMapper;
	
	@Autowired
	private TipologiaIstitutoPersistence tipologiaIstitutoPersistence;
	
	@Override
	public TipologiaIstitutoDTO create(TipologiaIstitutoCreateDTO dto) {
		TipologiaIstitutoDTO tipologiaIstitutoDTO = tipologiaIstitutoModelMapper.fromCreateDto(dto);
        TipologiaIstitutoModel tipologiaIstitutoModel = tipologiaIstitutoModelMapper.toModel(tipologiaIstitutoDTO);
        TipologiaIstitutoModel model = tipologiaIstitutoPersistence.save(tipologiaIstitutoModel);
        return tipologiaIstitutoModelMapper.toDto(model);
	}

	@Override
	public List<TipologiaIstitutoDTO> findByIds(List<UUID> ids) {
		TipologiaIstitutoCriteria criteria = new TipologiaIstitutoCriteria().setId(ids);
		Page<TipologiaIstitutoModel> models = tipologiaIstitutoPersistence.search(criteria, PageRequest.ofSize(10));
		return models.map(model -> this.tipologiaIstitutoModelMapper.toDto(model)).getContent();
	}

	@Override
	public Page<TipologiaIstitutoDTO> search(TipologiaIstitutoCriteria criteria, Pageable pageRequest) {
		Page<TipologiaIstitutoModel> models = tipologiaIstitutoPersistence.search(criteria, pageRequest);
		return models.map(model -> this.tipologiaIstitutoModelMapper.toDto(model));
	}

	@Override
	public TipologiaIstitutoDTO update(TipologiaIstitutoUpdateDTO dto) {
		TipologiaIstitutoDTO tipologiaIstitutoDTO = tipologiaIstitutoModelMapper.fromUpdateDto(dto);
        this.checkTipologiaIstitutoExists(tipologiaIstitutoDTO.getId());		
        TipologiaIstitutoModel tipologiaIstitutoModel = tipologiaIstitutoModelMapper.toModel(tipologiaIstitutoDTO);
        tipologiaIstitutoPersistence.save(tipologiaIstitutoModel);
        
        TipologiaIstitutoCriteria criteria = new TipologiaIstitutoCriteria().setId(Collections.singletonList(tipologiaIstitutoDTO.getId()));
		Page<TipologiaIstitutoModel> models = tipologiaIstitutoPersistence.search(criteria, PageRequest.ofSize(10));
        TipologiaIstitutoModel model = models
        		.getContent()
                .stream()
                .findAny()
                .orElse(null);
        return tipologiaIstitutoModelMapper.toDto(model);
	}
	
	@Override
	public void delete(UUID id) {
		this.checkTipologiaIstitutoExists(id);
		TipologiaIstitutoDTO tipologiaIstitutoDTO = this.findByIds(Collections.singletonList(id))
				.stream()
				.findAny()
				.orElse(null);
		tipologiaIstitutoDTO.setFlagElimina((short)1);
		
		TipologiaIstitutoModel tipologiaIstitutoModel = tipologiaIstitutoModelMapper.toModel(tipologiaIstitutoDTO);
		tipologiaIstitutoPersistence.save(tipologiaIstitutoModel);
	}
	
	private void checkTipologiaIstitutoExists(UUID id) {
		TipologiaIstitutoCriteria criteria = new TipologiaIstitutoCriteria().setId(Collections.singletonList(id));
		if (tipologiaIstitutoPersistence.search(criteria, PageRequest.ofSize(10)).isEmpty()) {
			log.warn("TipologiaIstituto {} not found", id);
			throw new NotFoundException(String.format("TipologiaIstituto %s not found", id));
		}
	}

}
