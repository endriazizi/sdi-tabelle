package it.iccs.simeal.sdi.configurazione.application.mapper;

import it.iccs.simeal.sdi.configurazione.application.model.ClasseComposizioneAnnoModel;
import it.iccs.simeal.sdi.configurazione.application.model.ClasseComposizioneModel;
import it.iccs.simeal.sdi.configurazione.application.model.ClasseModel;
import it.iccs.simeal.sdi.configurazione.application.model.GiroModel;
import it.iccs.simeal.sdi.configurazione.application.model.IstitutoModel;
import it.iccs.simeal.sdi.configurazione.application.model.RefettorioModel;
import it.iccs.simeal.sdi.configurazione.application.model.SezioneModel;
import it.iccs.simeal.sdi.configurazione.application.model.TurnoModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AbstractClasseComposizioneAnnoDTO.ClasseComposizioneInnerDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AbstractClasseComposizioneAnnoDTO.RefettorioInnerDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AbstractClasseComposizioneAnnoDTO.TurnoInnerDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneAnnoCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneAnnoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneAnnoUpdateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.GiroDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.IstitutoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.RefettorioDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.SezioneDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.TurnoDTO;
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
public class ClasseComposizioneAnnoModelMapperImpl implements ClasseComposizioneAnnoModelMapper {

    @Override
    public ClasseComposizioneAnnoModel toModel(ClasseComposizioneAnnoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ClasseComposizioneAnnoModel classeComposizioneAnnoModel = new ClasseComposizioneAnnoModel();

        classeComposizioneAnnoModel.setId( dto.getId() );
        classeComposizioneAnnoModel.setAnno( dto.getAnno() );
        classeComposizioneAnnoModel.setTurno( turnoDTOToTurnoModel( dto.getTurno() ) );
        classeComposizioneAnnoModel.setRefettorio( refettorioDTOToRefettorioModel( dto.getRefettorio() ) );
        classeComposizioneAnnoModel.setFlagVisibile( dto.getFlagVisibile() );
        classeComposizioneAnnoModel.setClasseComposizione( classeComposizioneDTOToClasseComposizioneModel( dto.getClasseComposizione() ) );

        return classeComposizioneAnnoModel;
    }

    @Override
    public ClasseComposizioneAnnoDTO toDto(ClasseComposizioneAnnoModel entity) {
        if ( entity == null ) {
            return null;
        }

        ClasseComposizioneAnnoDTO classeComposizioneAnnoDTO = new ClasseComposizioneAnnoDTO();

        classeComposizioneAnnoDTO.setId( entity.getId() );
        classeComposizioneAnnoDTO.setAnno( entity.getAnno() );
        classeComposizioneAnnoDTO.setTurno( turnoModelToTurnoDTO( entity.getTurno() ) );
        classeComposizioneAnnoDTO.setRefettorio( refettorioModelToRefettorioDTO( entity.getRefettorio() ) );
        classeComposizioneAnnoDTO.setFlagVisibile( entity.getFlagVisibile() );
        classeComposizioneAnnoDTO.setClasseComposizione( classeComposizioneModelToClasseComposizioneDTO( entity.getClasseComposizione() ) );

        return classeComposizioneAnnoDTO;
    }

    @Override
    public List<ClasseComposizioneAnnoModel> toModel(List<ClasseComposizioneAnnoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ClasseComposizioneAnnoModel> list = new ArrayList<ClasseComposizioneAnnoModel>( dtoList.size() );
        for ( ClasseComposizioneAnnoDTO classeComposizioneAnnoDTO : dtoList ) {
            list.add( toModel( classeComposizioneAnnoDTO ) );
        }

        return list;
    }

    @Override
    public List<ClasseComposizioneAnnoDTO> toDto(List<ClasseComposizioneAnnoModel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ClasseComposizioneAnnoDTO> list = new ArrayList<ClasseComposizioneAnnoDTO>( entityList.size() );
        for ( ClasseComposizioneAnnoModel classeComposizioneAnnoModel : entityList ) {
            list.add( toDto( classeComposizioneAnnoModel ) );
        }

        return list;
    }

