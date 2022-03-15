package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.CentroCotturaEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.CentroCotturaIstitutoEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.IstitutoEntity;
import it.iccs.simeal.sdi.configurazione.application.model.CentroCotturaIstitutoModel;
import it.iccs.simeal.sdi.configurazione.application.model.CentroCotturaModel;
import it.iccs.simeal.sdi.configurazione.application.model.IstitutoModel;
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
public class CentroCotturaIstitutoEntityMapperImpl implements CentroCotturaIstitutoEntityMapper {

    @Override
    public CentroCotturaIstitutoModel fromEntityToModel(CentroCotturaIstitutoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        CentroCotturaIstitutoModel centroCotturaIstitutoModel = new CentroCotturaIstitutoModel();

        centroCotturaIstitutoModel.setId( entity.getId() );
        centroCotturaIstitutoModel.setIstituto( istitutoEntityToIstitutoModel( entity.getIstituto() ) );
        centroCotturaIstitutoModel.setCentroCottura( centroCotturaEntityToCentroCotturaModel( entity.getCentroCottura() ) );
        centroCotturaIstitutoModel.setDataInizio( entity.getDataInizio() );
        centroCotturaIstitutoModel.setDataFine( entity.getDataFine() );

        return centroCotturaIstitutoModel;
    }

    @Override
    public List<CentroCotturaIstitutoModel> fromEntitiesToModels(List<CentroCotturaIstitutoEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CentroCotturaIstitutoModel> list = new ArrayList<CentroCotturaIstitutoModel>( entityList.size() );
        for ( CentroCotturaIstitutoEntity centroCotturaIstitutoEntity : entityList ) {
            list.add( fromEntityToModel( centroCotturaIstitutoEntity ) );
        }

        return list;
    }

    @Override
    public List<CentroCotturaIstitutoEntity> fromModelsToEntities(List<CentroCotturaIstitutoModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<CentroCotturaIstitutoEntity> list = new ArrayList<CentroCotturaIstitutoEntity>( modelList.size() );
        for ( CentroCotturaIstitutoModel centroCotturaIstitutoModel : modelList ) {
            list.add( fromModelToEntity( centroCotturaIstitutoModel ) );
        }

        return list;
    }

    @Override
    public CentroCotturaIstitutoEntity fromModelToEntity(CentroCotturaIstitutoModel model) {
        if ( model == null ) {
            return null;
        }

        CentroCotturaIstitutoEntity centroCotturaIstitutoEntity = new CentroCotturaIstitutoEntity();

        centroCotturaIstitutoEntity.setId( model.getId() );
        centroCotturaIstitutoEntity.setCentroCottura( centroCotturaModelToCentroCotturaEntity( model.getCentroCottura() ) );
        centroCotturaIstitutoEntity.setIstituto( istitutoModelToIstitutoEntity( model.getIstituto() ) );
        centroCotturaIstitutoEntity.setDataInizio( model.getDataInizio() );
        centroCotturaIstitutoEntity.setDataFine( model.getDataFine() );

        return centroCotturaIstitutoEntity;
    }

    protected IstitutoModel istitutoEntityToIstitutoModel(IstitutoEntity istitutoEntity) {
        if ( istitutoEntity == null ) {
            return null;
        }

        IstitutoModel istitutoModel = new IstitutoModel();

        istitutoModel.setId( istitutoEntity.getId() );
        istitutoModel.setIdEnte( istitutoEntity.getIdEnte() );
        istitutoModel.setDenominazione( istitutoEntity.getDenominazione() );
        istitutoModel.setPartitaIva( istitutoEntity.getPartitaIva() );
        istitutoModel.setIndirizzo( istitutoEntity.getIndirizzo() );
        istitutoModel.setIdStradario( istitutoEntity.getIdStradario() );
        istitutoModel.setCivico( istitutoEntity.getCivico() );
        istitutoModel.setNumeroClassi( istitutoEntity.getNumeroClassi() );
        istitutoModel.setNumeroAlunni( istitutoEntity.getNumeroAlunni() );
        istitutoModel.setReferente( istitutoEntity.getReferente() );
        istitutoModel.setTelefono( istitutoEntity.getTelefono() );
        istitutoModel.setFax( istitutoEntity.getFax() );
        istitutoModel.setEmail( istitutoEntity.getEmail() );
        istitutoModel.setIdTipologiaIstituto( istitutoEntity.getIdTipologiaIstituto() );
        istitutoModel.setDataInizio( istitutoEntity.getDataInizio() );
        istitutoModel.setDataFine( istitutoEntity.getDataFine() );
        istitutoModel.setMeccanograficoPlesso( istitutoEntity.getMeccanograficoPlesso() );
        istitutoModel.setMeccanograficoScuola( istitutoEntity.getMeccanograficoScuola() );
        istitutoModel.setLatitudine( istitutoEntity.getLatitudine() );
        istitutoModel.setLongitudine( istitutoEntity.getLongitudine() );
        istitutoModel.setFlagTipoIstituto( istitutoEntity.getFlagTipoIstituto() );
        istitutoModel.setFlagAnticipo( istitutoEntity.getFlagAnticipo() );
        istitutoModel.setFlagPosticipo( istitutoEntity.getFlagPosticipo() );
        istitutoModel.setFlagTempoProlungato( istitutoEntity.getFlagTempoProlungato() );
        istitutoModel.setSicraCodiceVia( istitutoEntity.getSicraCodiceVia() );
        istitutoModel.setSicraCivico( istitutoEntity.getSicraCivico() );
        istitutoModel.setCodiceEsterno( istitutoEntity.getCodiceEsterno() );
        istitutoModel.setFlagElimina( istitutoEntity.getFlagElimina() );

        return istitutoModel;
    }

