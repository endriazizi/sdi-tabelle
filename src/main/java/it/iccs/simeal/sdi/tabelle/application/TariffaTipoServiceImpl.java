package it.iccs.simeal.sdi.tabelle.application;

import java.util.Collections;
import java.util.List;
import java.util.UUID;

import it.iccs.simeal.sdi.tabelle.application.mapper.TariffaTipoModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;


import it.iccs.simeal.sdi.tabelle.application.model.TariffaTipoModel;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.TariffaTipoService;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TariffaTipoCreateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TariffaTipoCriteria;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TariffaTipoDTO;
import it.iccs.simeal.sdi.tabelle.application.port.inbound.service.model.TariffaTipoUpdateDTO;
import it.iccs.simeal.sdi.tabelle.application.port.outbound.persistence.TariffaTipoPersistence;
import it.iccs.simeal.sdi.tabelle.web.rest.errors.NotFoundException;
import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class TariffaTipoServiceImpl implements TariffaTipoService {

    @Autowired
    private TariffaTipoModelMapper tariffaTipoModelMapper;

    @Autowired
    private TariffaTipoPersistence tariffaTipoPersistence;

    @Override
    public TariffaTipoDTO create(TariffaTipoCreateDTO dto) {
        TariffaTipoDTO tariffaTipoDTO = tariffaTipoModelMapper.fromCreateDto(dto);
        TariffaTipoModel tariffaTipoModel = tariffaTipoModelMapper.toModel(tariffaTipoDTO);
        TariffaTipoModel model = tariffaTipoPersistence.save(tariffaTipoModel);
        return tariffaTipoModelMapper.toDto(model);
    }

    @Override
    public List<TariffaTipoDTO> findByIds(List<UUID> ids) {
        TariffaTipoCriteria criteria = new TariffaTipoCriteria().setId(ids);
        Page<TariffaTipoModel> models = tariffaTipoPersistence.search(criteria, PageRequest.ofSize(10));
        return models.map(model -> this.tariffaTipoModelMapper.toDto(model)).getContent();
    }

    @Override
    public Page<TariffaTipoDTO> search(TariffaTipoCriteria criteria, Pageable pageRequest) {
        Page<TariffaTipoModel> models = tariffaTipoPersistence.search(criteria, pageRequest);
        return models.map(model -> this.tariffaTipoModelMapper.toDto(model));
    }

    @Override
    public TariffaTipoDTO update(TariffaTipoUpdateDTO dto) {
        TariffaTipoDTO tariffaTipoDTO = tariffaTipoModelMapper.fromUpdateDto(dto);
        this.checkTariffaTipoExists(tariffaTipoDTO.getId());
        TariffaTipoModel tariffaTipoModel = tariffaTipoModelMapper.toModel(tariffaTipoDTO);
        tariffaTipoPersistence.save(tariffaTipoModel);

        TariffaTipoCriteria criteria = new TariffaTipoCriteria().setId(Collections.singletonList(tariffaTipoDTO.getId()));
        Page<TariffaTipoModel> models = tariffaTipoPersistence.search(criteria, PageRequest.ofSize(10));
        TariffaTipoModel model = models
                .getContent()
                .stream()
                .findAny()
                .orElse(null);
        return tariffaTipoModelMapper.toDto(model);
    }

    @Override
    public void delete(UUID id) {
        this.checkTariffaTipoExists(id);
        TariffaTipoDTO tariffaTipoDTO = this.findByIds(Collections.singletonList(id))
                .stream()
                .findAny()
                .orElse(null);
        tariffaTipoDTO.setFlagElimina((short)1);

        TariffaTipoModel tariffaTipoModel = tariffaTipoModelMapper.toModel(tariffaTipoDTO);
        tariffaTipoPersistence.save(tariffaTipoModel);
    }

    private void checkTariffaTipoExists(UUID id) {
        TariffaTipoCriteria criteria = new TariffaTipoCriteria().setId(Collections.singletonList(id));
        if (tariffaTipoPersistence.search(criteria, PageRequest.ofSize(10)).isEmpty()) {
            log.warn("TipologiaRiduzione {} not found", id);
            throw new NotFoundException(String.format("TipologiaRiduzione %s not found", id));
        }
    }

}