package it.iccs.simeal.sdi.tabelle.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.iccs.simeal.sdi.tabelle.application.mapper.PastoAlternativoModelMapper;
import it.iccs.simeal.sdi.tabelle.application.model.PastoAlternativoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.PastoAlternativoService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.PastoAlternativoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.PastoAlternativoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.PastoAlternativoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.PastoAlternativoUpdateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.PastoAlternativoPersistence;
import it.iccs.simeal.sdi.tabelle.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class PastoAlternativoServiceImpl implements PastoAlternativoService {

	@Autowired
	private PastoAlternativoModelMapper pastoAlternativoModelMapper;
	
	@Autowired
	private PastoAlternativoPersistence pastoAlternativoPersistence;
	
	@Override
	public PastoAlternativoDTO create(PastoAlternativoCreateDTO dto) {
		PastoAlternativoDTO pastoAlternativoDTO = pastoAlternativoModelMapper.fromCreateDto(dto);
        PastoAlternativoModel pastoAlternativoModel = pastoAlternativoModelMapper.toModel(pastoAlternativoDTO);
        PastoAlternativoModel model = pastoAlternativoPersistence.save(pastoAlternativoModel);
        return pastoAlternativoModelMapper.toDto(model);
	}

	@Override
	public List<PastoAlternativoDTO> findByIds(List<UUID> ids) {
		PastoAlternativoCriteria criteria = new PastoAlternativoCriteria().setId(ids);
		Page<PastoAlternativoModel> models = pastoAlternativoPersistence.search(criteria, PageRequest.ofSize(10));
		return models.map(model -> this.pastoAlternativoModelMapper.toDto(model)).getContent();
	}

	@Override
	public Page<PastoAlternativoDTO> search(PastoAlternativoCriteria criteria, Pageable pageRequest) {
		Page<PastoAlternativoModel> models = pastoAlternativoPersistence.search(criteria, pageRequest);
		return models.map(model -> this.pastoAlternativoModelMapper.toDto(model));
	}

	@Override
	public PastoAlternativoDTO update(PastoAlternativoUpdateDTO dto) {
		PastoAlternativoDTO pastoAlternativoDTO = pastoAlternativoModelMapper.fromUpdateDto(dto);
        this.checkPastoAlternativoExists(pastoAlternativoDTO.getId());		
        PastoAlternativoModel pastoAlternativoModel = pastoAlternativoModelMapper.toModel(pastoAlternativoDTO);
        pastoAlternativoPersistence.save(pastoAlternativoModel);
        
        PastoAlternativoCriteria criteria = new PastoAlternativoCriteria().setId(Collections.singletonList(pastoAlternativoDTO.getId()));
		Page<PastoAlternativoModel> models = pastoAlternativoPersistence.search(criteria, PageRequest.ofSize(10));
        PastoAlternativoModel model = models
        		.getContent()
                .stream()
                .findAny()
                .orElse(null);
        return pastoAlternativoModelMapper.toDto(model);
	}
	
	@Override
	public void delete(UUID id) {
		this.checkPastoAlternativoExists(id);
		PastoAlternativoDTO pastoAlternativoDTO = this.findByIds(Collections.singletonList(id))
				.stream()
				.findAny()
				.orElse(null);
		pastoAlternativoDTO.setFlagAbilitato((short)0);
		
		PastoAlternativoModel pastoAlternativoModel = pastoAlternativoModelMapper.toModel(pastoAlternativoDTO);
		pastoAlternativoPersistence.save(pastoAlternativoModel);
	}
	
	private void checkPastoAlternativoExists(UUID id) {
		PastoAlternativoCriteria criteria = new PastoAlternativoCriteria().setId(Collections.singletonList(id));
		if (pastoAlternativoPersistence.search(criteria, PageRequest.ofSize(10)).isEmpty()) {
			log.warn("PastoAlternativo {} not found", id);
			throw new NotFoundException(String.format("PastoAlternativo %s not found", id));
		}
	}

}