    protected CentroCotturaModel centroCotturaEntityToCentroCotturaModel(CentroCotturaEntity centroCotturaEntity) {
        if ( centroCotturaEntity == null ) {
            return null;
        }

        CentroCotturaModel centroCotturaModel = new CentroCotturaModel();

        centroCotturaModel.setId( centroCotturaEntity.getId() );
        centroCotturaModel.setDenominazione( centroCotturaEntity.getDenominazione() );
        centroCotturaModel.setIndirizzo( centroCotturaEntity.getIndirizzo() );
        centroCotturaModel.setCivico( centroCotturaEntity.getCivico() );
        centroCotturaModel.setCitta( centroCotturaEntity.getCitta() );
        centroCotturaModel.setProvincia( centroCotturaEntity.getProvincia() );
        centroCotturaModel.setReferente( centroCotturaEntity.getReferente() );
        centroCotturaModel.setTelefono( centroCotturaEntity.getTelefono() );
        centroCotturaModel.setFax( centroCotturaEntity.getFax() );
        centroCotturaModel.setEmail( centroCotturaEntity.getEmail() );
        centroCotturaModel.setPec( centroCotturaEntity.getPec() );
        centroCotturaModel.setFlagElimina( centroCotturaEntity.getFlagElimina() );

        return centroCotturaModel;
    }

    protected CentroCotturaEntity centroCotturaModelToCentroCotturaEntity(CentroCotturaModel centroCotturaModel) {
        if ( centroCotturaModel == null ) {
            return null;
        }

        CentroCotturaEntity centroCotturaEntity = new CentroCotturaEntity();

        centroCotturaEntity.setId( centroCotturaModel.getId() );
        centroCotturaEntity.setDenominazione( centroCotturaModel.getDenominazione() );
        centroCotturaEntity.setIndirizzo( centroCotturaModel.getIndirizzo() );
        centroCotturaEntity.setCivico( centroCotturaModel.getCivico() );
        centroCotturaEntity.setCitta( centroCotturaModel.getCitta() );
        centroCotturaEntity.setProvincia( centroCotturaModel.getProvincia() );
        centroCotturaEntity.setReferente( centroCotturaModel.getReferente() );
        centroCotturaEntity.setTelefono( centroCotturaModel.getTelefono() );
        centroCotturaEntity.setFax( centroCotturaModel.getFax() );
        centroCotturaEntity.setEmail( centroCotturaModel.getEmail() );
        centroCotturaEntity.setPec( centroCotturaModel.getPec() );
        centroCotturaEntity.setFlagElimina( centroCotturaModel.getFlagElimina() );

        return centroCotturaEntity;
    }

    protected IstitutoEntity istitutoModelToIstitutoEntity(IstitutoModel istitutoModel) {
        if ( istitutoModel == null ) {
            return null;
        }

        IstitutoEntity istitutoEntity = new IstitutoEntity();

        istitutoEntity.setId( istitutoModel.getId() );
        istitutoEntity.setIdEnte( istitutoModel.getIdEnte() );
        istitutoEntity.setDenominazione( istitutoModel.getDenominazione() );
        istitutoEntity.setPartitaIva( istitutoModel.getPartitaIva() );
        istitutoEntity.setIndirizzo( istitutoModel.getIndirizzo() );
        istitutoEntity.setIdStradario( istitutoModel.getIdStradario() );
        istitutoEntity.setCivico( istitutoModel.getCivico() );
        istitutoEntity.setNumeroClassi( istitutoModel.getNumeroClassi() );
        istitutoEntity.setNumeroAlunni( istitutoModel.getNumeroAlunni() );
        istitutoEntity.setReferente( istitutoModel.getReferente() );
        istitutoEntity.setTelefono( istitutoModel.getTelefono() );
        istitutoEntity.setFax( istitutoModel.getFax() );
        istitutoEntity.setEmail( istitutoModel.getEmail() );
        istitutoEntity.setIdTipologiaIstituto( istitutoModel.getIdTipologiaIstituto() );
        istitutoEntity.setDataInizio( istitutoModel.getDataInizio() );
        istitutoEntity.setDataFine( istitutoModel.getDataFine() );
        istitutoEntity.setMeccanograficoPlesso( istitutoModel.getMeccanograficoPlesso() );
        istitutoEntity.setMeccanograficoScuola( istitutoModel.getMeccanograficoScuola() );
        istitutoEntity.setLatitudine( istitutoModel.getLatitudine() );
        istitutoEntity.setLongitudine( istitutoModel.getLongitudine() );
        istitutoEntity.setFlagTipoIstituto( istitutoModel.getFlagTipoIstituto() );
        istitutoEntity.setFlagAnticipo( istitutoModel.getFlagAnticipo() );
        istitutoEntity.setFlagPosticipo( istitutoModel.getFlagPosticipo() );
        istitutoEntity.setFlagTempoProlungato( istitutoModel.getFlagTempoProlungato() );
        istitutoEntity.setSicraCodiceVia( istitutoModel.getSicraCodiceVia() );
        istitutoEntity.setSicraCivico( istitutoModel.getSicraCivico() );
        istitutoEntity.setCodiceEsterno( istitutoModel.getCodiceEsterno() );
        istitutoEntity.setFlagElimina( istitutoModel.getFlagElimina() );

        return istitutoEntity;
    }
}
