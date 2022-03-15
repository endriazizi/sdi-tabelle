package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ClasseComposizioneEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ClasseEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.IstitutoEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.SezioneEntity;
import it.iccs.simeal.sdi.configurazione.application.model.ClasseComposizioneModel;
import it.iccs.simeal.sdi.configurazione.application.model.ClasseModel;
import it.iccs.simeal.sdi.configurazione.application.model.IstitutoModel;
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
public class ClasseComposizioneEntityMapperImpl implements ClasseComposizioneEntityMapper {

    @Override
    public ClasseComposizioneModel fromEntityToModel(ClasseComposizioneEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ClasseComposizioneModel classeComposizioneModel = new ClasseComposizioneModel();

        classeComposizioneModel.setId( entity.getId() );
        classeComposizioneModel.setIdEnte( entity.getIdEnte() );
        classeComposizioneModel.setIstituto( istitutoEntityToIstitutoModel( entity.getIstituto() ) );
        classeComposizioneModel.setClasse( classeEntityToClasseModel( entity.getClasse() ) );
        classeComposizioneModel.setSezione( sezioneEntityToSezioneModel( entity.getSezione() ) );
        classeComposizioneModel.setIstitutoSuccessiva( istitutoEntityToIstitutoModel( entity.getIstitutoSuccessiva() ) );
        classeComposizioneModel.setClasseSuccessiva( classeEntityToClasseModel( entity.getClasseSuccessiva() ) );
        classeComposizioneModel.setSezioneSuccessiva( sezioneEntityToSezioneModel( entity.getSezioneSuccessiva() ) );
        classeComposizioneModel.setFlagElimina( entity.getFlagElimina() );

        return classeComposizioneModel;
    }

    @Override
    public List<ClasseComposizioneModel> fromEntitiesToModels(List<ClasseComposizioneEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ClasseComposizioneModel> list = new ArrayList<ClasseComposizioneModel>( entityList.size() );
        for ( ClasseComposizioneEntity classeComposizioneEntity : entityList ) {
            list.add( fromEntityToModel( classeComposizioneEntity ) );
        }

        return list;
    }

    @Override
    public List<ClasseComposizioneEntity> fromModelsToEntities(List<ClasseComposizioneModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<ClasseComposizioneEntity> list = new ArrayList<ClasseComposizioneEntity>( modelList.size() );
        for ( ClasseComposizioneModel classeComposizioneModel : modelList ) {
            list.add( fromModelToEntity( classeComposizioneModel ) );
        }

        return list;
    }

    @Override
    public ClasseComposizioneEntity fromModelToEntity(ClasseComposizioneModel model) {
        if ( model == null ) {
            return null;
        }

        ClasseComposizioneEntity classeComposizioneEntity = new ClasseComposizioneEntity();

        if ( model.getFlagElimina() != null ) {
            classeComposizioneEntity.setFlagElimina( model.getFlagElimina() );
        }
        else {
            classeComposizioneEntity.setFlagElimina( (short) 0 );
        }
        classeComposizioneEntity.setId( model.getId() );
        classeComposizioneEntity.setIdEnte( model.getIdEnte() );
        classeComposizioneEntity.setIstituto( istitutoModelToIstitutoEntity( model.getIstituto() ) );
        classeComposizioneEntity.setClasse( classeModelToClasseEntity( model.getClasse() ) );
        classeComposizioneEntity.setSezione( sezioneModelToSezioneEntity( model.getSezione() ) );
        classeComposizioneEntity.setIstitutoSuccessiva( istitutoModelToIstitutoEntity( model.getIstitutoSuccessiva() ) );
        classeComposizioneEntity.setClasseSuccessiva( classeModelToClasseEntity( model.getClasseSuccessiva() ) );
        classeComposizioneEntity.setSezioneSuccessiva( sezioneModelToSezioneEntity( model.getSezioneSuccessiva() ) );

        return classeComposizioneEntity;
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
