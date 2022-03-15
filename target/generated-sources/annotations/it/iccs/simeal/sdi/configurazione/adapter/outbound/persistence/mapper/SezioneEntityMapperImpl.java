package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.SezioneEntity;
import it.iccs.simeal.sdi.configurazione.application.model.SezioneModel;
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
public class SezioneEntityMapperImpl implements SezioneEntityMapper {

    @Override
    public SezioneModel fromEntityToModel(SezioneEntity entity) {
        if ( entity == null ) {
            return null;
        }

        SezioneModel sezioneModel = new SezioneModel();

        sezioneModel.setId( entity.getId() );
        sezioneModel.setDescrizione( entity.getDescrizione() );
        sezioneModel.setFlagElimina( entity.getFlagElimina() );

        return sezioneModel;
    }

    @Override
    public List<SezioneModel> fromEntitiesToModels(List<SezioneEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<SezioneModel> list = new ArrayList<SezioneModel>( entityList.size() );
        for ( SezioneEntity sezioneEntity : entityList ) {
            list.add( fromEntityToModel( sezioneEntity ) );
        }

        return list;
    }

    @Override
    public List<SezioneEntity> fromModelsToEntities(List<SezioneModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<SezioneEntity> list = new ArrayList<SezioneEntity>( modelList.size() );
        for ( SezioneModel sezioneModel : modelList ) {
            list.add( fromModelToEntity( sezioneModel ) );
        }

        return list;
    }

    @Override
    public SezioneEntity fromModelToEntity(SezioneModel model) {
        if ( model == null ) {
            return null;
        }

        SezioneEntity sezioneEntity = new SezioneEntity();

        if ( model.getFlagElimina() != null ) {
            sezioneEntity.setFlagElimina( model.getFlagElimina() );
        }
        else {
            sezioneEntity.setFlagElimina( (short) 0 );
        }
        sezioneEntity.setId( model.getId() );
        sezioneEntity.setDescrizione( model.getDescrizione() );

        return sezioneEntity;
    }
}
