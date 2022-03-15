package it.iccs.simeal.sdi.configurazione.application.mapper;

import it.iccs.simeal.sdi.configurazione.application.model.ChiusuraModel;
import it.iccs.simeal.sdi.configurazione.application.model.ClasseModel;
import it.iccs.simeal.sdi.configurazione.application.model.IstitutoModel;
import it.iccs.simeal.sdi.configurazione.application.model.ServizioModel;
import it.iccs.simeal.sdi.configurazione.application.model.SezioneModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AbstractChiusuraDTO.ClasseInnerDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AbstractChiusuraDTO.IstitutoInnerDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AbstractChiusuraDTO.ServizioInnerDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AbstractChiusuraDTO.SezioneInnerDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ChiusuraCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ChiusuraDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ChiusuraUpdateDTO;
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
public class ChiusuraModelMapperImpl implements ChiusuraModelMapper {

    @Override
    public ChiusuraModel toModel(ChiusuraDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ChiusuraModel chiusuraModel = new ChiusuraModel();

        chiusuraModel.setId( dto.getId() );
        chiusuraModel.setAnno( dto.getAnno() );
        chiusuraModel.setIstituto( istitutoDTOToIstitutoModel( dto.getIstituto() ) );
        chiusuraModel.setClasse( classeDTOToClasseModel( dto.getClasse() ) );
        chiusuraModel.setSezione( sezioneDTOToSezioneModel( dto.getSezione() ) );
        chiusuraModel.setServizio( servizioDTOToServizioModel( dto.getServizio() ) );
        chiusuraModel.setDescrizione( dto.getDescrizione() );
        chiusuraModel.setDataInizio( dto.getDataInizio() );
        chiusuraModel.setDataFine( dto.getDataFine() );
        chiusuraModel.setFlagElimina( dto.getFlagElimina() );

        return chiusuraModel;
    }

    @Override
    public ChiusuraDTO toDto(ChiusuraModel entity) {
        if ( entity == null ) {
            return null;
        }

        ChiusuraDTO chiusuraDTO = new ChiusuraDTO();

        chiusuraDTO.setId( entity.getId() );
        chiusuraDTO.setAnno( entity.getAnno() );
        chiusuraDTO.setServizio( servizioModelToServizioDTO( entity.getServizio() ) );
        chiusuraDTO.setIstituto( istitutoModelToIstitutoDTO( entity.getIstituto() ) );
        chiusuraDTO.setClasse( classeModelToClasseDTO( entity.getClasse() ) );
        chiusuraDTO.setSezione( sezioneModelToSezioneDTO( entity.getSezione() ) );
        chiusuraDTO.setDescrizione( entity.getDescrizione() );
        chiusuraDTO.setDataInizio( entity.getDataInizio() );
        chiusuraDTO.setDataFine( entity.getDataFine() );
        chiusuraDTO.setFlagElimina( entity.getFlagElimina() );

        return chiusuraDTO;
    }

    @Override
    public List<ChiusuraModel> toModel(List<ChiusuraDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ChiusuraModel> list = new ArrayList<ChiusuraModel>( dtoList.size() );
        for ( ChiusuraDTO chiusuraDTO : dtoList ) {
            list.add( toModel( chiusuraDTO ) );
        }

        return list;
    }

    @Override
    public List<ChiusuraDTO> toDto(List<ChiusuraModel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ChiusuraDTO> list = new ArrayList<ChiusuraDTO>( entityList.size() );
        for ( ChiusuraModel chiusuraModel : entityList ) {
            list.add( toDto( chiusuraModel ) );
        }

        return list;
    }

    @Override
    public ChiusuraDTO fromCreateDto(ChiusuraCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ChiusuraDTO chiusuraDTO = new ChiusuraDTO();

        chiusuraDTO.setAnno( dto.getAnno() );
        chiusuraDTO.setServizio( servizioInnerDTOToServizioDTO( dto.getServizio() ) );
        chiusuraDTO.setIstituto( istitutoInnerDTOToIstitutoDTO( dto.getIstituto() ) );
        chiusuraDTO.setClasse( classeInnerDTOToClasseDTO( dto.getClasse() ) );
        chiusuraDTO.setSezione( sezioneInnerDTOToSezioneDTO( dto.getSezione() ) );
        chiusuraDTO.setDescrizione( dto.getDescrizione() );
        chiusuraDTO.setDataInizio( dto.getDataInizio() );
        chiusuraDTO.setDataFine( dto.getDataFine() );
        chiusuraDTO.setFlagElimina( dto.getFlagElimina() );

        return chiusuraDTO;
    }

    @Override
    public ChiusuraDTO fromUpdateDto(ChiusuraUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ChiusuraDTO chiusuraDTO = new ChiusuraDTO();

        chiusuraDTO.setId( dto.getId() );
        chiusuraDTO.setAnno( dto.getAnno() );
        chiusuraDTO.setServizio( servizioInnerDTOToServizioDTO( dto.getServizio() ) );
        chiusuraDTO.setIstituto( istitutoInnerDTOToIstitutoDTO( dto.getIstituto() ) );
        chiusuraDTO.setClasse( classeInnerDTOToClasseDTO( dto.getClasse() ) );
        chiusuraDTO.setSezione( sezioneInnerDTOToSezioneDTO( dto.getSezione() ) );
        chiusuraDTO.setDescrizione( dto.getDescrizione() );
        chiusuraDTO.setDataInizio( dto.getDataInizio() );
        chiusuraDTO.setDataFine( dto.getDataFine() );

        return chiusuraDTO;
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