    @Override
    public ClasseComposizioneAnnoDTO fromCreateDto(ClasseComposizioneAnnoCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ClasseComposizioneAnnoDTO classeComposizioneAnnoDTO = new ClasseComposizioneAnnoDTO();

        classeComposizioneAnnoDTO.setAnno( dto.getAnno() );
        classeComposizioneAnnoDTO.setTurno( turnoInnerDTOToTurnoDTO( dto.getTurno() ) );
        classeComposizioneAnnoDTO.setRefettorio( refettorioInnerDTOToRefettorioDTO( dto.getRefettorio() ) );
        classeComposizioneAnnoDTO.setClasseComposizione( classeComposizioneInnerDTOToClasseComposizioneDTO( dto.getClasseComposizione() ) );

        return classeComposizioneAnnoDTO;
    }

    @Override
    public ClasseComposizioneAnnoDTO fromUpdateDto(ClasseComposizioneAnnoUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ClasseComposizioneAnnoDTO classeComposizioneAnnoDTO = new ClasseComposizioneAnnoDTO();

        classeComposizioneAnnoDTO.setId( dto.getId() );
        classeComposizioneAnnoDTO.setAnno( dto.getAnno() );
        classeComposizioneAnnoDTO.setTurno( turnoInnerDTOToTurnoDTO( dto.getTurno() ) );
        classeComposizioneAnnoDTO.setRefettorio( refettorioInnerDTOToRefettorioDTO( dto.getRefettorio() ) );
        classeComposizioneAnnoDTO.setClasseComposizione( classeComposizioneInnerDTOToClasseComposizioneDTO( dto.getClasseComposizione() ) );

        return classeComposizioneAnnoDTO;
    }

    protected GiroModel giroDTOToGiroModel(GiroDTO giroDTO) {
        if ( giroDTO == null ) {
            return null;
        }

        GiroModel giroModel = new GiroModel();

        giroModel.setId( giroDTO.getId() );
        giroModel.setDescrizione( giroDTO.getDescrizione() );
        giroModel.setFlagElimina( giroDTO.getFlagElimina() );

        return giroModel;
    }

    protected TurnoModel turnoDTOToTurnoModel(TurnoDTO turnoDTO) {
        if ( turnoDTO == null ) {
            return null;
        }

        TurnoModel turnoModel = new TurnoModel();

        turnoModel.setId( turnoDTO.getId() );
        turnoModel.setDescrizione( turnoDTO.getDescrizione() );
        turnoModel.setFlagElimina( turnoDTO.getFlagElimina() );
        turnoModel.setGiro( giroDTOToGiroModel( turnoDTO.getGiro() ) );

        return turnoModel;
    }

    protected RefettorioModel refettorioDTOToRefettorioModel(RefettorioDTO refettorioDTO) {
        if ( refettorioDTO == null ) {
            return null;
        }

        RefettorioModel refettorioModel = new RefettorioModel();

        refettorioModel.setId( refettorioDTO.getId() );
        refettorioModel.setIdEnte( refettorioDTO.getIdEnte() );
        refettorioModel.setDescrizione( refettorioDTO.getDescrizione() );
        refettorioModel.setFlagElimina( refettorioDTO.getFlagElimina() );

        return refettorioModel;
    }

