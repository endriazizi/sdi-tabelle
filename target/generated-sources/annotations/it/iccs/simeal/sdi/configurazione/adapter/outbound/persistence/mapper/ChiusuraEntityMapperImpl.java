package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ChiusuraEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ClasseEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.IstitutoEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ServizioEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.SezioneEntity;
import it.iccs.simeal.sdi.configurazione.application.model.ChiusuraModel;
import it.iccs.simeal.sdi.configurazione.application.model.ClasseModel;
import it.iccs.simeal.sdi.configurazione.application.model.IstitutoModel;
import it.iccs.simeal.sdi.configurazione.application.model.ServizioModel;
import it.iccs.simeal.sdi.configurazione.application.model.SezioneModel;
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
public class ChiusuraEntityMapperImpl implements ChiusuraEntityMapper {

    @Override
    public ChiusuraModel fromEntityToModel(ChiusuraEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ChiusuraModel chiusuraModel = new ChiusuraModel();

        chiusuraModel.setId( entity.getId() );
        chiusuraModel.setAnno( entity.getAnno() );
        chiusuraModel.setIstituto( istitutoEntityToIstitutoModel( entity.getIstituto() ) );
        chiusuraModel.setClasse( classeEntityToClasseModel( entity.getClasse() ) );
        chiusuraModel.setSezione( sezioneEntityToSezioneModel( entity.getSezione() ) );
        chiusuraModel.setServizio( servizioEntityToServizioModel( entity.getServizio() ) );
        chiusuraModel.setDescrizione( entity.getDescrizione() );
        chiusuraModel.setDataInizio( entity.getDataInizio() );
        chiusuraModel.setDataFine( entity.getDataFine() );
        chiusuraModel.setFlagElimina( entity.getFlagElimina() );

        return chiusuraModel;
    }

    @Override
    public List<ChiusuraModel> fromEntitiesToModels(List<ChiusuraEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ChiusuraModel> list = new ArrayList<ChiusuraModel>( entityList.size() );
        for ( ChiusuraEntity chiusuraEntity : entityList ) {
            list.add( fromEntityToModel( chiusuraEntity ) );
        }

        return list;
    }

    @Override
    public List<ChiusuraEntity> fromModelsToEntities(List<ChiusuraModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<ChiusuraEntity> list = new ArrayList<ChiusuraEntity>( modelList.size() );
        for ( ChiusuraModel chiusuraModel : modelList ) {
            list.add( fromModelToEntity( chiusuraModel ) );
        }

        return list;
    }

    @Override
    public ChiusuraEntity fromModelToEntity(ChiusuraModel model) {
        if ( model == null ) {
            return null;
        }

        ChiusuraEntity chiusuraEntity = new ChiusuraEntity();

        if ( model.getFlagElimina() != null ) {
            chiusuraEntity.setFlagElimina( model.getFlagElimina() );
        }
        else {
            chiusuraEntity.setFlagElimina( (short) 0 );
        }
        chiusuraEntity.setId( model.getId() );
        chiusuraEntity.setAnno( model.getAnno() );
        chiusuraEntity.setServizio( servizioModelToServizioEntity( model.getServizio() ) );
        chiusuraEntity.setIstituto( istitutoModelToIstitutoEntity( model.getIstituto() ) );
        chiusuraEntity.setClasse( classeModelToClasseEntity( model.getClasse() ) );
        chiusuraEntity.setSezione( sezioneModelToSezioneEntity( model.getSezione() ) );
        chiusuraEntity.setDescrizione( model.getDescrizione() );
        chiusuraEntity.setDataInizio( model.getDataInizio() );
        chiusuraEntity.setDataFine( model.getDataFine() );

        return chiusuraEntity;
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

    protected ClasseModel classeEntityToClasseModel(ClasseEntity classeEntity) {
        if ( classeEntity == null ) {
            return null;
        }

        ClasseModel classeModel = new ClasseModel();

        classeModel.setId( classeEntity.getId() );
        classeModel.setDescrizione( classeEntity.getDescrizione() );
        classeModel.setFlagElimina( classeEntity.getFlagElimina() );

        return classeModel;
    }

    protected SezioneModel sezioneEntityToSezioneModel(SezioneEntity sezioneEntity) {
        if ( sezioneEntity == null ) {
            return null;
        }

        SezioneModel sezioneModel = new SezioneModel();

        sezioneModel.setId( sezioneEntity.getId() );
        sezioneModel.setDescrizione( sezioneEntity.getDescrizione() );
        sezioneModel.setFlagElimina( sezioneEntity.getFlagElimina() );

        return sezioneModel;
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

    protected ClasseEntity classeModelToClasseEntity(ClasseModel classeModel) {
        if ( classeModel == null ) {
            return null;
        }

        ClasseEntity classeEntity = new ClasseEntity();

        classeEntity.setId( classeModel.getId() );
        classeEntity.setDescrizione( classeModel.getDescrizione() );
        classeEntity.setFlagElimina( classeModel.getFlagElimina() );

        return classeEntity;
    }

    protected SezioneEntity sezioneModelToSezioneEntity(SezioneModel sezioneModel) {
        if ( sezioneModel == null ) {
            return null;
        }

        SezioneEntity sezioneEntity = new SezioneEntity();

        sezioneEntity.setId( sezioneModel.getId() );
        sezioneEntity.setDescrizione( sezioneModel.getDescrizione() );
        sezioneEntity.setFlagElimina( sezioneModel.getFlagElimina() );

        return sezioneEntity;
    }
}
