package it.iccs.simeal.sdi.configurazione.application.mapper;

import it.iccs.simeal.sdi.configurazione.application.model.SezioneModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.SezioneCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.SezioneDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.SezioneUpdateDTO;
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
public class SezioneModelMapperImpl implements SezioneModelMapper {

    @Override
    public SezioneModel toModel(SezioneDTO dto) {
        if ( dto == null ) {
            return null;
        }

        SezioneModel sezioneModel = new SezioneModel();

        sezioneModel.setId( dto.getId() );
        sezioneModel.setDescrizione( dto.getDescrizione() );
        sezioneModel.setFlagElimina( dto.getFlagElimina() );

        return sezioneModel;
    }

    @Override
    public SezioneDTO toDto(SezioneModel entity) {
        if ( entity == null ) {
            return null;
        }

        SezioneDTO sezioneDTO = new SezioneDTO();

        sezioneDTO.setId( entity.getId() );
        sezioneDTO.setDescrizione( entity.getDescrizione() );
        sezioneDTO.setFlagElimina( entity.getFlagElimina() );

        return sezioneDTO;
    }

    @Override
    public List<SezioneModel> toModel(List<SezioneDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<SezioneModel> list = new ArrayList<SezioneModel>( dtoList.size() );
        for ( SezioneDTO sezioneDTO : dtoList ) {
            list.add( toModel( sezioneDTO ) );
        }

        return list;
    }

    @Override
    public List<SezioneDTO> toDto(List<SezioneModel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<SezioneDTO> list = new ArrayList<SezioneDTO>( entityList.size() );
        for ( SezioneModel sezioneModel : entityList ) {
            list.add( toDto( sezioneModel ) );
        }

        return list;
    }

    @Override
    public SezioneDTO fromCreateDto(SezioneCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        SezioneDTO sezioneDTO = new SezioneDTO();

        sezioneDTO.setDescrizione( dto.getDescrizione() );

        return sezioneDTO;
    }

    @Override
    public SezioneDTO fromUpdateDto(SezioneUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        SezioneDTO sezioneDTO = new SezioneDTO();

        sezioneDTO.setId( dto.getId() );
        sezioneDTO.setDescrizione( dto.getDescrizione() );

        return sezioneDTO;
    }
}
