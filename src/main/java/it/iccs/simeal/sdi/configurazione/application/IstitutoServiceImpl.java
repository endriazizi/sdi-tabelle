package it.iccs.simeal.sdi.configurazione.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.iccs.simeal.sdi.configurazione.application.mapper.IstitutoModelMapper;
import it.iccs.simeal.sdi.configurazione.application.model.IstitutoModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.ClasseComposizioneService;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.IstitutoService;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.IstitutoCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.IstitutoCriteria;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.IstitutoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.IstitutoUpdateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.outbound.persistence.IstitutoPersistence;
import it.iccs.simeal.sdi.configurazione.web.rest.errors.InternalServerErrorException;
import it.iccs.simeal.sdi.configurazione.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class IstitutoServiceImpl implements IstitutoService {

	@Autowired
	private IstitutoModelMapper istitutoModelMapper;
	
	@Autowired
	private IstitutoPersistence istitutoPersistence;
	
	@Autowired
	private ClasseComposizioneService classeComposizioneService;
	
	@Override
	public IstitutoDTO create(IstitutoCreateDTO dto) {
		IstitutoDTO istitutoDTO = istitutoModelMapper.fromCreateDto(dto);
        IstitutoModel istitutoModel = istitutoModelMapper.toModel(istitutoDTO);
        IstitutoModel model = istitutoPersistence.save(istitutoModel);
        return istitutoModelMapper.toDto(model);
	}

	@Override
	public List<IstitutoDTO> findByIds(List<UUID> ids) {
		IstitutoCriteria criteria = new IstitutoCriteria().setId(ids);
		Page<IstitutoModel> models = istitutoPersistence.search(criteria, PageRequest.ofSize(10));
		return models.map(model -> istitutoModelMapper.toDto(model)).getContent();
	}

	@Override
	public Page<IstitutoDTO> search(IstitutoCriteria criteria, Pageable pageRequest) {
		Page<IstitutoModel> models = istitutoPersistence.search(criteria, pageRequest);
		return models.map(model -> this.istitutoModelMapper.toDto(model));
	}

	@Override
	public IstitutoDTO update(IstitutoUpdateDTO dto) {
		IstitutoDTO istitutoDTO = istitutoModelMapper.fromUpdateDto(dto);
        this.checkIstitutoExists(istitutoDTO.getId());		
        IstitutoModel istitutoModel = istitutoModelMapper.toModel(istitutoDTO);
        istitutoPersistence.save(istitutoModel);
        
        IstitutoCriteria criteria = new IstitutoCriteria().setId(Collections.singletonList(istitutoDTO.getId()));
		Page<IstitutoModel> models = istitutoPersistence.search(criteria, PageRequest.ofSize(1));
		IstitutoModel model = models
				.getContent()
				.stream()
                .findAny()
                .orElse(null);
        return istitutoModelMapper.toDto(model);
	}
	
	@Override
	public void delete(UUID id) {
		this.checkIstitutoExists(id);
		this.checkInUse(id);
		IstitutoDTO istitutoDTO = this.findByIds(Collections.singletonList(id))
				.stream()
				.findAny()
				.orElse(null);
		istitutoDTO.setFlagElimina((short)1);
		
		IstitutoModel istitutoModel = istitutoModelMapper.toModel(istitutoDTO);
        istitutoPersistence.save(istitutoModel);
	}
	
	private void checkIstitutoExists(UUID id) {
		IstitutoCriteria criteria = new IstitutoCriteria().setId(Collections.singletonList(id));
		if (istitutoPersistence.search(criteria, PageRequest.ofSize(10)).isEmpty()) {
			log.warn("Istituto {} not found", id);
			throw new NotFoundException(String.format("Istituto %s not found", id));
		}
	}
	
	private void checkInUse(UUID id) {
		ClasseComposizioneCriteria criteria1 = new ClasseComposizioneCriteria().setIstituto(Collections.singletonList(id));
		ClasseComposizioneCriteria criteria2 = new ClasseComposizioneCriteria().setIstitutoSuccessiva(Collections.singletonList(id));
		List<ClasseComposizioneDTO> found1 = classeComposizioneService.search(criteria1, PageRequest.ofSize(10)).getContent();
		List<ClasseComposizioneDTO> found2 = classeComposizioneService.search(criteria2, PageRequest.ofSize(10)).getContent();
		if (!found1.isEmpty() || found2.isEmpty()) {
            log.warn("Istituto {} referenced {} times in ClasseComposizione", id, found1.size()+found2.size());
            throw new InternalServerErrorException(String.format("Istituto %s referenced %d times in ClasseComposizione", id, found1.size()+found2.size()));
        }
	}

}
