package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ClasseEntity;
import it.iccs.simeal.sdi.configurazione.application.model.ClasseModel;
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
public class ClasseEntityMapperImpl implements ClasseEntityMapper {

    @Override
    public ClasseModel fromEntityToModel(ClasseEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ClasseModel classeModel = new ClasseModel();

        classeModel.setId( entity.getId() );
        classeModel.setDescrizione( entity.getDescrizione() );
        classeModel.setFlagElimina( entity.getFlagElimina() );

        return classeModel;
    }

    @Override
    public List<ClasseModel> fromEntitiesToModels(List<ClasseEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ClasseModel> list = new ArrayList<ClasseModel>( entityList.size() );
        for ( ClasseEntity classeEntity : entityList ) {
            list.add( fromEntityToModel( classeEntity ) );
        }

        return list;
    }

    @Override
    public List<ClasseEntity> fromModelsToEntities(List<ClasseModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<ClasseEntity> list = new ArrayList<ClasseEntity>( modelList.size() );
        for ( ClasseModel classeModel : modelList ) {
            list.add( fromModelToEntity( classeModel ) );
        }

        return list;
    }

    @Override
    public ClasseEntity fromModelToEntity(ClasseModel model) {
        if ( model == null ) {
            return null;
        }

        ClasseEntity classeEntity = new ClasseEntity();

        if ( model.getFlagElimina() != null ) {
            classeEntity.setFlagElimina( model.getFlagElimina() );
        }
        else {
            classeEntity.setFlagElimina( (short) 0 );
        }
        classeEntity.setId( model.getId() );
        classeEntity.setDescrizione( model.getDescrizione() );

        return classeEntity;
    }
}
