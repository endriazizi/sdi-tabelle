package it.iccs.simeal.sdi.configurazione.application.mapper;

import it.iccs.simeal.sdi.configurazione.application.model.TipologiaIstitutoModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TipologiaIstitutoCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TipologiaIstitutoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TipologiaIstitutoUpdateDTO;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-15T20:02:41+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class TipologiaIstitutoModelMapperImpl implements TipologiaIstitutoModelMapper {

    @Override
    public TipologiaIstitutoModel toModel(TipologiaIstitutoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TipologiaIstitutoModel tipologiaIstitutoModel = new TipologiaIstitutoModel();

        tipologiaIstitutoModel.setId( dto.getId() );
        tipologiaIstitutoModel.setDescrizione( dto.getDescrizione() );
        tipologiaIstitutoModel.setFlagElimina( dto.getFlagElimina() );

        return tipologiaIstitutoModel;
    }

    @Override
    public TipologiaIstitutoDTO toDto(TipologiaIstitutoModel entity) {
        if ( entity == null ) {
            return null;
        }

        TipologiaIstitutoDTO tipologiaIstitutoDTO = new TipologiaIstitutoDTO();

        tipologiaIstitutoDTO.setId( entity.getId() );
        tipologiaIstitutoDTO.setDescrizione( entity.getDescrizione() );
        tipologiaIstitutoDTO.setFlagElimina( entity.getFlagElimina() );

        return tipologiaIstitutoDTO;
    }

    @Override
    public List<TipologiaIstitutoModel> toModel(List<TipologiaIstitutoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TipologiaIstitutoModel> list = new ArrayList<TipologiaIstitutoModel>( dtoList.size() );
        for ( TipologiaIstitutoDTO tipologiaIstitutoDTO : dtoList ) {
            list.add( toModel( tipologiaIstitutoDTO ) );
        }

        return list;
    }

    @Override
    public List<TipologiaIstitutoDTO> toDto(List<TipologiaIstitutoModel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TipologiaIstitutoDTO> list = new ArrayList<TipologiaIstitutoDTO>( entityList.size() );
        for ( TipologiaIstitutoModel tipologiaIstitutoModel : entityList ) {
            list.add( toDto( tipologiaIstitutoModel ) );
        }

        return list;
    }

    @Override
    public TipologiaIstitutoDTO fromCreateDto(TipologiaIstitutoCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TipologiaIstitutoDTO tipologiaIstitutoDTO = new TipologiaIstitutoDTO();

        tipologiaIstitutoDTO.setDescrizione( dto.getDescrizione() );

        return tipologiaIstitutoDTO;
    }

    @Override
    public TipologiaIstitutoDTO fromUpdateDto(TipologiaIstitutoUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TipologiaIstitutoDTO tipologiaIstitutoDTO = new TipologiaIstitutoDTO();

        tipologiaIstitutoDTO.setId( dto.getId() );
        tipologiaIstitutoDTO.setDescrizione( dto.getDescrizione() );

        return tipologiaIstitutoDTO;
    }
}
