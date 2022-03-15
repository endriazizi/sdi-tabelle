package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.CentroCotturaEntity;
import it.iccs.simeal.sdi.configurazione.application.model.CentroCotturaModel;
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
public class CentroCotturaEntityMapperImpl implements CentroCotturaEntityMapper {

    @Override
    public CentroCotturaModel fromEntityToModel(CentroCotturaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CentroCotturaModel centroCotturaModel = new CentroCotturaModel();

        centroCotturaModel.setId( entity.getId() );
        centroCotturaModel.setDenominazione( entity.getDenominazione() );
        centroCotturaModel.setIndirizzo( entity.getIndirizzo() );
        centroCotturaModel.setCivico( entity.getCivico() );
        centroCotturaModel.setCitta( entity.getCitta() );
        centroCotturaModel.setProvincia( entity.getProvincia() );
        centroCotturaModel.setReferente( entity.getReferente() );
        centroCotturaModel.setTelefono( entity.getTelefono() );
        centroCotturaModel.setFax( entity.getFax() );
        centroCotturaModel.setEmail( entity.getEmail() );
        centroCotturaModel.setPec( entity.getPec() );
        centroCotturaModel.setFlagElimina( entity.getFlagElimina() );

        return centroCotturaModel;
    }

    @Override
    public List<CentroCotturaModel> fromEntitiesToModels(List<CentroCotturaEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CentroCotturaModel> list = new ArrayList<CentroCotturaModel>( entityList.size() );
        for ( CentroCotturaEntity centroCotturaEntity : entityList ) {
            list.add( fromEntityToModel( centroCotturaEntity ) );
        }

        return list;
    }

    @Override
    public List<CentroCotturaEntity> fromModelsToEntities(List<CentroCotturaModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<CentroCotturaEntity> list = new ArrayList<CentroCotturaEntity>( modelList.size() );
        for ( CentroCotturaModel centroCotturaModel : modelList ) {
            list.add( fromModelToEntity( centroCotturaModel ) );
        }

        return list;
    }

    @Override
    public CentroCotturaEntity fromModelToEntity(CentroCotturaModel model) {
        if ( model == null ) {
            return null;
        }

        CentroCotturaEntity centroCotturaEntity = new CentroCotturaEntity();

        if ( model.getFlagElimina() != null ) {
            centroCotturaEntity.setFlagElimina( model.getFlagElimina() );
        }
        else {
            centroCotturaEntity.setFlagElimina( (short) 0 );
        }
        centroCotturaEntity.setId( model.getId() );
        centroCotturaEntity.setDenominazione( model.getDenominazione() );
        centroCotturaEntity.setIndirizzo( model.getIndirizzo() );
        centroCotturaEntity.setCivico( model.getCivico() );
        centroCotturaEntity.setCitta( model.getCitta() );
        centroCotturaEntity.setProvincia( model.getProvincia() );
        centroCotturaEntity.setReferente( model.getReferente() );
        centroCotturaEntity.setTelefono( model.getTelefono() );
        centroCotturaEntity.setFax( model.getFax() );
        centroCotturaEntity.setEmail( model.getEmail() );
        centroCotturaEntity.setPec( model.getPec() );

        return centroCotturaEntity;
    }
}