    protected IstitutoModel istitutoDTOToIstitutoModel(IstitutoDTO istitutoDTO) {
        if ( istitutoDTO == null ) {
            return null;
        }

        IstitutoModel istitutoModel = new IstitutoModel();

        istitutoModel.setId( istitutoDTO.getId() );
        istitutoModel.setIdEnte( istitutoDTO.getIdEnte() );
        istitutoModel.setDenominazione( istitutoDTO.getDenominazione() );
        istitutoModel.setPartitaIva( istitutoDTO.getPartitaIva() );
        istitutoModel.setIndirizzo( istitutoDTO.getIndirizzo() );
        istitutoModel.setIdStradario( istitutoDTO.getIdStradario() );
        istitutoModel.setCivico( istitutoDTO.getCivico() );
        istitutoModel.setNumeroClassi( istitutoDTO.getNumeroClassi() );
        istitutoModel.setNumeroAlunni( istitutoDTO.getNumeroAlunni() );
        istitutoModel.setReferente( istitutoDTO.getReferente() );
        istitutoModel.setTelefono( istitutoDTO.getTelefono() );
        istitutoModel.setFax( istitutoDTO.getFax() );
        istitutoModel.setEmail( istitutoDTO.getEmail() );
        istitutoModel.setIdTipologiaIstituto( istitutoDTO.getIdTipologiaIstituto() );
        istitutoModel.setDataInizio( istitutoDTO.getDataInizio() );
        istitutoModel.setDataFine( istitutoDTO.getDataFine() );
        istitutoModel.setMeccanograficoPlesso( istitutoDTO.getMeccanograficoPlesso() );
        istitutoModel.setMeccanograficoScuola( istitutoDTO.getMeccanograficoScuola() );
        istitutoModel.setLatitudine( istitutoDTO.getLatitudine() );
        istitutoModel.setLongitudine( istitutoDTO.getLongitudine() );
        istitutoModel.setFlagTipoIstituto( istitutoDTO.getFlagTipoIstituto() );
        istitutoModel.setFlagAnticipo( istitutoDTO.getFlagAnticipo() );
        istitutoModel.setFlagPosticipo( istitutoDTO.getFlagPosticipo() );
        istitutoModel.setFlagTempoProlungato( istitutoDTO.getFlagTempoProlungato() );
        istitutoModel.setSicraCodiceVia( istitutoDTO.getSicraCodiceVia() );
        istitutoModel.setSicraCivico( istitutoDTO.getSicraCivico() );
        istitutoModel.setCodiceEsterno( istitutoDTO.getCodiceEsterno() );
        istitutoModel.setFlagElimina( istitutoDTO.getFlagElimina() );

        return istitutoModel;
    }

    protected ClasseModel classeDTOToClasseModel(ClasseDTO classeDTO) {
        if ( classeDTO == null ) {
            return null;
        }

        ClasseModel classeModel = new ClasseModel();

        classeModel.setId( classeDTO.getId() );
        classeModel.setDescrizione( classeDTO.getDescrizione() );
        classeModel.setFlagElimina( classeDTO.getFlagElimina() );

        return classeModel;
    }

    protected SezioneModel sezioneDTOToSezioneModel(SezioneDTO sezioneDTO) {
        if ( sezioneDTO == null ) {
            return null;
        }

        SezioneModel sezioneModel = new SezioneModel();

        sezioneModel.setId( sezioneDTO.getId() );
        sezioneModel.setDescrizione( sezioneDTO.getDescrizione() );
        sezioneModel.setFlagElimina( sezioneDTO.getFlagElimina() );

        return sezioneModel;
    }

    protected ClasseComposizioneModel classeComposizioneDTOToClasseComposizioneModel(ClasseComposizioneDTO classeComposizioneDTO) {
        if ( classeComposizioneDTO == null ) {
            return null;
        }

        ClasseComposizioneModel classeComposizioneModel = new ClasseComposizioneModel();

        classeComposizioneModel.setId( classeComposizioneDTO.getId() );
        classeComposizioneModel.setIdEnte( classeComposizioneDTO.getIdEnte() );
        classeComposizioneModel.setIstituto( istitutoDTOToIstitutoModel( classeComposizioneDTO.getIstituto() ) );
        classeComposizioneModel.setClasse( classeDTOToClasseModel( classeComposizioneDTO.getClasse() ) );
        classeComposizioneModel.setSezione( sezioneDTOToSezioneModel( classeComposizioneDTO.getSezione() ) );
        classeComposizioneModel.setIstitutoSuccessiva( istitutoDTOToIstitutoModel( classeComposizioneDTO.getIstitutoSuccessiva() ) );
        classeComposizioneModel.setClasseSuccessiva( classeDTOToClasseModel( classeComposizioneDTO.getClasseSuccessiva() ) );
        classeComposizioneModel.setSezioneSuccessiva( sezioneDTOToSezioneModel( classeComposizioneDTO.getSezioneSuccessiva() ) );
        classeComposizioneModel.setFlagElimina( classeComposizioneDTO.getFlagElimina() );

        return classeComposizioneModel;
    }

