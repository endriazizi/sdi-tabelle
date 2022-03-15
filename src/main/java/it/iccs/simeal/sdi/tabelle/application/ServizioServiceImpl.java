package it.iccs.simeal.sdi.tabelle.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.iccs.simeal.sdi.tabelle.application.mapper.ServizioModelMapper;
import it.iccs.simeal.sdi.tabelle.application.model.ServizioModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.ServizioService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ServizioUpdateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.ServizioPersistence;
import it.iccs.simeal.sdi.tabelle.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ServizioServiceImpl implements ServizioService {

	@Autowired
	private ServizioModelMapper servizioModelMapper;
	
	@Autowired
	private ServizioPersistence servizioPersistence;
	
	@Override
	public ServizioDTO create(ServizioCreateDTO dto) {
		ServizioDTO servizioDTO = servizioModelMapper.fromCreateDto(dto);
        ServizioModel servizioModel = servizioModelMapper.toModel(servizioDTO);
        ServizioModel model = servizioPersistence.save(servizioModel);
        return servizioModelMapper.toDto(model);
	}
	
	/*
	@Override
	public List<ServizioDTO> findByIds(List<UUID> ids) {
		List<ServizioModel> models = servizioPersistence.findByIds(ids);
		return servizioModelMapper.toDto(models);
	}
	*/

	@Override
	public Page<ServizioDTO> search(ServizioCriteria criteria, Pageable pageRequest) {
		Page<ServizioModel> models = servizioPersistence.search(criteria, pageRequest);
		return models.map(model -> this.servizioModelMapper.toDto(model));
	}

	@Override
	public List<ServizioDTO> findByIds(List<UUID> ids) {
		ServizioCriteria criteria = new ServizioCriteria().setId(ids);
		Page<ServizioModel> models = servizioPersistence.search(criteria, PageRequest.ofSize(10));
		return models.map(model -> this.servizioModelMapper.toDto(model)).getContent();
//		List<SezioneModel> models = sezionePersistence.findByIds(ids);
//		return sezioneModelMapper.toDto(models);
	}

	@Override
	public ServizioDTO update(ServizioUpdateDTO dto) {
		ServizioDTO servizioDTO = servizioModelMapper.fromUpdateDto(dto);
        this.checkServizioExists(servizioDTO.getId());		
        ServizioModel servizioModel = servizioModelMapper.toModel(servizioDTO);
        servizioPersistence.save(servizioModel);
        
        ServizioCriteria criteria = new ServizioCriteria().setId(Collections.singletonList(servizioDTO.getId()));
		Page<ServizioModel> models = servizioPersistence.search(criteria, PageRequest.ofSize(10));
        ServizioModel model = models
        		.getContent()
                .stream()
                .findAny()
                .orElse(null);
        return servizioModelMapper.toDto(model);
	}

	@Override
	public void delete(UUID id) {
		this.checkServizioExists(id);
		ServizioDTO servizioDTO = this.findByIds(Collections.singletonList(id))
				.stream()
				.findAny()
				.orElse(null);
		servizioDTO.setFlagElimina((short)1);
		
		ServizioModel servizioModel = servizioModelMapper.toModel(servizioDTO);
		servizioPersistence.save(servizioModel);
	}
	
	private void checkServizioExists(UUID id) {
		ServizioCriteria criteria = new ServizioCriteria().setId(Collections.singletonList(id));
		if (servizioPersistence.search(criteria, PageRequest.ofSize(10)).isEmpty()) {
			log.warn("Servizio {} not found", id);
			throw new NotFoundException(String.format("Servizio %s not found", id));
		}
	}

	/*
	@Override
	public void delete(UUID id) {
		this.checkServizioExists(id);
		servizioPersistence.delete(id);
	}
	*/


}
