package it.iccs.simeal.sdi.configurazione.application.mapper;

import it.iccs.simeal.sdi.configurazione.application.model.AperturaModel;
import it.iccs.simeal.sdi.configurazione.application.model.ClasseModel;
import it.iccs.simeal.sdi.configurazione.application.model.IstitutoModel;
import it.iccs.simeal.sdi.configurazione.application.model.ServizioModel;
import it.iccs.simeal.sdi.configurazione.application.model.SezioneModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AbstractAperturaDTO.ClasseInnerDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AbstractAperturaDTO.IstitutoInnerDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AbstractAperturaDTO.ServizioInnerDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AbstractAperturaDTO.SezioneInnerDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AperturaCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AperturaDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AperturaUpdateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.IstitutoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.SezioneDTO;
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
public class AperturaModelMapperImpl implements AperturaModelMapper {

    @Override
    public AperturaModel toModel(AperturaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AperturaModel aperturaModel = new AperturaModel();

        aperturaModel.setId( dto.getId() );
        aperturaModel.setAnno( dto.getAnno() );
        aperturaModel.setIstituto( istitutoDTOToIstitutoModel( dto.getIstituto() ) );
        aperturaModel.setClasse( classeDTOToClasseModel( dto.getClasse() ) );
        aperturaModel.setSezione( sezioneDTOToSezioneModel( dto.getSezione() ) );
        aperturaModel.setServizio( servizioDTOToServizioModel( dto.getServizio() ) );
        aperturaModel.setDescrizione( dto.getDescrizione() );
        aperturaModel.setDataInizio( dto.getDataInizio() );
        aperturaModel.setDataFine( dto.getDataFine() );
        aperturaModel.setFlagElimina( dto.getFlagElimina() );

        return aperturaModel;
    }

    @Override
    public AperturaDTO toDto(AperturaModel entity) {
        if ( entity == null ) {
            return null;
        }

        AperturaDTO aperturaDTO = new AperturaDTO();

        aperturaDTO.setId( entity.getId() );
        aperturaDTO.setAnno( entity.getAnno() );
        aperturaDTO.setServizio( servizioModelToServizioDTO( entity.getServizio() ) );
        aperturaDTO.setIstituto( istitutoModelToIstitutoDTO( entity.getIstituto() ) );
        aperturaDTO.setClasse( classeModelToClasseDTO( entity.getClasse() ) );
        aperturaDTO.setSezione( sezioneModelToSezioneDTO( entity.getSezione() ) );
        aperturaDTO.setDescrizione( entity.getDescrizione() );
        aperturaDTO.setDataInizio( entity.getDataInizio() );
        aperturaDTO.setDataFine( entity.getDataFine() );
        aperturaDTO.setFlagElimina( entity.getFlagElimina() );

        return aperturaDTO;
    }

    @Override
    public List<AperturaModel> toModel(List<AperturaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AperturaModel> list = new ArrayList<AperturaModel>( dtoList.size() );
        for ( AperturaDTO aperturaDTO : dtoList ) {
            list.add( toModel( aperturaDTO ) );
        }

        return list;
    }

    @Override
    public List<AperturaDTO> toDto(List<AperturaModel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AperturaDTO> list = new ArrayList<AperturaDTO>( entityList.size() );
        for ( AperturaModel aperturaModel : entityList ) {
            list.add( toDto( aperturaModel ) );
        }

        return list;
    }

    @Override
    public AperturaDTO fromCreateDto(AperturaCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AperturaDTO aperturaDTO = new AperturaDTO();

        aperturaDTO.setAnno( dto.getAnno() );
        aperturaDTO.setServizio( servizioInnerDTOToServizioDTO( dto.getServizio() ) );
        aperturaDTO.setIstituto( istitutoInnerDTOToIstitutoDTO( dto.getIstituto() ) );
        aperturaDTO.setClasse( classeInnerDTOToClasseDTO( dto.getClasse() ) );
        aperturaDTO.setSezione( sezioneInnerDTOToSezioneDTO( dto.getSezione() ) );
        aperturaDTO.setDescrizione( dto.getDescrizione() );
        aperturaDTO.setDataInizio( dto.getDataInizio() );
        aperturaDTO.setDataFine( dto.getDataFine() );
        aperturaDTO.setFlagElimina( dto.getFlagElimina() );

        return aperturaDTO;
    }

    @Override
    public AperturaDTO fromUpdateDto(AperturaUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AperturaDTO aperturaDTO = new AperturaDTO();

        aperturaDTO.setId( dto.getId() );
        aperturaDTO.setAnno( dto.getAnno() );
        aperturaDTO.setServizio( servizioInnerDTOToServizioDTO( dto.getServizio() ) );
        aperturaDTO.setIstituto( istitutoInnerDTOToIstitutoDTO( dto.getIstituto() ) );
        aperturaDTO.setClasse( classeInnerDTOToClasseDTO( dto.getClasse() ) );
        aperturaDTO.setSezione( sezioneInnerDTOToSezioneDTO( dto.getSezione() ) );
        aperturaDTO.setDescrizione( dto.getDescrizione() );
        aperturaDTO.setDataInizio( dto.getDataInizio() );
        aperturaDTO.setDataFine( dto.getDataFine() );

        return aperturaDTO;
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

    protected ServizioModel servizioDTOToServizioModel(ServizioDTO servizioDTO) {
        if ( servizioDTO == null ) {
            return null;
        }

        ServizioModel servizioModel = new ServizioModel();

        servizioModel.setId( servizioDTO.getId() );
        servizioModel.setIdEnte( servizioDTO.getIdEnte() );
        servizioModel.setDescrizione( servizioDTO.getDescrizione() );
        servizioModel.setFlagElimina( servizioDTO.getFlagElimina() );
        servizioModel.setCodice( servizioDTO.getCodice() );

        return servizioModel;
    }

    protected ServizioDTO servizioModelToServizioDTO(ServizioModel servizioModel) {
        if ( servizioModel == null ) {
            return null;
        }

        ServizioDTO servizioDTO = new ServizioDTO();

        servizioDTO.setId( servizioModel.getId() );
        servizioDTO.setIdEnte( servizioModel.getIdEnte() );
        servizioDTO.setDescrizione( servizioModel.getDescrizione() );
        servizioDTO.setFlagElimina( servizioModel.getFlagElimina() );
        servizioDTO.setCodice( servizioModel.getCodice() );

        return servizioDTO;
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

    protected ServizioDTO servizioInnerDTOToServizioDTO(ServizioInnerDTO servizioInnerDTO) {
        if ( servizioInnerDTO == null ) {
            return null;
        }

        ServizioDTO servizioDTO = new ServizioDTO();

        servizioDTO.setId( servizioInnerDTO.getId() );

        return servizioDTO;
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
