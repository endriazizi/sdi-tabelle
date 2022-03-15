package it.iccs.simeal.sdi.configurazione.application.mapper;

import it.iccs.simeal.sdi.configurazione.application.model.GiroModel;
import it.iccs.simeal.sdi.configurazione.application.model.TurnoModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.GiroDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TurnoCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TurnoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TurnoUpdateDTO;
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
public class TurnoModelMapperImpl implements TurnoModelMapper {

    @Override
    public TurnoModel toModel(TurnoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TurnoModel turnoModel = new TurnoModel();

        turnoModel.setId( dto.getId() );
        turnoModel.setDescrizione( dto.getDescrizione() );
        turnoModel.setFlagElimina( dto.getFlagElimina() );
        turnoModel.setGiro( giroDTOToGiroModel( dto.getGiro() ) );

        return turnoModel;
    }

    @Override
    public TurnoDTO toDto(TurnoModel entity) {
        if ( entity == null ) {
            return null;
        }

        TurnoDTO turnoDTO = new TurnoDTO();

        turnoDTO.setId( entity.getId() );
        turnoDTO.setDescrizione( entity.getDescrizione() );
        turnoDTO.setFlagElimina( entity.getFlagElimina() );
        turnoDTO.setGiro( giroModelToGiroDTO( entity.getGiro() ) );

        return turnoDTO;
    }

    @Override
    public List<TurnoModel> toModel(List<TurnoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<TurnoModel> list = new ArrayList<TurnoModel>( dtoList.size() );
        for ( TurnoDTO turnoDTO : dtoList ) {
            list.add( toModel( turnoDTO ) );
        }

        return list;
    }

    @Override
    public List<TurnoDTO> toDto(List<TurnoModel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TurnoDTO> list = new ArrayList<TurnoDTO>( entityList.size() );
        for ( TurnoModel turnoModel : entityList ) {
            list.add( toDto( turnoModel ) );
        }

        return list;
    }

    @Override
    public TurnoDTO fromCreateDto(TurnoCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TurnoDTO turnoDTO = new TurnoDTO();

        turnoDTO.setDescrizione( dto.getDescrizione() );

        return turnoDTO;
    }

    @Override
    public TurnoDTO fromUpdateDto(TurnoUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        TurnoDTO turnoDTO = new TurnoDTO();

        turnoDTO.setId( dto.getId() );
        turnoDTO.setDescrizione( dto.getDescrizione() );

        return turnoDTO;
    }

    protected GiroModel giroDTOToGiroModel(GiroDTO giroDTO) {
        if ( giroDTO == null ) {
            return null;
        }

        GiroModel giroModel = new GiroModel();

        giroModel.setId( giroDTO.getId() );
        giroModel.setDescrizione( giroDTO.getDescrizione() );
        giroModel.setFlagElimina( giroDTO.getFlagElimina() );

        return giroModel;
    }

    protected GiroDTO giroModelToGiroDTO(GiroModel giroModel) {
        if ( giroModel == null ) {
            return null;
        }

        GiroDTO giroDTO = new GiroDTO();

        giroDTO.setId( giroModel.getId() );
        giroDTO.setDescrizione( giroModel.getDescrizione() );
        giroDTO.setFlagElimina( giroModel.getFlagElimina() );

        return giroDTO;
    }
}