    protected GiroDTO giroModelToGiroDTO(GiroModel giroModel) {
        if ( giroModel == null ) {
            return null;
        }

        GiroDTO giroDTO = new GiroDTO();

        giroDTO.setId( giroModel.getId() );
        giroDTO.setDescrizione( giroModel.getDescrizione() );
        giroDTO.setFlagElimina( giroModel.getFlagElimina() );

        return giroDTO;
    }

    protected TurnoDTO turnoModelToTurnoDTO(TurnoModel turnoModel) {
        if ( turnoModel == null ) {
            return null;
        }

        TurnoDTO turnoDTO = new TurnoDTO();

        turnoDTO.setId( turnoModel.getId() );
        turnoDTO.setDescrizione( turnoModel.getDescrizione() );
        turnoDTO.setFlagElimina( turnoModel.getFlagElimina() );
        turnoDTO.setGiro( giroModelToGiroDTO( turnoModel.getGiro() ) );

        return turnoDTO;
    }

    protected RefettorioDTO refettorioModelToRefettorioDTO(RefettorioModel refettorioModel) {
        if ( refettorioModel == null ) {
            return null;
        }

        RefettorioDTO refettorioDTO = new RefettorioDTO();

        refettorioDTO.setId( refettorioModel.getId() );
        refettorioDTO.setIdEnte( refettorioModel.getIdEnte() );
        refettorioDTO.setDescrizione( refettorioModel.getDescrizione() );
        refettorioDTO.setFlagElimina( refettorioModel.getFlagElimina() );

        return refettorioDTO;
    }

    protected IstitutoDTO istitutoModelToIstitutoDTO(IstitutoModel istitutoModel) {
        if ( istitutoModel == null ) {
            return null;
        }

        IstitutoDTO istitutoDTO = new IstitutoDTO();

        istitutoDTO.setId( istitutoModel.getId() );
        istitutoDTO.setIdEnte( istitutoModel.getIdEnte() );
        istitutoDTO.setDenominazione( istitutoModel.getDenominazione() );
        istitutoDTO.setPartitaIva( istitutoModel.getPartitaIva() );
        istitutoDTO.setIndirizzo( istitutoModel.getIndirizzo() );
        istitutoDTO.setIdStradario( istitutoModel.getIdStradario() );
        istitutoDTO.setCivico( istitutoModel.getCivico() );
        istitutoDTO.setNumeroClassi( istitutoModel.getNumeroClassi() );
        istitutoDTO.setNumeroAlunni( istitutoModel.getNumeroAlunni() );
        istitutoDTO.setReferente( istitutoModel.getReferente() );
        istitutoDTO.setTelefono( istitutoModel.getTelefono() );
        istitutoDTO.setFax( istitutoModel.getFax() );
        istitutoDTO.setEmail( istitutoModel.getEmail() );
        istitutoDTO.setIdTipologiaIstituto( istitutoModel.getIdTipologiaIstituto() );
        istitutoDTO.setDataInizio( istitutoModel.getDataInizio() );
        istitutoDTO.setDataFine( istitutoModel.getDataFine() );
        istitutoDTO.setMeccanograficoPlesso( istitutoModel.getMeccanograficoPlesso() );
        istitutoDTO.setMeccanograficoScuola( istitutoModel.getMeccanograficoScuola() );
        istitutoDTO.setLatitudine( istitutoModel.getLatitudine() );
        istitutoDTO.setLongitudine( istitutoModel.getLongitudine() );
        istitutoDTO.setFlagTipoIstituto( istitutoModel.getFlagTipoIstituto() );
        istitutoDTO.setFlagAnticipo( istitutoModel.getFlagAnticipo() );
        istitutoDTO.setFlagPosticipo( istitutoModel.getFlagPosticipo() );
        istitutoDTO.setFlagTempoProlungato( istitutoModel.getFlagTempoProlungato() );
        istitutoDTO.setSicraCodiceVia( istitutoModel.getSicraCodiceVia() );
        istitutoDTO.setSicraCivico( istitutoModel.getSicraCivico() );
        istitutoDTO.setCodiceEsterno( istitutoModel.getCodiceEsterno() );
        istitutoDTO.setFlagElimina( istitutoModel.getFlagElimina() );

        return istitutoDTO;
    }

