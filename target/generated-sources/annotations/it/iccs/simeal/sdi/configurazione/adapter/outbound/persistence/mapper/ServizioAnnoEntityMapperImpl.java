package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ServizioAnnoEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ServizioEntity;
import it.iccs.simeal.sdi.configurazione.application.model.ServizioAnnoModel;
import it.iccs.simeal.sdi.configurazione.application.model.ServizioModel;
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
public class ServizioAnnoEntityMapperImpl implements ServizioAnnoEntityMapper {

    @Override
    public ServizioAnnoModel fromEntityToModel(ServizioAnnoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ServizioAnnoModel servizioAnnoModel = new ServizioAnnoModel();

        servizioAnnoModel.setId( entity.getId() );
        servizioAnnoModel.setAnno( entity.getAnno() );
        servizioAnnoModel.setServizio( servizioEntityToServizioModel( entity.getServizio() ) );
        servizioAnnoModel.setTipologiaRilevazione( entity.getTipologiaRilevazione() );

        return servizioAnnoModel;
    }

    @Override
    public List<ServizioAnnoModel> fromEntitiesToModels(List<ServizioAnnoEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ServizioAnnoModel> list = new ArrayList<ServizioAnnoModel>( entityList.size() );
        for ( ServizioAnnoEntity servizioAnnoEntity : entityList ) {
            list.add( fromEntityToModel( servizioAnnoEntity ) );
        }

        return list;
    }

    @Override
    public List<ServizioAnnoEntity> fromModelsToEntities(List<ServizioAnnoModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<ServizioAnnoEntity> list = new ArrayList<ServizioAnnoEntity>( modelList.size() );
        for ( ServizioAnnoModel servizioAnnoModel : modelList ) {
            list.add( fromModelToEntity( servizioAnnoModel ) );
        }

        return list;
    }

    @Override
    public ServizioAnnoEntity fromModelToEntity(ServizioAnnoModel model) {
        if ( model == null ) {
            return null;
        }

        ServizioAnnoEntity servizioAnnoEntity = new ServizioAnnoEntity();

        servizioAnnoEntity.setId( model.getId() );
        servizioAnnoEntity.setAnno( model.getAnno() );
        servizioAnnoEntity.setServizio( servizioModelToServizioEntity( model.getServizio() ) );
        servizioAnnoEntity.setTipologiaRilevazione( model.getTipologiaRilevazione() );

        return servizioAnnoEntity;
    }

    protected ServizioModel servizioEntityToServizioModel(ServizioEntity servizioEntity) {
        if ( servizioEntity == null ) {
            return null;
        }

        ServizioModel servizioModel = new ServizioModel();

        servizioModel.setId( servizioEntity.getId() );
        servizioModel.setIdEnte( servizioEntity.getIdEnte() );
        servizioModel.setDescrizione( servizioEntity.getDescrizione() );
        servizioModel.setFlagElimina( servizioEntity.getFlagElimina() );
        if ( servizioEntity.getCodice() != null ) {
            servizioModel.setCodice( servizioEntity.getCodice().intValue() );
        }

        return servizioModel;
    }

    protected ServizioEntity servizioModelToServizioEntity(ServizioModel servizioModel) {
        if ( servizioModel == null ) {
            return null;
        }

        ServizioEntity servizioEntity = new ServizioEntity();

        servizioEntity.setId( servizioModel.getId() );
        servizioEntity.setIdEnte( servizioModel.getIdEnte() );
        servizioEntity.setDescrizione( servizioModel.getDescrizione() );
        servizioEntity.setFlagElimina( servizioModel.getFlagElimina() );
        if ( servizioModel.getCodice() != null ) {
            servizioEntity.setCodice( servizioModel.getCodice().shortValue() );
        }

        return servizioEntity;
    }
}
