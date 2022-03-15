package it.iccs.simeal.sdi.configurazione.application.mapper;

import it.iccs.simeal.sdi.configurazione.application.model.RefettorioModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.RefettorioCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.RefettorioDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.RefettorioUpdateDTO;
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
public class RefettorioModelMapperImpl implements RefettorioModelMapper {

    @Override
    public RefettorioModel toModel(RefettorioDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RefettorioModel refettorioModel = new RefettorioModel();

        refettorioModel.setId( dto.getId() );
        refettorioModel.setIdEnte( dto.getIdEnte() );
        refettorioModel.setDescrizione( dto.getDescrizione() );
        refettorioModel.setFlagElimina( dto.getFlagElimina() );

        return refettorioModel;
    }

    @Override
    public RefettorioDTO toDto(RefettorioModel entity) {
        if ( entity == null ) {
            return null;
        }

        RefettorioDTO refettorioDTO = new RefettorioDTO();

        refettorioDTO.setId( entity.getId() );
        refettorioDTO.setIdEnte( entity.getIdEnte() );
        refettorioDTO.setDescrizione( entity.getDescrizione() );
        refettorioDTO.setFlagElimina( entity.getFlagElimina() );

        return refettorioDTO;
    }

    @Override
    public List<RefettorioModel> toModel(List<RefettorioDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<RefettorioModel> list = new ArrayList<RefettorioModel>( dtoList.size() );
        for ( RefettorioDTO refettorioDTO : dtoList ) {
            list.add( toModel( refettorioDTO ) );
        }

        return list;
    }

    @Override
    public List<RefettorioDTO> toDto(List<RefettorioModel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RefettorioDTO> list = new ArrayList<RefettorioDTO>( entityList.size() );
        for ( RefettorioModel refettorioModel : entityList ) {
            list.add( toDto( refettorioModel ) );
        }

        return list;
    }

    @Override
    public RefettorioDTO fromCreateDto(RefettorioCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RefettorioDTO refettorioDTO = new RefettorioDTO();

        refettorioDTO.setIdEnte( dto.getIdEnte() );
        refettorioDTO.setDescrizione( dto.getDescrizione() );

        return refettorioDTO;
    }

    @Override
    public RefettorioDTO fromUpdateDto(RefettorioUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        RefettorioDTO refettorioDTO = new RefettorioDTO();

        refettorioDTO.setId( dto.getId() );
        refettorioDTO.setIdEnte( dto.getIdEnte() );
        refettorioDTO.setDescrizione( dto.getDescrizione() );

        return refettorioDTO;
    }
}
