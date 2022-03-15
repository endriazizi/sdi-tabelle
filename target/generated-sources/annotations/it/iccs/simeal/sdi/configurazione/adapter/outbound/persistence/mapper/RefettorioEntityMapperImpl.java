package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.RefettorioEntity;
import it.iccs.simeal.sdi.configurazione.application.model.RefettorioModel;
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
public class RefettorioEntityMapperImpl implements RefettorioEntityMapper {

    @Override
    public RefettorioModel fromEntityToModel(RefettorioEntity entity) {
        if ( entity == null ) {
            return null;
        }

        RefettorioModel refettorioModel = new RefettorioModel();

        refettorioModel.setId( entity.getId() );
        refettorioModel.setIdEnte( entity.getIdEnte() );
        refettorioModel.setDescrizione( entity.getDescrizione() );
        refettorioModel.setFlagElimina( entity.getFlagElimina() );

        return refettorioModel;
    }

    @Override
    public List<RefettorioModel> fromEntitiesToModels(List<RefettorioEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<RefettorioModel> list = new ArrayList<RefettorioModel>( entityList.size() );
        for ( RefettorioEntity refettorioEntity : entityList ) {
            list.add( fromEntityToModel( refettorioEntity ) );
        }

        return list;
    }

    @Override
    public List<RefettorioEntity> fromModelsToEntities(List<RefettorioModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<RefettorioEntity> list = new ArrayList<RefettorioEntity>( modelList.size() );
        for ( RefettorioModel refettorioModel : modelList ) {
            list.add( fromModelToEntity( refettorioModel ) );
        }

        return list;
    }

    @Override
    public RefettorioEntity fromModelToEntity(RefettorioModel model) {
        if ( model == null ) {
            return null;
        }

        RefettorioEntity refettorioEntity = new RefettorioEntity();

        if ( model.getFlagElimina() != null ) {
            refettorioEntity.setFlagElimina( model.getFlagElimina() );
        }
        else {
            refettorioEntity.setFlagElimina( (short) 0 );
        }
        refettorioEntity.setId( model.getId() );
        refettorioEntity.setIdEnte( model.getIdEnte() );
        refettorioEntity.setDescrizione( model.getDescrizione() );

        return refettorioEntity;
    }
}
