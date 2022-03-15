package it.iccs.simeal.sdi.configurazione.application.mapper;

import it.iccs.simeal.sdi.configurazione.application.model.GiroModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.GiroDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.GiroUpdateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioGiroCreateDTO;
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
public class GiroModelMapperImpl implements GiroModelMapper {

    @Override
    public GiroModel toModel(GiroDTO dto) {
        if ( dto == null ) {
            return null;
        }

        GiroModel giroModel = new GiroModel();

        giroModel.setId( dto.getId() );
        giroModel.setDescrizione( dto.getDescrizione() );
        giroModel.setFlagElimina( dto.getFlagElimina() );

        return giroModel;
    }

    @Override
    public GiroDTO toDto(GiroModel entity) {
        if ( entity == null ) {
            return null;
        }

        GiroDTO giroDTO = new GiroDTO();

        giroDTO.setId( entity.getId() );
        giroDTO.setDescrizione( entity.getDescrizione() );
        giroDTO.setFlagElimina( entity.getFlagElimina() );

        return giroDTO;
    }

    @Override
    public List<GiroModel> toModel(List<GiroDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<GiroModel> list = new ArrayList<GiroModel>( dtoList.size() );
        for ( GiroDTO giroDTO : dtoList ) {
            list.add( toModel( giroDTO ) );
        }

        return list;
    }

    @Override
    public List<GiroDTO> toDto(List<GiroModel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<GiroDTO> list = new ArrayList<GiroDTO>( entityList.size() );
        for ( GiroModel giroModel : entityList ) {
            list.add( toDto( giroModel ) );
        }

        return list;
    }

    @Override
    public GiroDTO fromCreateDto(ServizioGiroCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        GiroDTO giroDTO = new GiroDTO();

        giroDTO.setDescrizione( dto.getDescrizione() );

        return giroDTO;
    }

    @Override
    public GiroDTO fromUpdateDto(GiroUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        GiroDTO giroDTO = new GiroDTO();

        giroDTO.setId( dto.getId() );
        giroDTO.setDescrizione( dto.getDescrizione() );

        return giroDTO;
    }
}
