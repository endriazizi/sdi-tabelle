package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.TurnoEntity;
import it.iccs.simeal.sdi.configurazione.application.model.TurnoModel;
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
public class TurnoEntityMapperImpl implements TurnoEntityMapper {

    @Override
    public List<TurnoModel> fromEntitiesToModels(List<TurnoEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TurnoModel> list = new ArrayList<TurnoModel>( entityList.size() );
        for ( TurnoEntity turnoEntity : entityList ) {
            list.add( fromEntityToModel( turnoEntity ) );
        }

        return list;
    }

    @Override
    public List<TurnoEntity> fromModelsToEntities(List<TurnoModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<TurnoEntity> list = new ArrayList<TurnoEntity>( modelList.size() );
        for ( TurnoModel turnoModel : modelList ) {
            list.add( fromModelToEntity( turnoModel ) );
        }

        return list;
    }

    @Override
    public TurnoEntity fromModelToEntity(TurnoModel model) {
        if ( model == null ) {
            return null;
        }

        TurnoEntity turnoEntity = new TurnoEntity();

        if ( model.getFlagElimina() != null ) {
            turnoEntity.setFlagElimina( model.getFlagElimina() );
        }
        else {
            turnoEntity.setFlagElimina( (short) 0 );
        }
        turnoEntity.setId( model.getId() );
        turnoEntity.setDescrizione( model.getDescrizione() );

        return turnoEntity;
    }

    @Override
    public TurnoModel fromEntityToModel(TurnoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        TurnoModel turnoModel = new TurnoModel();

        turnoModel.setId( entity.getId() );
        turnoModel.setDescrizione( entity.getDescrizione() );
        turnoModel.setFlagElimina( entity.getFlagElimina() );

        return turnoModel;
    }
}