    protected ClasseDTO classeModelToClasseDTO(ClasseModel classeModel) {
        if ( classeModel == null ) {
            return null;
        }

        ClasseDTO classeDTO = new ClasseDTO();

        classeDTO.setId( classeModel.getId() );
        classeDTO.setDescrizione( classeModel.getDescrizione() );
        classeDTO.setFlagElimina( classeModel.getFlagElimina() );

        return classeDTO;
    }

    protected SezioneDTO sezioneModelToSezioneDTO(SezioneModel sezioneModel) {
        if ( sezioneModel == null ) {
            return null;
        }

        SezioneDTO sezioneDTO = new SezioneDTO();

        sezioneDTO.setId( sezioneModel.getId() );
        sezioneDTO.setDescrizione( sezioneModel.getDescrizione() );
        sezioneDTO.setFlagElimina( sezioneModel.getFlagElimina() );

        return sezioneDTO;
    }

    protected ClasseComposizioneDTO classeComposizioneModelToClasseComposizioneDTO(ClasseComposizioneModel classeComposizioneModel) {
        if ( classeComposizioneModel == null ) {
            return null;
        }

        ClasseComposizioneDTO classeComposizioneDTO = new ClasseComposizioneDTO();

        classeComposizioneDTO.setId( classeComposizioneModel.getId() );
        classeComposizioneDTO.setIdEnte( classeComposizioneModel.getIdEnte() );
        classeComposizioneDTO.setIstituto( istitutoModelToIstitutoDTO( classeComposizioneModel.getIstituto() ) );
        classeComposizioneDTO.setClasse( classeModelToClasseDTO( classeComposizioneModel.getClasse() ) );
        classeComposizioneDTO.setSezione( sezioneModelToSezioneDTO( classeComposizioneModel.getSezione() ) );
        classeComposizioneDTO.setIstitutoSuccessiva( istitutoModelToIstitutoDTO( classeComposizioneModel.getIstitutoSuccessiva() ) );
        classeComposizioneDTO.setClasseSuccessiva( classeModelToClasseDTO( classeComposizioneModel.getClasseSuccessiva() ) );
        classeComposizioneDTO.setSezioneSuccessiva( sezioneModelToSezioneDTO( classeComposizioneModel.getSezioneSuccessiva() ) );
        classeComposizioneDTO.setFlagElimina( classeComposizioneModel.getFlagElimina() );

        return classeComposizioneDTO;
    }

    protected TurnoDTO turnoInnerDTOToTurnoDTO(TurnoInnerDTO turnoInnerDTO) {
        if ( turnoInnerDTO == null ) {
            return null;
        }

        TurnoDTO turnoDTO = new TurnoDTO();

        turnoDTO.setId( turnoInnerDTO.getId() );

        return turnoDTO;
    }

    protected RefettorioDTO refettorioInnerDTOToRefettorioDTO(RefettorioInnerDTO refettorioInnerDTO) {
        if ( refettorioInnerDTO == null ) {
            return null;
        }

        RefettorioDTO refettorioDTO = new RefettorioDTO();

        refettorioDTO.setId( refettorioInnerDTO.getId() );

        return refettorioDTO;
    }

    protected ClasseComposizioneDTO classeComposizioneInnerDTOToClasseComposizioneDTO(ClasseComposizioneInnerDTO classeComposizioneInnerDTO) {
        if ( classeComposizioneInnerDTO == null ) {
            return null;
        }

        ClasseComposizioneDTO classeComposizioneDTO = new ClasseComposizioneDTO();

        classeComposizioneDTO.setId( classeComposizioneInnerDTO.getId() );

        return classeComposizioneDTO;
    }
}
