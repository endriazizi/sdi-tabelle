package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ServizioEntity;
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
public class ServizioEntityMapperImpl implements ServizioEntityMapper {

    @Override
    public ServizioModel fromEntityToModel(ServizioEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ServizioModel servizioModel = new ServizioModel();

        servizioModel.setId( entity.getId() );
        servizioModel.setIdEnte( entity.getIdEnte() );
        servizioModel.setDescrizione( entity.getDescrizione() );
        servizioModel.setFlagElimina( entity.getFlagElimina() );
        if ( entity.getCodice() != null ) {
            servizioModel.setCodice( entity.getCodice().intValue() );
        }

        return servizioModel;
    }

    @Override
    public List<ServizioModel> fromEntitiesToModels(List<ServizioEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ServizioModel> list = new ArrayList<ServizioModel>( entityList.size() );
        for ( ServizioEntity servizioEntity : entityList ) {
            list.add( fromEntityToModel( servizioEntity ) );
        }

        return list;
    }

    @Override
    public List<ServizioEntity> fromModelsToEntities(List<ServizioModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<ServizioEntity> list = new ArrayList<ServizioEntity>( modelList.size() );
        for ( ServizioModel servizioModel : modelList ) {
            list.add( fromModelToEntity( servizioModel ) );
        }

        return list;
    }

    @Override
    public ServizioEntity fromModelToEntity(ServizioModel model) {
        if ( model == null ) {
            return null;
        }

        ServizioEntity servizioEntity = new ServizioEntity();

        if ( model.getFlagElimina() != null ) {
            servizioEntity.setFlagElimina( model.getFlagElimina() );
        }
        else {
            servizioEntity.setFlagElimina( (short) 0 );
        }
        servizioEntity.setId( model.getId() );
        servizioEntity.setIdEnte( model.getIdEnte() );
        servizioEntity.setDescrizione( model.getDescrizione() );
        if ( model.getCodice() != null ) {
            servizioEntity.setCodice( model.getCodice().shortValue() );
        }

        return servizioEntity;
    }
}
