package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.PastoAlternativoEntity;
import it.iccs.simeal.sdi.configurazione.application.model.PastoAlternativoModel;
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
public class PastoAlternativoEntityMapperImpl implements PastoAlternativoEntityMapper {

    @Override
    public PastoAlternativoModel fromEntityToModel(PastoAlternativoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        PastoAlternativoModel pastoAlternativoModel = new PastoAlternativoModel();

        pastoAlternativoModel.setId( entity.getId() );
        pastoAlternativoModel.setDescrizione( entity.getDescrizione() );
        pastoAlternativoModel.setFlagAbilitato( entity.getFlagAbilitato() );
        pastoAlternativoModel.setOrdinePasto( entity.getOrdinePasto() );

        return pastoAlternativoModel;
    }

    @Override
    public List<PastoAlternativoModel> fromEntitiesToModels(List<PastoAlternativoEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PastoAlternativoModel> list = new ArrayList<PastoAlternativoModel>( entityList.size() );
        for ( PastoAlternativoEntity pastoAlternativoEntity : entityList ) {
            list.add( fromEntityToModel( pastoAlternativoEntity ) );
        }

        return list;
    }

    @Override
    public List<PastoAlternativoEntity> fromModelsToEntities(List<PastoAlternativoModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<PastoAlternativoEntity> list = new ArrayList<PastoAlternativoEntity>( modelList.size() );
        for ( PastoAlternativoModel pastoAlternativoModel : modelList ) {
            list.add( fromModelToEntity( pastoAlternativoModel ) );
        }

        return list;
    }

    @Override
    public PastoAlternativoEntity fromModelToEntity(PastoAlternativoModel model) {
        if ( model == null ) {
            return null;
        }

        PastoAlternativoEntity pastoAlternativoEntity = new PastoAlternativoEntity();

        if ( model.getFlagAbilitato() != null ) {
            pastoAlternativoEntity.setFlagAbilitato( model.getFlagAbilitato() );
        }
        else {
            pastoAlternativoEntity.setFlagAbilitato( (short) 1 );
        }
        pastoAlternativoEntity.setId( model.getId() );
        pastoAlternativoEntity.setDescrizione( model.getDescrizione() );
        pastoAlternativoEntity.setOrdinePasto( model.getOrdinePasto() );

        return pastoAlternativoEntity;
    }
}
