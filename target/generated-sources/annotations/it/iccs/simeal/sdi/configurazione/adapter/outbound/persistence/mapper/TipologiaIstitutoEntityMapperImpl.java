package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.TipologiaIstitutoEntity;
import it.iccs.simeal.sdi.configurazione.application.model.TipologiaIstitutoModel;
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
public class TipologiaIstitutoEntityMapperImpl implements TipologiaIstitutoEntityMapper {

    @Override
    public TipologiaIstitutoModel fromEntityToModel(TipologiaIstitutoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        TipologiaIstitutoModel tipologiaIstitutoModel = new TipologiaIstitutoModel();

        tipologiaIstitutoModel.setId( entity.getId() );
        tipologiaIstitutoModel.setDescrizione( entity.getDescrizione() );
        tipologiaIstitutoModel.setFlagElimina( entity.getFlagElimina() );

        return tipologiaIstitutoModel;
    }

    @Override
    public List<TipologiaIstitutoModel> fromEntitiesToModels(List<TipologiaIstitutoEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<TipologiaIstitutoModel> list = new ArrayList<TipologiaIstitutoModel>( entityList.size() );
        for ( TipologiaIstitutoEntity tipologiaIstitutoEntity : entityList ) {
            list.add( fromEntityToModel( tipologiaIstitutoEntity ) );
        }

        return list;
    }

    @Override
    public List<TipologiaIstitutoEntity> fromModelsToEntities(List<TipologiaIstitutoModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<TipologiaIstitutoEntity> list = new ArrayList<TipologiaIstitutoEntity>( modelList.size() );
        for ( TipologiaIstitutoModel tipologiaIstitutoModel : modelList ) {
            list.add( fromModelToEntity( tipologiaIstitutoModel ) );
        }

        return list;
    }

    @Override
    public TipologiaIstitutoEntity fromModelToEntity(TipologiaIstitutoModel model) {
        if ( model == null ) {
            return null;
        }

        TipologiaIstitutoEntity tipologiaIstitutoEntity = new TipologiaIstitutoEntity();

        if ( model.getFlagElimina() != null ) {
            tipologiaIstitutoEntity.setFlagElimina( model.getFlagElimina() );
        }
        else {
            tipologiaIstitutoEntity.setFlagElimina( (short) 0 );
        }
        tipologiaIstitutoEntity.setId( model.getId() );
        tipologiaIstitutoEntity.setDescrizione( model.getDescrizione() );

        return tipologiaIstitutoEntity;
    }
}
