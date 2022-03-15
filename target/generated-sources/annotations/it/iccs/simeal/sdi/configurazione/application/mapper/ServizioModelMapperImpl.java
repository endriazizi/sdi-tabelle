package it.iccs.simeal.sdi.configurazione.application.mapper;

import it.iccs.simeal.sdi.configurazione.application.model.ServizioModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioUpdateDTO;
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
public class ServizioModelMapperImpl implements ServizioModelMapper {

    @Override
    public ServizioModel toModel(ServizioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ServizioModel servizioModel = new ServizioModel();

        servizioModel.setId( dto.getId() );
        servizioModel.setIdEnte( dto.getIdEnte() );
        servizioModel.setDescrizione( dto.getDescrizione() );
        servizioModel.setFlagElimina( dto.getFlagElimina() );
        servizioModel.setCodice( dto.getCodice() );

        return servizioModel;
    }

    @Override
    public ServizioDTO toDto(ServizioModel entity) {
        if ( entity == null ) {
            return null;
        }

        ServizioDTO servizioDTO = new ServizioDTO();

        servizioDTO.setId( entity.getId() );
        servizioDTO.setIdEnte( entity.getIdEnte() );
        servizioDTO.setDescrizione( entity.getDescrizione() );
        servizioDTO.setFlagElimina( entity.getFlagElimina() );
        servizioDTO.setCodice( entity.getCodice() );

        return servizioDTO;
    }

    @Override
    public List<ServizioModel> toModel(List<ServizioDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ServizioModel> list = new ArrayList<ServizioModel>( dtoList.size() );
        for ( ServizioDTO servizioDTO : dtoList ) {
            list.add( toModel( servizioDTO ) );
        }

        return list;
    }

    @Override
    public List<ServizioDTO> toDto(List<ServizioModel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ServizioDTO> list = new ArrayList<ServizioDTO>( entityList.size() );
        for ( ServizioModel servizioModel : entityList ) {
            list.add( toDto( servizioModel ) );
        }

        return list;
    }

    @Override
    public ServizioDTO fromCreateDto(ServizioCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ServizioDTO servizioDTO = new ServizioDTO();

        servizioDTO.setIdEnte( dto.getIdEnte() );
        servizioDTO.setDescrizione( dto.getDescrizione() );
        servizioDTO.setCodice( dto.getCodice() );

        return servizioDTO;
    }

    @Override
    public ServizioDTO fromUpdateDto(ServizioUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ServizioDTO servizioDTO = new ServizioDTO();

        servizioDTO.setId( dto.getId() );
        servizioDTO.setIdEnte( dto.getIdEnte() );
        servizioDTO.setDescrizione( dto.getDescrizione() );
        servizioDTO.setCodice( dto.getCodice() );

        return servizioDTO;
    }
}
