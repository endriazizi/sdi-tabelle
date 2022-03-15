package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.IstitutoEntity;
import it.iccs.simeal.sdi.configurazione.application.model.IstitutoModel;
import java.util.ArrayList;
import java.util.List;
import javax.annotation.processing.Generated;
import org.springframework.stereotype.Component;

@Generated(
    value = "org.mapstruct.ap.MappingProcessor",
    date = "2022-03-15T20:02:42+0100",
    comments = "version: 1.4.2.Final, compiler: javac, environment: Java 17.0.2 (Oracle Corporation)"
)
@Component
public class IstitutoEntityMapperImpl implements IstitutoEntityMapper {

    @Override
    public IstitutoModel fromEntityToModel(IstitutoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        IstitutoModel istitutoModel = new IstitutoModel();

        istitutoModel.setId( entity.getId() );
        istitutoModel.setIdEnte( entity.getIdEnte() );
        istitutoModel.setDenominazione( entity.getDenominazione() );
        istitutoModel.setPartitaIva( entity.getPartitaIva() );
        istitutoModel.setIndirizzo( entity.getIndirizzo() );
        istitutoModel.setIdStradario( entity.getIdStradario() );
        istitutoModel.setCivico( entity.getCivico() );
        istitutoModel.setNumeroClassi( entity.getNumeroClassi() );
        istitutoModel.setNumeroAlunni( entity.getNumeroAlunni() );
        istitutoModel.setReferente( entity.getReferente() );
        istitutoModel.setTelefono( entity.getTelefono() );
        istitutoModel.setFax( entity.getFax() );
        istitutoModel.setEmail( entity.getEmail() );
        istitutoModel.setIdTipologiaIstituto( entity.getIdTipologiaIstituto() );
        istitutoModel.setDataInizio( entity.getDataInizio() );
        istitutoModel.setDataFine( entity.getDataFine() );
        istitutoModel.setMeccanograficoPlesso( entity.getMeccanograficoPlesso() );
        istitutoModel.setMeccanograficoScuola( entity.getMeccanograficoScuola() );
        istitutoModel.setLatitudine( entity.getLatitudine() );
        istitutoModel.setLongitudine( entity.getLongitudine() );
        istitutoModel.setFlagTipoIstituto( entity.getFlagTipoIstituto() );
        istitutoModel.setFlagAnticipo( entity.getFlagAnticipo() );
        istitutoModel.setFlagPosticipo( entity.getFlagPosticipo() );
        istitutoModel.setFlagTempoProlungato( entity.getFlagTempoProlungato() );
        istitutoModel.setSicraCodiceVia( entity.getSicraCodiceVia() );
        istitutoModel.setSicraCivico( entity.getSicraCivico() );
        istitutoModel.setCodiceEsterno( entity.getCodiceEsterno() );
        istitutoModel.setFlagElimina( entity.getFlagElimina() );

        return istitutoModel;
    }

    @Override
    public List<IstitutoModel> fromEntitiesToModels(List<IstitutoEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<IstitutoModel> list = new ArrayList<IstitutoModel>( entityList.size() );
        for ( IstitutoEntity istitutoEntity : entityList ) {
            list.add( fromEntityToModel( istitutoEntity ) );
        }

        return list;
    }

    @Override
    public List<IstitutoEntity> fromModelsToEntities(List<IstitutoModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<IstitutoEntity> list = new ArrayList<IstitutoEntity>( modelList.size() );
        for ( IstitutoModel istitutoModel : modelList ) {
            list.add( fromModelToEntity( istitutoModel ) );
        }

        return list;
    }

    @Override
    public IstitutoEntity fromModelToEntity(IstitutoModel model) {
        if ( model == null ) {
            return null;
        }

        IstitutoEntity istitutoEntity = new IstitutoEntity();

        if ( model.getSicraCodiceVia() != null ) {
            istitutoEntity.setSicraCodiceVia( model.getSicraCodiceVia() );
        }
        else {
            istitutoEntity.setSicraCodiceVia( 1 );
        }
        if ( model.getFlagElimina() != null ) {
            istitutoEntity.setFlagElimina( model.getFlagElimina() );
        }
        else {
            istitutoEntity.setFlagElimina( (short) 0 );
        }
        istitutoEntity.setId( model.getId() );
        istitutoEntity.setIdEnte( model.getIdEnte() );
        istitutoEntity.setDenominazione( model.getDenominazione() );
        istitutoEntity.setPartitaIva( model.getPartitaIva() );
        istitutoEntity.setIndirizzo( model.getIndirizzo() );
        istitutoEntity.setIdStradario( model.getIdStradario() );
        istitutoEntity.setCivico( model.getCivico() );
        istitutoEntity.setNumeroClassi( model.getNumeroClassi() );
        istitutoEntity.setNumeroAlunni( model.getNumeroAlunni() );
        istitutoEntity.setReferente( model.getReferente() );
        istitutoEntity.setTelefono( model.getTelefono() );
        istitutoEntity.setFax( model.getFax() );
        istitutoEntity.setEmail( model.getEmail() );
        istitutoEntity.setIdTipologiaIstituto( model.getIdTipologiaIstituto() );
        istitutoEntity.setDataInizio( model.getDataInizio() );
        istitutoEntity.setDataFine( model.getDataFine() );
        istitutoEntity.setMeccanograficoPlesso( model.getMeccanograficoPlesso() );
        istitutoEntity.setMeccanograficoScuola( model.getMeccanograficoScuola() );
        istitutoEntity.setLatitudine( model.getLatitudine() );
        istitutoEntity.setLongitudine( model.getLongitudine() );
        istitutoEntity.setFlagTipoIstituto( model.getFlagTipoIstituto() );
        istitutoEntity.setFlagAnticipo( model.getFlagAnticipo() );
        istitutoEntity.setFlagPosticipo( model.getFlagPosticipo() );
        istitutoEntity.setFlagTempoProlungato( model.getFlagTempoProlungato() );
        istitutoEntity.setSicraCivico( model.getSicraCivico() );
        istitutoEntity.setCodiceEsterno( model.getCodiceEsterno() );

        return istitutoEntity;
    }
}
