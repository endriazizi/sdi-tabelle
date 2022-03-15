package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.MenuEntity;
import it.iccs.simeal.sdi.configurazione.application.model.MenuModel;
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
public class MenuEntityMapperImpl implements MenuEntityMapper {

    @Override
    public MenuModel fromEntityToModel(MenuEntity entity) {
        if ( entity == null ) {
            return null;
        }

        MenuModel menuModel = new MenuModel();

        menuModel.setId( entity.getId() );
        menuModel.setIdEnte( entity.getIdEnte() );
        menuModel.setAnno( entity.getAnno() );
        menuModel.setDescrizione( entity.getDescrizione() );
        menuModel.setDataInizio( entity.getDataInizio() );
        menuModel.setDataFine( entity.getDataFine() );
        menuModel.setFilenameMenu( entity.getFilenameMenu() );
        menuModel.setFlagElimina( entity.getFlagElimina() );

        return menuModel;
    }

    @Override
    public List<MenuModel> fromEntitiesToModels(List<MenuEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<MenuModel> list = new ArrayList<MenuModel>( entityList.size() );
        for ( MenuEntity menuEntity : entityList ) {
            list.add( fromEntityToModel( menuEntity ) );
        }

        return list;
    }

    @Override
    public List<MenuEntity> fromModelsToEntities(List<MenuModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<MenuEntity> list = new ArrayList<MenuEntity>( modelList.size() );
        for ( MenuModel menuModel : modelList ) {
            list.add( fromModelToEntity( menuModel ) );
        }

        return list;
    }

    @Override
    public MenuEntity fromModelToEntity(MenuModel model) {
        if ( model == null ) {
            return null;
        }

        MenuEntity menuEntity = new MenuEntity();

        if ( model.getFlagElimina() != null ) {
            menuEntity.setFlagElimina( model.getFlagElimina() );
        }
        else {
            menuEntity.setFlagElimina( (short) 0 );
        }
        menuEntity.setId( model.getId() );
        menuEntity.setIdEnte( model.getIdEnte() );
        menuEntity.setAnno( model.getAnno() );
        menuEntity.setDescrizione( model.getDescrizione() );
        menuEntity.setDataInizio( model.getDataInizio() );
        menuEntity.setDataFine( model.getDataFine() );
        menuEntity.setFilenameMenu( model.getFilenameMenu() );

        return menuEntity;
    }
}
