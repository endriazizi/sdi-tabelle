package it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.mapper;

import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ClasseComposizioneAnnoEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ClasseComposizioneEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.ClasseEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.IstitutoEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.RefettorioEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.SezioneEntity;
import it.iccs.simeal.sdi.configurazione.adapter.outbound.persistence.repository.entity.TurnoEntity;
import it.iccs.simeal.sdi.configurazione.application.model.ClasseComposizioneAnnoModel;
import it.iccs.simeal.sdi.configurazione.application.model.ClasseComposizioneModel;
import it.iccs.simeal.sdi.configurazione.application.model.ClasseModel;
import it.iccs.simeal.sdi.configurazione.application.model.IstitutoModel;
import it.iccs.simeal.sdi.configurazione.application.model.RefettorioModel;
import it.iccs.simeal.sdi.configurazione.application.model.SezioneModel;
import it.iccs.simeal.sdi.configurazione.application.model.TurnoModel;
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
public class ClasseComposizioneAnnoEntityMapperImpl implements ClasseComposizioneAnnoEntityMapper {

    @Override
    public ClasseComposizioneAnnoModel fromEntityToModel(ClasseComposizioneAnnoEntity entity) {
        if ( entity == null ) {
            return null;
        }

        ClasseComposizioneAnnoModel classeComposizioneAnnoModel = new ClasseComposizioneAnnoModel();

        classeComposizioneAnnoModel.setId( entity.getId() );
        classeComposizioneAnnoModel.setAnno( entity.getAnno() );
        classeComposizioneAnnoModel.setTurno( turnoEntityToTurnoModel( entity.getTurno() ) );
        classeComposizioneAnnoModel.setRefettorio( refettorioEntityToRefettorioModel( entity.getRefettorio() ) );
        classeComposizioneAnnoModel.setFlagVisibile( entity.getFlagVisibile() );
        classeComposizioneAnnoModel.setClasseComposizione( classeComposizioneEntityToClasseComposizioneModel( entity.getClasseComposizione() ) );

        return classeComposizioneAnnoModel;
    }

    @Override
    public List<ClasseComposizioneAnnoModel> fromEntitiesToModels(List<ClasseComposizioneAnnoEntity> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ClasseComposizioneAnnoModel> list = new ArrayList<ClasseComposizioneAnnoModel>( entityList.size() );
        for ( ClasseComposizioneAnnoEntity classeComposizioneAnnoEntity : entityList ) {
            list.add( fromEntityToModel( classeComposizioneAnnoEntity ) );
        }

        return list;
    }

    @Override
    public List<ClasseComposizioneAnnoEntity> fromModelsToEntities(List<ClasseComposizioneAnnoModel> modelList) {
        if ( modelList == null ) {
            return null;
        }

        List<ClasseComposizioneAnnoEntity> list = new ArrayList<ClasseComposizioneAnnoEntity>( modelList.size() );
        for ( ClasseComposizioneAnnoModel classeComposizioneAnnoModel : modelList ) {
            list.add( fromModelToEntity( classeComposizioneAnnoModel ) );
        }

        return list;
    }

    @Override
    public ClasseComposizioneAnnoEntity fromModelToEntity(ClasseComposizioneAnnoModel model) {
        if ( model == null ) {
            return null;
        }

        ClasseComposizioneAnnoEntity classeComposizioneAnnoEntity = new ClasseComposizioneAnnoEntity();

        if ( model.getFlagVisibile() != null ) {
            classeComposizioneAnnoEntity.setFlagVisibile( model.getFlagVisibile() );
        }
        else {
            classeComposizioneAnnoEntity.setFlagVisibile( (short) 1 );
        }
        classeComposizioneAnnoEntity.setId( model.getId() );
        classeComposizioneAnnoEntity.setAnno( model.getAnno() );
        classeComposizioneAnnoEntity.setTurno( turnoModelToTurnoEntity( model.getTurno() ) );
        classeComposizioneAnnoEntity.setRefettorio( refettorioModelToRefettorioEntity( model.getRefettorio() ) );
        classeComposizioneAnnoEntity.setClasseComposizione( classeComposizioneModelToClasseComposizioneEntity( model.getClasseComposizione() ) );

        return classeComposizioneAnnoEntity;
    }

    protected TurnoModel turnoEntityToTurnoModel(TurnoEntity turnoEntity) {
        if ( turnoEntity == null ) {
            return null;
        }

        TurnoModel turnoModel = new TurnoModel();

        turnoModel.setId( turnoEntity.getId() );
        turnoModel.setDescrizione( turnoEntity.getDescrizione() );
        turnoModel.setFlagElimina( turnoEntity.getFlagElimina() );

        return turnoModel;
    }

