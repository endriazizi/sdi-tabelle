package it.iccs.simeal.sdi.configurazione.application.mapper;

import it.iccs.simeal.sdi.configurazione.application.model.ClasseComposizioneModel;
import it.iccs.simeal.sdi.configurazione.application.model.ClasseModel;
import it.iccs.simeal.sdi.configurazione.application.model.IstitutoModel;
import it.iccs.simeal.sdi.configurazione.application.model.SezioneModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AbstractClasseComposizioneDTO.ClasseInnerDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AbstractClasseComposizioneDTO.IstitutoInnerDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AbstractClasseComposizioneDTO.SezioneInnerDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseComposizioneUpdateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.IstitutoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.SezioneDTO;
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
public class ClasseComposizioneModelMapperImpl implements ClasseComposizioneModelMapper {

    @Override
    public ClasseComposizioneModel toModel(ClasseComposizioneDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ClasseComposizioneModel classeComposizioneModel = new ClasseComposizioneModel();

        classeComposizioneModel.setId( dto.getId() );
        classeComposizioneModel.setIdEnte( dto.getIdEnte() );
        classeComposizioneModel.setIstituto( istitutoDTOToIstitutoModel( dto.getIstituto() ) );
        classeComposizioneModel.setClasse( classeDTOToClasseModel( dto.getClasse() ) );
        classeComposizioneModel.setSezione( sezioneDTOToSezioneModel( dto.getSezione() ) );
        classeComposizioneModel.setIstitutoSuccessiva( istitutoDTOToIstitutoModel( dto.getIstitutoSuccessiva() ) );
        classeComposizioneModel.setClasseSuccessiva( classeDTOToClasseModel( dto.getClasseSuccessiva() ) );
        classeComposizioneModel.setSezioneSuccessiva( sezioneDTOToSezioneModel( dto.getSezioneSuccessiva() ) );
        classeComposizioneModel.setFlagElimina( dto.getFlagElimina() );

        return classeComposizioneModel;
    }

    @Override
    public ClasseComposizioneDTO toDto(ClasseComposizioneModel entity) {
        if ( entity == null ) {
            return null;
        }

        ClasseComposizioneDTO classeComposizioneDTO = new ClasseComposizioneDTO();

        classeComposizioneDTO.setId( entity.getId() );
        classeComposizioneDTO.setIdEnte( entity.getIdEnte() );
        classeComposizioneDTO.setIstituto( istitutoModelToIstitutoDTO( entity.getIstituto() ) );
        classeComposizioneDTO.setClasse( classeModelToClasseDTO( entity.getClasse() ) );
        classeComposizioneDTO.setSezione( sezioneModelToSezioneDTO( entity.getSezione() ) );
        classeComposizioneDTO.setIstitutoSuccessiva( istitutoModelToIstitutoDTO( entity.getIstitutoSuccessiva() ) );
        classeComposizioneDTO.setClasseSuccessiva( classeModelToClasseDTO( entity.getClasseSuccessiva() ) );
        classeComposizioneDTO.setSezioneSuccessiva( sezioneModelToSezioneDTO( entity.getSezioneSuccessiva() ) );
        classeComposizioneDTO.setFlagElimina( entity.getFlagElimina() );

        return classeComposizioneDTO;
    }

    @Override
    public List<ClasseComposizioneModel> toModel(List<ClasseComposizioneDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ClasseComposizioneModel> list = new ArrayList<ClasseComposizioneModel>( dtoList.size() );
        for ( ClasseComposizioneDTO classeComposizioneDTO : dtoList ) {
            list.add( toModel( classeComposizioneDTO ) );
        }

        return list;
    }

    @Override
    public List<ClasseComposizioneDTO> toDto(List<ClasseComposizioneModel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ClasseComposizioneDTO> list = new ArrayList<ClasseComposizioneDTO>( entityList.size() );
        for ( ClasseComposizioneModel classeComposizioneModel : entityList ) {
            list.add( toDto( classeComposizioneModel ) );
        }

        return list;
    }

    @Override
    public ClasseComposizioneDTO fromCreateDto(ClasseComposizioneCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ClasseComposizioneDTO classeComposizioneDTO = new ClasseComposizioneDTO();

        classeComposizioneDTO.setIdEnte( dto.getIdEnte() );
        classeComposizioneDTO.setIstituto( istitutoInnerDTOToIstitutoDTO( dto.getIstituto() ) );
        classeComposizioneDTO.setClasse( classeInnerDTOToClasseDTO( dto.getClasse() ) );
        classeComposizioneDTO.setSezione( sezioneInnerDTOToSezioneDTO( dto.getSezione() ) );
        classeComposizioneDTO.setIstitutoSuccessiva( istitutoInnerDTOToIstitutoDTO( dto.getIstitutoSuccessiva() ) );
        classeComposizioneDTO.setClasseSuccessiva( classeInnerDTOToClasseDTO( dto.getClasseSuccessiva() ) );
        classeComposizioneDTO.setSezioneSuccessiva( sezioneInnerDTOToSezioneDTO( dto.getSezioneSuccessiva() ) );

        return classeComposizioneDTO;
    }

    @Override
    public ClasseComposizioneDTO fromUpdateDto(ClasseComposizioneUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ClasseComposizioneDTO classeComposizioneDTO = new ClasseComposizioneDTO();

        classeComposizioneDTO.setId( dto.getId() );
        classeComposizioneDTO.setIdEnte( dto.getIdEnte() );
        classeComposizioneDTO.setIstituto( istitutoInnerDTOToIstitutoDTO( dto.getIstituto() ) );
        classeComposizioneDTO.setClasse( classeInnerDTOToClasseDTO( dto.getClasse() ) );
        classeComposizioneDTO.setSezione( sezioneInnerDTOToSezioneDTO( dto.getSezione() ) );
        classeComposizioneDTO.setIstitutoSuccessiva( istitutoInnerDTOToIstitutoDTO( dto.getIstitutoSuccessiva() ) );
        classeComposizioneDTO.setClasseSuccessiva( classeInnerDTOToClasseDTO( dto.getClasseSuccessiva() ) );
        classeComposizioneDTO.setSezioneSuccessiva( sezioneInnerDTOToSezioneDTO( dto.getSezioneSuccessiva() ) );

        return classeComposizioneDTO;
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

    protected IstitutoDTO istitutoInnerDTOToIstitutoDTO(IstitutoInnerDTO istitutoInnerDTO) {
        if ( istitutoInnerDTO == null ) {
            return null;
        }

        IstitutoDTO istitutoDTO = new IstitutoDTO();

        istitutoDTO.setId( istitutoInnerDTO.getId() );

        return istitutoDTO;
    }

    protected ClasseDTO classeInnerDTOToClasseDTO(ClasseInnerDTO classeInnerDTO) {
        if ( classeInnerDTO == null ) {
            return null;
        }

        ClasseDTO classeDTO = new ClasseDTO();

        classeDTO.setId( classeInnerDTO.getId() );

        return classeDTO;
    }

    protected SezioneDTO sezioneInnerDTOToSezioneDTO(SezioneInnerDTO sezioneInnerDTO) {
        if ( sezioneInnerDTO == null ) {
            return null;
        }

        SezioneDTO sezioneDTO = new SezioneDTO();

        sezioneDTO.setId( sezioneInnerDTO.getId() );

        return sezioneDTO;
    }
}
