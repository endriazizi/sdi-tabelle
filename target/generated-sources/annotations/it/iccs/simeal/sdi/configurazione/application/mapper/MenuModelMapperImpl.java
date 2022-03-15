package it.iccs.simeal.sdi.configurazione.application.mapper;

import it.iccs.simeal.sdi.configurazione.application.model.MenuModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.MenuCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.MenuDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.MenuUpdateDTO;
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
public class MenuModelMapperImpl implements MenuModelMapper {

    @Override
    public MenuModel toModel(MenuDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MenuModel menuModel = new MenuModel();

        menuModel.setId( dto.getId() );
        menuModel.setIdEnte( dto.getIdEnte() );
        menuModel.setAnno( dto.getAnno() );
        menuModel.setDescrizione( dto.getDescrizione() );
        menuModel.setDataInizio( dto.getDataInizio() );
        menuModel.setDataFine( dto.getDataFine() );
        menuModel.setFilenameMenu( dto.getFilenameMenu() );
        menuModel.setFlagElimina( dto.getFlagElimina() );

        return menuModel;
    }

    @Override
    public MenuDTO toDto(MenuModel entity) {
        if ( entity == null ) {
            return null;
        }

        MenuDTO menuDTO = new MenuDTO();

        menuDTO.setId( entity.getId() );
        menuDTO.setIdEnte( entity.getIdEnte() );
        menuDTO.setAnno( entity.getAnno() );
        menuDTO.setDescrizione( entity.getDescrizione() );
        menuDTO.setDataInizio( entity.getDataInizio() );
        menuDTO.setDataFine( entity.getDataFine() );
        menuDTO.setFilenameMenu( entity.getFilenameMenu() );
        menuDTO.setFlagElimina( entity.getFlagElimina() );

        return menuDTO;
    }

    @Override
    public List<MenuModel> toModel(List<MenuDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<MenuModel> list = new ArrayList<MenuModel>( dtoList.size() );
        for ( MenuDTO menuDTO : dtoList ) {
            list.add( toModel( menuDTO ) );
        }

        return list;
    }

    @Override
    public List<MenuDTO> toDto(List<MenuModel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<MenuDTO> list = new ArrayList<MenuDTO>( entityList.size() );
        for ( MenuModel menuModel : entityList ) {
            list.add( toDto( menuModel ) );
        }

        return list;
    }

    @Override
    public MenuDTO fromCreateDto(MenuCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MenuDTO menuDTO = new MenuDTO();

        menuDTO.setId( dto.getId() );
        menuDTO.setIdEnte( dto.getIdEnte() );
        menuDTO.setAnno( dto.getAnno() );
        menuDTO.setDescrizione( dto.getDescrizione() );
        menuDTO.setDataInizio( dto.getDataInizio() );
        menuDTO.setDataFine( dto.getDataFine() );
        menuDTO.setFilenameMenu( dto.getFilenameMenu() );

        return menuDTO;
    }

    @Override
    public MenuDTO fromUpdateDto(MenuUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        MenuDTO menuDTO = new MenuDTO();

        menuDTO.setId( dto.getId() );
        menuDTO.setIdEnte( dto.getIdEnte() );
        menuDTO.setAnno( dto.getAnno() );
        menuDTO.setDescrizione( dto.getDescrizione() );
        menuDTO.setDataInizio( dto.getDataInizio() );
        menuDTO.setDataFine( dto.getDataFine() );
        menuDTO.setFilenameMenu( dto.getFilenameMenu() );

        return menuDTO;
    }
}
