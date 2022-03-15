package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.TipologiaRiduzioneEntity;
import it.iccs.simeal.sdi.configurazione.application.model.TipologiaRiduzioneModel;
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
public class TipologiaRiduzioneEntityMapperImpl implements TipologiaRiduzioneEntityMapper {

    @Override
    public TipologiaRiduzioneModel fromEntityToModel(TipologiaRiduzioneEntity entity) {
        if ( entity == null ) {
            return null;
        }

        TipologiaRiduzioneModel tipologiaRiduzioneModel = new TipologiaRiduzioneModel();

        tipologiaRiduzioneModel.setId( entity.getId() );
        tipologiaRiduzioneModel.setDescrizione( entity.getDescrizione() );
        tipologiaRiduzioneModel.setFlagElimina( entity.getFlagElimina() );

        return tipologiaRiduzioneModel;
    }

    @Override
    public List<TipologiaRiduzioneModel> fromEntitiesToModels(List<TipologiaRiduzioneEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TipologiaRiduzioneModel> list = new ArrayList<TipologiaRiduzioneModel>( entityList.size() );
        for ( TipologiaRiduzioneEntity tipologiaRiduzioneEntity : entityList ) {
            list.add( fromEntityToModel( tipologiaRiduzioneEntity ) );
        }

        return list;
    }

    @Override
    public List<TipologiaRiduzioneEntity> fromModelsToEntities(List<TipologiaRiduzioneModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<TipologiaRiduzioneEntity> list = new ArrayList<TipologiaRiduzioneEntity>( modelList.size() );
        for ( TipologiaRiduzioneModel tipologiaRiduzioneModel : modelList ) {
            list.add( fromModelToEntity( tipologiaRiduzioneModel ) );
        }

        return list;
    }

    @Override
    public TipologiaRiduzioneEntity fromModelToEntity(TipologiaRiduzioneModel model) {
        if ( model == null ) {
            return null;
        }

        TipologiaRiduzioneEntity tipologiaRiduzioneEntity = new TipologiaRiduzioneEntity();

        if ( model.getFlagElimina() != null ) {
            tipologiaRiduzioneEntity.setFlagElimina( model.getFlagElimina() );
        }
        else {
            tipologiaRiduzioneEntity.setFlagElimina( (short) 0 );
        }
        tipologiaRiduzioneEntity.setId( model.getId() );
        tipologiaRiduzioneEntity.setDescrizione( model.getDescrizione() );

        return tipologiaRiduzioneEntity;
    }
}