    protected RefettorioModel refettorioEntityToRefettorioModel(RefettorioEntity refettorioEntity) {
        if ( refettorioEntity == null ) {
            return null;
        }

        RefettorioModel refettorioModel = new RefettorioModel();

        refettorioModel.setId( refettorioEntity.getId() );
        refettorioModel.setIdEnte( refettorioEntity.getIdEnte() );
        refettorioModel.setDescrizione( refettorioEntity.getDescrizione() );
        refettorioModel.setFlagElimina( refettorioEntity.getFlagElimina() );

        return refettorioModel;
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

    protected ClasseComposizioneModel classeComposizioneEntityToClasseComposizioneModel(ClasseComposizioneEntity classeComposizioneEntity) {
        if ( classeComposizioneEntity == null ) {
            return null;
        }

        ClasseComposizioneModel classeComposizioneModel = new ClasseComposizioneModel();

        classeComposizioneModel.setId( classeComposizioneEntity.getId() );
        classeComposizioneModel.setIdEnte( classeComposizioneEntity.getIdEnte() );
        classeComposizioneModel.setIstituto( istitutoEntityToIstitutoModel( classeComposizioneEntity.getIstituto() ) );
        classeComposizioneModel.setClasse( classeEntityToClasseModel( classeComposizioneEntity.getClasse() ) );
        classeComposizioneModel.setSezione( sezioneEntityToSezioneModel( classeComposizioneEntity.getSezione() ) );
        classeComposizioneModel.setIstitutoSuccessiva( istitutoEntityToIstitutoModel( classeComposizioneEntity.getIstitutoSuccessiva() ) );
        classeComposizioneModel.setClasseSuccessiva( classeEntityToClasseModel( classeComposizioneEntity.getClasseSuccessiva() ) );
        classeComposizioneModel.setSezioneSuccessiva( sezioneEntityToSezioneModel( classeComposizioneEntity.getSezioneSuccessiva() ) );
        classeComposizioneModel.setFlagElimina( classeComposizioneEntity.getFlagElimina() );

        return classeComposizioneModel;
    }

    protected TurnoEntity turnoModelToTurnoEntity(TurnoModel turnoModel) {
        if ( turnoModel == null ) {
            return null;
        }

        TurnoEntity turnoEntity = new TurnoEntity();

        turnoEntity.setId( turnoModel.getId() );
        turnoEntity.setDescrizione( turnoModel.getDescrizione() );
        turnoEntity.setFlagElimina( turnoModel.getFlagElimina() );

        return turnoEntity;
    }

    protected RefettorioEntity refettorioModelToRefettorioEntity(RefettorioModel refettorioModel) {
        if ( refettorioModel == null ) {
            return null;
        }

        RefettorioEntity refettorioEntity = new RefettorioEntity();

        refettorioEntity.setId( refettorioModel.getId() );
        refettorioEntity.setIdEnte( refettorioModel.getIdEnte() );
        refettorioEntity.setDescrizione( refettorioModel.getDescrizione() );
        refettorioEntity.setFlagElimina( refettorioModel.getFlagElimina() );

        return refettorioEntity;
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

    protected ClasseComposizioneEntity classeComposizioneModelToClasseComposizioneEntity(ClasseComposizioneModel classeComposizioneModel) {
        if ( classeComposizioneModel == null ) {
            return null;
        }

        ClasseComposizioneEntity classeComposizioneEntity = new ClasseComposizioneEntity();

        classeComposizioneEntity.setId( classeComposizioneModel.getId() );
        classeComposizioneEntity.setIdEnte( classeComposizioneModel.getIdEnte() );
        classeComposizioneEntity.setIstituto( istitutoModelToIstitutoEntity( classeComposizioneModel.getIstituto() ) );
        classeComposizioneEntity.setClasse( classeModelToClasseEntity( classeComposizioneModel.getClasse() ) );
        classeComposizioneEntity.setSezione( sezioneModelToSezioneEntity( classeComposizioneModel.getSezione() ) );
        classeComposizioneEntity.setIstitutoSuccessiva( istitutoModelToIstitutoEntity( classeComposizioneModel.getIstitutoSuccessiva() ) );
        classeComposizioneEntity.setClasseSuccessiva( classeModelToClasseEntity( classeComposizioneModel.getClasseSuccessiva() ) );
        classeComposizioneEntity.setSezioneSuccessiva( sezioneModelToSezioneEntity( classeComposizioneModel.getSezioneSuccessiva() ) );
        classeComposizioneEntity.setFlagElimina( classeComposizioneModel.getFlagElimina() );

        return classeComposizioneEntity;
    }
}
