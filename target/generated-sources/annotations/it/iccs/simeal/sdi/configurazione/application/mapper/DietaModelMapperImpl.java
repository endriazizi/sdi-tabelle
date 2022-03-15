package it.iccs.simeal.sdi.configurazione.application.mapper;

import it.iccs.simeal.sdi.configurazione.application.model.DietaModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.DietaCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.DietaDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.DietaUpdateDTO;
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
public class DietaModelMapperImpl implements DietaModelMapper {

    @Override
    public DietaModel toModel(DietaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DietaModel dietaModel = new DietaModel();

        dietaModel.setId( dto.getId() );
        dietaModel.setDescrizione( dto.getDescrizione() );
        dietaModel.setFlagElimina( dto.getFlagElimina() );

        return dietaModel;
    }

    @Override
    public DietaDTO toDto(DietaModel entity) {
        if ( entity == null ) {
            return null;
        }

        DietaDTO dietaDTO = new DietaDTO();

        dietaDTO.setId( entity.getId() );
        dietaDTO.setDescrizione( entity.getDescrizione() );
        dietaDTO.setFlagElimina( entity.getFlagElimina() );

        return dietaDTO;
    }

    @Override
    public List<DietaModel> toModel(List<DietaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<DietaModel> list = new ArrayList<DietaModel>( dtoList.size() );
        for ( DietaDTO dietaDTO : dtoList ) {
            list.add( toModel( dietaDTO ) );
        }

        return list;
    }

    @Override
    public List<DietaDTO> toDto(List<DietaModel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DietaDTO> list = new ArrayList<DietaDTO>( entityList.size() );
        for ( DietaModel dietaModel : entityList ) {
            list.add( toDto( dietaModel ) );
        }

        return list;
    }

    @Override
    public DietaDTO fromCreateDto(DietaCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DietaDTO dietaDTO = new DietaDTO();

        dietaDTO.setDescrizione( dto.getDescrizione() );

        return dietaDTO;
    }

    @Override
    public DietaDTO fromUpdateDto(DietaUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        DietaDTO dietaDTO = new DietaDTO();

        dietaDTO.setId( dto.getId() );
        dietaDTO.setDescrizione( dto.getDescrizione() );

        return dietaDTO;
    }
}
