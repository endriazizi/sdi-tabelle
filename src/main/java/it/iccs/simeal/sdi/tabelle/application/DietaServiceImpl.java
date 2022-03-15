package it.iccs.simeal.sdi.tabelle.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.iccs.simeal.sdi.tabelle.application.mapper.DietaModelMapper;
import it.iccs.simeal.sdi.tabelle.application.model.DietaModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.DietaService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.DietaCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.DietaCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.DietaDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.DietaUpdateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.DietaPersistence;
import it.iccs.simeal.sdi.tabelle.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class DietaServiceImpl implements DietaService {

	@Autowired
	private DietaModelMapper dietaModelMapper;
	
	@Autowired
	private DietaPersistence dietaPersistence;
	
	@Override
	public DietaDTO create(DietaCreateDTO dto) {
		DietaDTO dietaDTO = dietaModelMapper.fromCreateDto(dto);
        DietaModel dietaModel = dietaModelMapper.toModel(dietaDTO);
        DietaModel model = dietaPersistence.save(dietaModel);
        return dietaModelMapper.toDto(model);
	}

	@Override
	public List<DietaDTO> findByIds(List<UUID> ids) {
		DietaCriteria criteria = new DietaCriteria().setId(ids);
		Page<DietaModel> models = dietaPersistence.search(criteria, PageRequest.ofSize(10));
		return models.map(model -> this.dietaModelMapper.toDto(model)).getContent();
	}

	@Override
	public Page<DietaDTO> search(DietaCriteria criteria, Pageable pageRequest) {
		Page<DietaModel> models = dietaPersistence.search(criteria, pageRequest);
		return models.map(model -> this.dietaModelMapper.toDto(model));
	}

	@Override
	public DietaDTO update(DietaUpdateDTO dto) {
		DietaDTO dietaDTO = dietaModelMapper.fromUpdateDto(dto);
        this.checkDietaExists(dietaDTO.getId());		
        DietaModel dietaModel = dietaModelMapper.toModel(dietaDTO);
        dietaPersistence.save(dietaModel);
        
        DietaCriteria criteria = new DietaCriteria().setId(Collections.singletonList(dietaDTO.getId()));
		Page<DietaModel> models = dietaPersistence.search(criteria, PageRequest.ofSize(10));
        DietaModel model = models
        		.getContent()
                .stream()
                .findAny()
                .orElse(null);
        return dietaModelMapper.toDto(model);
	}
	
	@Override
	public void delete(UUID id) {
		this.checkDietaExists(id);
		DietaDTO dietaDTO = this.findByIds(Collections.singletonList(id))
				.stream()
				.findAny()
				.orElse(null);
		dietaDTO.setFlagElimina((short)1);
		
		DietaModel dietaModel = dietaModelMapper.toModel(dietaDTO);
		dietaPersistence.save(dietaModel);
	}
	
	private void checkDietaExists(UUID id) {
		DietaCriteria criteria = new DietaCriteria().setId(Collections.singletonList(id));
		if (dietaPersistence.search(criteria, PageRequest.ofSize(10)).isEmpty()) {
			log.warn("Dieta {} not found", id);
			throw new NotFoundException(String.format("Dieta %s not found", id));
		}
	}

}
