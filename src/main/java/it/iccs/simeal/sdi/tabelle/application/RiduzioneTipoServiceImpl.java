package it.iccs.simeal.sdi.tabelle.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import it.iccs.simeal.sdi.tabelle.application.mapper.RiduzioneTipoModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import it.iccs.simeal.sdi.tabelle.application.model.RiduzioneTipoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.RiduzioneTipoService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RiduzioneTipoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RiduzioneTipoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RiduzioneTipoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.RiduzioneTipoUpdateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.RiduzioneTipoPersistence;
import it.iccs.simeal.sdi.tabelle.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class RiduzioneTipoServiceImpl implements RiduzioneTipoService {

    @Autowired
    private RiduzioneTipoModelMapper riduzioneTipoModelMapper;

    @Autowired
    private RiduzioneTipoPersistence riduzioneTipoPersistence;

    @Override
    public RiduzioneTipoDTO create(RiduzioneTipoCreateDTO dto) {
        RiduzioneTipoDTO riduzioneTipoDTO = riduzioneTipoModelMapper.fromCreateDto(dto);
        RiduzioneTipoModel riduzioneTipoModel = riduzioneTipoModelMapper.toModel(riduzioneTipoDTO);
        RiduzioneTipoModel model = riduzioneTipoPersistence.save(riduzioneTipoModel);
        return riduzioneTipoModelMapper.toDto(model);
    }

    @Override
    public List<RiduzioneTipoDTO> findByIds(List<UUID> ids) {
        RiduzioneTipoCriteria criteria = new RiduzioneTipoCriteria().setId(ids);
        Page<RiduzioneTipoModel> models = riduzioneTipoPersistence.search(criteria, PageRequest.ofSize(10));
        return models.map(model -> this.riduzioneTipoModelMapper.toDto(model)).getContent();
    }

    @Override
    public Page<RiduzioneTipoDTO> search(RiduzioneTipoCriteria criteria, Pageable pageRequest) {
        Page<RiduzioneTipoModel> models = riduzioneTipoPersistence.search(criteria, pageRequest);
        return models.map(model -> this.riduzioneTipoModelMapper.toDto(model));
    }

    @Override
    public RiduzioneTipoDTO update(RiduzioneTipoUpdateDTO dto) {
        RiduzioneTipoDTO riduzioneTipoDTO = riduzioneTipoModelMapper.fromUpdateDto(dto);
        this.checkRiduzioneTipoExists(riduzioneTipoDTO.getId());
        RiduzioneTipoModel riduzioneTipoModel = riduzioneTipoModelMapper.toModel(riduzioneTipoDTO);
        riduzioneTipoPersistence.save(riduzioneTipoModel);

        RiduzioneTipoCriteria criteria = new RiduzioneTipoCriteria().setId(Collections.singletonList(riduzioneTipoDTO.getId()));
        Page<RiduzioneTipoModel> models = riduzioneTipoPersistence.search(criteria, PageRequest.ofSize(10));
        RiduzioneTipoModel model = models
                .getContent()
                .stream()
                .findAny()
                .orElse(null);
        return riduzioneTipoModelMapper.toDto(model);
    }

    @Override
    public void delete(UUID id) {
        this.checkRiduzioneTipoExists(id);
        RiduzioneTipoDTO riduzioneTipoDTO = this.findByIds(Collections.singletonList(id))
                .stream()
                .findAny()
                .orElse(null);
        riduzioneTipoDTO.setFlagElimina((short)1);

        RiduzioneTipoModel riduzioneTipoModel = riduzioneTipoModelMapper.toModel(riduzioneTipoDTO);
        riduzioneTipoPersistence.save(riduzioneTipoModel);
    }

    private void checkRiduzioneTipoExists(UUID id) {
        RiduzioneTipoCriteria criteria = new RiduzioneTipoCriteria().setId(Collections.singletonList(id));
        if (riduzioneTipoPersistence.search(criteria, PageRequest.ofSize(10)).isEmpty()) {
            log.warn("TipologiaRiduzione {} not found", id);
            throw new NotFoundException(String.format("TipologiaRiduzione %s not found", id));
        }
    }

}