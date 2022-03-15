package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.AperturaEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ClasseEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.IstitutoEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ServizioEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.SezioneEntity;
import it.iccs.simeal.sdi.configurazione.application.model.AperturaModel;
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
public class AperturaEntityMapperImpl implements AperturaEntityMapper {

    @Override
    public AperturaModel fromEntityToModel(AperturaEntity entity) {
        if ( entity == null ) {
            return null;
        }

        AperturaModel aperturaModel = new AperturaModel();

        aperturaModel.setId( entity.getId() );
        aperturaModel.setAnno( entity.getAnno() );
        aperturaModel.setIstituto( istitutoEntityToIstitutoModel( entity.getIstituto() ) );
        aperturaModel.setClasse( classeEntityToClasseModel( entity.getClasse() ) );
        aperturaModel.setSezione( sezioneEntityToSezioneModel( entity.getSezione() ) );
        aperturaModel.setServizio( servizioEntityToServizioModel( entity.getServizio() ) );
        aperturaModel.setDescrizione( entity.getDescrizione() );
        aperturaModel.setDataInizio( entity.getDataInizio() );
        aperturaModel.setDataFine( entity.getDataFine() );
        aperturaModel.setFlagElimina( entity.getFlagElimina() );

        return aperturaModel;
    }

    @Override
    public List<AperturaModel> fromEntitiesToModels(List<AperturaEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AperturaModel> list = new ArrayList<AperturaModel>( entityList.size() );
        for ( AperturaEntity aperturaEntity : entityList ) {
            list.add( fromEntityToModel( aperturaEntity ) );
        }

        return list;
    }

    @Override
    public List<AperturaEntity> fromModelsToEntities(List<AperturaModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<AperturaEntity> list = new ArrayList<AperturaEntity>( modelList.size() );
        for ( AperturaModel aperturaModel : modelList ) {
            list.add( fromModelToEntity( aperturaModel ) );
        }

        return list;
    }

    @Override
    public AperturaEntity fromModelToEntity(AperturaModel model) {
        if ( model == null ) {
            return null;
        }

        AperturaEntity aperturaEntity = new AperturaEntity();

        if ( model.getFlagElimina() != null ) {
            aperturaEntity.setFlagElimina( model.getFlagElimina() );
        }
        else {
            aperturaEntity.setFlagElimina( (short) 0 );
        }
        aperturaEntity.setId( model.getId() );
        aperturaEntity.setAnno( model.getAnno() );
        aperturaEntity.setServizio( servizioModelToServizioEntity( model.getServizio() ) );
        aperturaEntity.setIstituto( istitutoModelToIstitutoEntity( model.getIstituto() ) );
        aperturaEntity.setClasse( classeModelToClasseEntity( model.getClasse() ) );
        aperturaEntity.setSezione( sezioneModelToSezioneEntity( model.getSezione() ) );
        aperturaEntity.setDescrizione( model.getDescrizione() );
        aperturaEntity.setDataInizio( model.getDataInizio() );
        aperturaEntity.setDataFine( model.getDataFine() );

        return aperturaEntity;
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
