package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.GiroEntity;
import it.iccs.simeal.sdi.configurazione.application.model.GiroModel;
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
public class GiroEntityMapperImpl implements GiroEntityMapper {

    @Override
    public GiroModel fromEntityToModel(GiroEntity entity) {
        if ( entity == null ) {
            return null;
        }

        GiroModel giroModel = new GiroModel();

        giroModel.setId( entity.getId() );
        giroModel.setDescrizione( entity.getDescrizione() );
        giroModel.setFlagElimina( entity.getFlagElimina() );

        return giroModel;
    }

    @Override
    public List<GiroModel> fromEntitiesToModels(List<GiroEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<GiroModel> list = new ArrayList<GiroModel>( entityList.size() );
        for ( GiroEntity giroEntity : entityList ) {
            list.add( fromEntityToModel( giroEntity ) );
        }

        return list;
    }

    @Override
    public List<GiroEntity> fromModelsToEntities(List<GiroModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<GiroEntity> list = new ArrayList<GiroEntity>( modelList.size() );
        for ( GiroModel giroModel : modelList ) {
            list.add( fromModelToEntity( giroModel ) );
        }

        return list;
    }

    @Override
    public GiroEntity fromModelToEntity(GiroModel model) {
        if ( model == null ) {
            return null;
        }

        GiroEntity giroEntity = new GiroEntity();

        if ( model.getFlagElimina() != null ) {
            giroEntity.setFlagElimina( model.getFlagElimina() );
        }
        else {
            giroEntity.setFlagElimina( (short) 0 );
        }
        giroEntity.setId( model.getId() );
        giroEntity.setDescrizione( model.getDescrizione() );

        return giroEntity;
    }
}
