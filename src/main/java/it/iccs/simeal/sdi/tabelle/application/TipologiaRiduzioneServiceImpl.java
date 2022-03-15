package it.iccs.simeal.sdi.tabelle.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.iccs.simeal.sdi.tabelle.application.mapper.TipologiaRiduzioneModelMapper;
import it.iccs.simeal.sdi.tabelle.application.model.TipologiaRiduzioneModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.TipologiaRiduzioneService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaRiduzioneCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaRiduzioneCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaRiduzioneDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TipologiaRiduzioneUpdateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.TipologiaRiduzionePersistence;
import it.iccs.simeal.sdi.tabelle.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TipologiaRiduzioneServiceImpl implements TipologiaRiduzioneService {

	@Autowired
	private TipologiaRiduzioneModelMapper tipologiaRiduzioneModelMapper;
	
	@Autowired
	private TipologiaRiduzionePersistence tipologiaRiduzionePersistence;
	
	@Override
	public TipologiaRiduzioneDTO create(TipologiaRiduzioneCreateDTO dto) {
		TipologiaRiduzioneDTO tipologiaRiduzioneDTO = tipologiaRiduzioneModelMapper.fromCreateDto(dto);
        TipologiaRiduzioneModel tipologiaRiduzioneModel = tipologiaRiduzioneModelMapper.toModel(tipologiaRiduzioneDTO);
        TipologiaRiduzioneModel model = tipologiaRiduzionePersistence.save(tipologiaRiduzioneModel);
        return tipologiaRiduzioneModelMapper.toDto(model);
	}

	@Override
	public List<TipologiaRiduzioneDTO> findByIds(List<UUID> ids) {
		TipologiaRiduzioneCriteria criteria = new TipologiaRiduzioneCriteria().setId(ids);
		Page<TipologiaRiduzioneModel> models = tipologiaRiduzionePersistence.search(criteria, PageRequest.ofSize(10));
		return models.map(model -> this.tipologiaRiduzioneModelMapper.toDto(model)).getContent();
	}

	@Override
	public Page<TipologiaRiduzioneDTO> search(TipologiaRiduzioneCriteria criteria, Pageable pageRequest) {
		Page<TipologiaRiduzioneModel> models = tipologiaRiduzionePersistence.search(criteria, pageRequest);
		return models.map(model -> this.tipologiaRiduzioneModelMapper.toDto(model));
	}

	@Override
	public TipologiaRiduzioneDTO update(TipologiaRiduzioneUpdateDTO dto) {
		TipologiaRiduzioneDTO tipologiaRiduzioneDTO = tipologiaRiduzioneModelMapper.fromUpdateDto(dto);
        this.checkTipologiaRiduzioneExists(tipologiaRiduzioneDTO.getId());		
        TipologiaRiduzioneModel tipologiaRiduzioneModel = tipologiaRiduzioneModelMapper.toModel(tipologiaRiduzioneDTO);
        tipologiaRiduzionePersistence.save(tipologiaRiduzioneModel);
        
        TipologiaRiduzioneCriteria criteria = new TipologiaRiduzioneCriteria().setId(Collections.singletonList(tipologiaRiduzioneDTO.getId()));
		Page<TipologiaRiduzioneModel> models = tipologiaRiduzionePersistence.search(criteria, PageRequest.ofSize(10));
        TipologiaRiduzioneModel model = models
        		.getContent()
                .stream()
                .findAny()
                .orElse(null);
        return tipologiaRiduzioneModelMapper.toDto(model);
	}
	
	@Override
	public void delete(UUID id) {
		this.checkTipologiaRiduzioneExists(id);
		TipologiaRiduzioneDTO tipologiaRiduzioneDTO = this.findByIds(Collections.singletonList(id))
				.stream()
				.findAny()
				.orElse(null);
		tipologiaRiduzioneDTO.setFlagElimina((short)1);
		
		TipologiaRiduzioneModel tipologiaRiduzioneModel = tipologiaRiduzioneModelMapper.toModel(tipologiaRiduzioneDTO);
		tipologiaRiduzionePersistence.save(tipologiaRiduzioneModel);
	}
	
	private void checkTipologiaRiduzioneExists(UUID id) {
		TipologiaRiduzioneCriteria criteria = new TipologiaRiduzioneCriteria().setId(Collections.singletonList(id));
		if (tipologiaRiduzionePersistence.search(criteria, PageRequest.ofSize(10)).isEmpty()) {
			log.warn("TipologiaRiduzione {} not found", id);
			throw new NotFoundException(String.format("TipologiaRiduzione %s not found", id));
		}
	}

}
