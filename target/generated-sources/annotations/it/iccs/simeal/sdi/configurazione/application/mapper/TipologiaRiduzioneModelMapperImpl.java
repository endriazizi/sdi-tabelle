package it.iccs.simeal.sdi.configurazione.application.mapper;

import it.iccs.simeal.sdi.configurazione.application.model.TipologiaRiduzioneModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TipologiaRiduzioneCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TipologiaRiduzioneDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TipologiaRiduzioneUpdateDTO;
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
public class TipologiaRiduzioneModelMapperImpl implements TipologiaRiduzioneModelMapper {

    @Override
    public TipologiaRiduzioneModel toModel(TipologiaRiduzioneDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TipologiaRiduzioneModel tipologiaRiduzioneModel = new TipologiaRiduzioneModel();

        tipologiaRiduzioneModel.setId( dto.getId() );
        tipologiaRiduzioneModel.setDescrizione( dto.getDescrizione() );
        tipologiaRiduzioneModel.setFlagElimina( dto.getFlagElimina() );

        return tipologiaRiduzioneModel;
    }

    @Override
    public TipologiaRiduzioneDTO toDto(TipologiaRiduzioneModel entity) {
        if ( entity == null ) {
            return null;
        }

        TipologiaRiduzioneDTO tipologiaRiduzioneDTO = new TipologiaRiduzioneDTO();

        tipologiaRiduzioneDTO.setId( entity.getId() );
        tipologiaRiduzioneDTO.setDescrizione( entity.getDescrizione() );
        tipologiaRiduzioneDTO.setFlagElimina( entity.getFlagElimina() );

        return tipologiaRiduzioneDTO;
    }

    @Override
    public List<TipologiaRiduzioneModel> toModel(List<TipologiaRiduzioneDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TipologiaRiduzioneModel> list = new ArrayList<TipologiaRiduzioneModel>( dtoList.size() );
        for ( TipologiaRiduzioneDTO tipologiaRiduzioneDTO : dtoList ) {
            list.add( toModel( tipologiaRiduzioneDTO ) );
        }

        return list;
    }

    @Override
    public List<TipologiaRiduzioneDTO> toDto(List<TipologiaRiduzioneModel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TipologiaRiduzioneDTO> list = new ArrayList<TipologiaRiduzioneDTO>( entityList.size() );
        for ( TipologiaRiduzioneModel tipologiaRiduzioneModel : entityList ) {
            list.add( toDto( tipologiaRiduzioneModel ) );
        }

        return list;
    }

    @Override
    public TipologiaRiduzioneDTO fromCreateDto(TipologiaRiduzioneCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TipologiaRiduzioneDTO tipologiaRiduzioneDTO = new TipologiaRiduzioneDTO();

        tipologiaRiduzioneDTO.setDescrizione( dto.getDescrizione() );

        return tipologiaRiduzioneDTO;
    }

    @Override
    public TipologiaRiduzioneDTO fromUpdateDto(TipologiaRiduzioneUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TipologiaRiduzioneDTO tipologiaRiduzioneDTO = new TipologiaRiduzioneDTO();

        tipologiaRiduzioneDTO.setId( dto.getId() );
        tipologiaRiduzioneDTO.setDescrizione( dto.getDescrizione() );

        return tipologiaRiduzioneDTO;
    }
}
