package it.iccs.simeal.sdi.tabelle.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.iccs.simeal.sdi.tabelle.application.mapper.RefettorioModelMapper;
import it.iccs.simeal.sdi.tabelle.application.model.RefettorioModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.ClasseComposizioneAnnoService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.RefettorioService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseComposizioneAnnoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.ClasseComposizioneAnnoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RefettorioCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RefettorioCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RefettorioDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RefettorioUpdateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.RefettorioPersistence;
import it.iccs.simeal.sdi.tabelle.web.rest.errors.InternalServerErrorException;
import it.iccs.simeal.sdi.tabelle.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RefettorioServiceImpl implements RefettorioService {

	@Autowired
	private RefettorioModelMapper refettorioModelMapper;
	
	@Autowired
	private RefettorioPersistence refettorioPersistence;
	
	@Autowired
	private ClasseComposizioneAnnoService classeComposizioneAnnoService;
	
	@Override
	public RefettorioDTO create(RefettorioCreateDTO dto) {
		RefettorioDTO refettorioDTO = refettorioModelMapper.fromCreateDto(dto);
        RefettorioModel refettorioModel = refettorioModelMapper.toModel(refettorioDTO);
        RefettorioModel model = refettorioPersistence.save(refettorioModel);
        return refettorioModelMapper.toDto(model);
	}

	@Override
	public List<RefettorioDTO> findByIds(List<UUID> ids) {
		RefettorioCriteria criteria = new RefettorioCriteria().setId(ids);
		Page<RefettorioModel> models = refettorioPersistence.search(criteria, PageRequest.ofSize(10));
		return models.map(model -> refettorioModelMapper.toDto(model)).getContent();
	}

	@Override
	public Page<RefettorioDTO> search(RefettorioCriteria criteria, Pageable pageRequest) {
		Page<RefettorioModel> models = refettorioPersistence.search(criteria, pageRequest);
		return models.map(model -> this.refettorioModelMapper.toDto(model));
	}

	@Override
	public RefettorioDTO update(RefettorioUpdateDTO dto) {
		RefettorioDTO refettorioDTO = refettorioModelMapper.fromUpdateDto(dto);
        this.checkRefettorioExists(refettorioDTO.getId());		
        RefettorioModel refettorioModel = refettorioModelMapper.toModel(refettorioDTO);
        refettorioPersistence.save(refettorioModel);
        
        RefettorioCriteria criteria = new RefettorioCriteria().setId(Collections.singletonList(refettorioDTO.getId()));
		Page<RefettorioModel> models = refettorioPersistence.search(criteria, PageRequest.ofSize(1));
		RefettorioModel model = models
				.getContent()
				.stream()
                .findAny()
                .orElse(null);
        return refettorioModelMapper.toDto(model);
	}
	
	@Override
	public void delete(UUID id) {
		this.checkRefettorioExists(id);
		this.checkInUse(id);
		RefettorioDTO refettorioDTO = this.findByIds(Collections.singletonList(id))
				.stream()
				.findAny()
				.orElse(null);
		refettorioDTO.setFlagElimina((short)1);
	}
	
	private void checkRefettorioExists(UUID id) {
		RefettorioCriteria criteria = new RefettorioCriteria().setId(Collections.singletonList(id));
		if (refettorioPersistence.search(criteria, PageRequest.ofSize(10)).isEmpty()) {
			log.warn("Refettorio {} not found", id);
			throw new NotFoundException(String.format("Refettorio %s not found", id));
		}
	}
	
	private void checkInUse(UUID id) {
		ClasseComposizioneAnnoCriteria criteria = new ClasseComposizioneAnnoCriteria().setRefettorio(Collections.singletonList(id));
		List<ClasseComposizioneAnnoDTO> found = classeComposizioneAnnoService.search(criteria, PageRequest.ofSize(10)).getContent();
		if (!found.isEmpty()) {
            log.warn("Refettorio {} referenced in {} ClasseComposizioneAnno", id, found.size());
            throw new InternalServerErrorException(String.format("Refettorio %s referenced in %d ClasseComposizioneAnno", id, found.size()));
        }
	}


}
