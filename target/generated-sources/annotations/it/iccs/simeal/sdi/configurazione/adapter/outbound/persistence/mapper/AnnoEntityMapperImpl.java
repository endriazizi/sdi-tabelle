package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.AnnoEntity;
import it.iccs.simeal.sdi.configurazione.application.model.AnnoModel;
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
public class AnnoEntityMapperImpl implements AnnoEntityMapper {

    @Override
    public AnnoModel fromEntityToModel(AnnoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AnnoModel annoModel = new AnnoModel();

        annoModel.setId( entity.getId() );
        annoModel.setAnno( entity.getAnno() );
        annoModel.setDescrizione( entity.getDescrizione() );
        annoModel.setAnnoCorrente( entity.getAnnoCorrente() );
        annoModel.setFlagCongelaAnno( entity.getFlagCongelaAnno() );
        annoModel.setFlagIseeCalcolo( entity.getFlagIseeCalcolo() );

        return annoModel;
    }

    @Override
    public List<AnnoModel> fromEntitiesToModels(List<AnnoEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AnnoModel> list = new ArrayList<AnnoModel>( entityList.size() );
        for ( AnnoEntity annoEntity : entityList ) {
            list.add( fromEntityToModel( annoEntity ) );
        }

        return list;
    }

    @Override
    public List<AnnoEntity> fromModelsToEntities(List<AnnoModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<AnnoEntity> list = new ArrayList<AnnoEntity>( modelList.size() );
        for ( AnnoModel annoModel : modelList ) {
            list.add( fromModelToEntity( annoModel ) );
        }

        return list;
    }

    @Override
    public AnnoEntity fromModelToEntity(AnnoModel model) {
        if ( model == null ) {
            return null;
        }

        AnnoEntity annoEntity = new AnnoEntity();

        if ( model.getAnno() != null ) {
            annoEntity.setAnno( model.getAnno() );
        }
        else {
            annoEntity.setAnno( 0 );
        }
        if ( model.getAnnoCorrente() != null ) {
            annoEntity.setAnnoCorrente( model.getAnnoCorrente() );
        }
        else {
            annoEntity.setAnnoCorrente( (short) 0 );
        }
        if ( model.getFlagCongelaAnno() != null ) {
            annoEntity.setFlagCongelaAnno( model.getFlagCongelaAnno() );
        }
        else {
            annoEntity.setFlagCongelaAnno( (short) 0 );
        }
        if ( model.getFlagIseeCalcolo() != null ) {
            annoEntity.setFlagIseeCalcolo( model.getFlagIseeCalcolo() );
        }
        else {
            annoEntity.setFlagIseeCalcolo( (short) 0 );
        }
        annoEntity.setId( model.getId() );
        annoEntity.setDescrizione( model.getDescrizione() );

        return annoEntity;
    }
}
