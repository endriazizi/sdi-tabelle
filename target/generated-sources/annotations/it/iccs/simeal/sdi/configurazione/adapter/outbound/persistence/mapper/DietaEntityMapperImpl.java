package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.DietaEntity;
import it.iccs.simeal.sdi.configurazione.application.model.DietaModel;
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
public class DietaEntityMapperImpl implements DietaEntityMapper {

    @Override
    public DietaModel fromEntityToModel(DietaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        DietaModel dietaModel = new DietaModel();

        dietaModel.setId( entity.getId() );
        dietaModel.setDescrizione( entity.getDescrizione() );
        dietaModel.setFlagElimina( entity.getFlagElimina() );

        return dietaModel;
    }

    @Override
    public List<DietaModel> fromEntitiesToModels(List<DietaEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<DietaModel> list = new ArrayList<DietaModel>( entityList.size() );
        for ( DietaEntity dietaEntity : entityList ) {
            list.add( fromEntityToModel( dietaEntity ) );
        }

        return list;
    }

    @Override
    public List<DietaEntity> fromModelsToEntities(List<DietaModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<DietaEntity> list = new ArrayList<DietaEntity>( modelList.size() );
        for ( DietaModel dietaModel : modelList ) {
            list.add( fromModelToEntity( dietaModel ) );
        }

        return list;
    }

    @Override
    public DietaEntity fromModelToEntity(DietaModel model) {
        if ( model == null ) {
            return null;
        }

        DietaEntity dietaEntity = new DietaEntity();

        if ( model.getFlagElimina() != null ) {
            dietaEntity.setFlagElimina( model.getFlagElimina() );
        }
        else {
            dietaEntity.setFlagElimina( (short) 0 );
        }
        dietaEntity.setId( model.getId() );
        dietaEntity.setDescrizione( model.getDescrizione() );

        return dietaEntity;
    }
}
