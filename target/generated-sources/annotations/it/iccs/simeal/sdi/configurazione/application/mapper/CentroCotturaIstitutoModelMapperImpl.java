package it.iccs.simeal.sdi.configurazione.application.mapper;

import it.iccs.simeal.sdi.configurazione.application.model.CentroCotturaIstitutoModel;
import it.iccs.simeal.sdi.configurazione.application.model.CentroCotturaModel;
import it.iccs.simeal.sdi.configurazione.application.model.IstitutoModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AbstractCentroCotturaIstitutoDTO.CentroCotturaInnerDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AbstractCentroCotturaIstitutoDTO.IstitutoInnerDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.CentroCotturaDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.CentroCotturaIstitutoCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.CentroCotturaIstitutoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.CentroCotturaIstitutoUpdateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.IstitutoDTO;
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
public class CentroCotturaIstitutoModelMapperImpl implements CentroCotturaIstitutoModelMapper {

    @Override
    public CentroCotturaIstitutoModel toModel(CentroCotturaIstitutoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CentroCotturaIstitutoModel centroCotturaIstitutoModel = new CentroCotturaIstitutoModel();

        centroCotturaIstitutoModel.setId( dto.getId() );
        centroCotturaIstitutoModel.setIstituto( istitutoDTOToIstitutoModel( dto.getIstituto() ) );
        centroCotturaIstitutoModel.setCentroCottura( centroCotturaDTOToCentroCotturaModel( dto.getCentroCottura() ) );
        centroCotturaIstitutoModel.setDataInizio( dto.getDataInizio() );
        centroCotturaIstitutoModel.setDataFine( dto.getDataFine() );

        return centroCotturaIstitutoModel;
    }

    @Override
    public CentroCotturaIstitutoDTO toDto(CentroCotturaIstitutoModel entity) {
        if ( entity == null ) {
            return null;
        }

        CentroCotturaIstitutoDTO centroCotturaIstitutoDTO = new CentroCotturaIstitutoDTO();

        centroCotturaIstitutoDTO.setId( entity.getId() );
        centroCotturaIstitutoDTO.setIstituto( istitutoModelToIstitutoDTO( entity.getIstituto() ) );
        centroCotturaIstitutoDTO.setCentroCottura( centroCotturaModelToCentroCotturaDTO( entity.getCentroCottura() ) );
        centroCotturaIstitutoDTO.setDataInizio( entity.getDataInizio() );
        centroCotturaIstitutoDTO.setDataFine( entity.getDataFine() );

        return centroCotturaIstitutoDTO;
    }

    @Override
    public List<CentroCotturaIstitutoModel> toModel(List<CentroCotturaIstitutoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<CentroCotturaIstitutoModel> list = new ArrayList<CentroCotturaIstitutoModel>( dtoList.size() );
        for ( CentroCotturaIstitutoDTO centroCotturaIstitutoDTO : dtoList ) {
            list.add( toModel( centroCotturaIstitutoDTO ) );
        }

        return list;
    }

    @Override
    public List<CentroCotturaIstitutoDTO> toDto(List<CentroCotturaIstitutoModel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CentroCotturaIstitutoDTO> list = new ArrayList<CentroCotturaIstitutoDTO>( entityList.size() );
        for ( CentroCotturaIstitutoModel centroCotturaIstitutoModel : entityList ) {
            list.add( toDto( centroCotturaIstitutoModel ) );
        }

        return list;
    }

    @Override
    public CentroCotturaIstitutoDTO fromCreateDto(CentroCotturaIstitutoCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CentroCotturaIstitutoDTO centroCotturaIstitutoDTO = new CentroCotturaIstitutoDTO();

        centroCotturaIstitutoDTO.setIstituto( istitutoInnerDTOToIstitutoDTO( dto.getIstituto() ) );
        centroCotturaIstitutoDTO.setCentroCottura( centroCotturaInnerDTOToCentroCotturaDTO( dto.getCentroCottura() ) );
        centroCotturaIstitutoDTO.setDataInizio( dto.getDataInizio() );
        centroCotturaIstitutoDTO.setDataFine( dto.getDataFine() );

        return centroCotturaIstitutoDTO;
    }

    @Override
    public CentroCotturaIstitutoDTO fromUpdateDto(CentroCotturaIstitutoUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CentroCotturaIstitutoDTO centroCotturaIstitutoDTO = new CentroCotturaIstitutoDTO();

        centroCotturaIstitutoDTO.setId( dto.getId() );
        centroCotturaIstitutoDTO.setIstituto( istitutoInnerDTOToIstitutoDTO( dto.getIstituto() ) );
        centroCotturaIstitutoDTO.setCentroCottura( centroCotturaInnerDTOToCentroCotturaDTO( dto.getCentroCottura() ) );
        centroCotturaIstitutoDTO.setDataInizio( dto.getDataInizio() );
        centroCotturaIstitutoDTO.setDataFine( dto.getDataFine() );

        return centroCotturaIstitutoDTO;
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

    protected CentroCotturaModel centroCotturaDTOToCentroCotturaModel(CentroCotturaDTO centroCotturaDTO) {
        if ( centroCotturaDTO == null ) {
            return null;
        }

        CentroCotturaModel centroCotturaModel = new CentroCotturaModel();

        centroCotturaModel.setId( centroCotturaDTO.getId() );
        centroCotturaModel.setDenominazione( centroCotturaDTO.getDenominazione() );
        centroCotturaModel.setIndirizzo( centroCotturaDTO.getIndirizzo() );
        centroCotturaModel.setCivico( centroCotturaDTO.getCivico() );
        centroCotturaModel.setCitta( centroCotturaDTO.getCitta() );
        centroCotturaModel.setProvincia( centroCotturaDTO.getProvincia() );
        centroCotturaModel.setReferente( centroCotturaDTO.getReferente() );
        centroCotturaModel.setTelefono( centroCotturaDTO.getTelefono() );
        centroCotturaModel.setFax( centroCotturaDTO.getFax() );
        centroCotturaModel.setEmail( centroCotturaDTO.getEmail() );
        centroCotturaModel.setPec( centroCotturaDTO.getPec() );
        centroCotturaModel.setFlagElimina( centroCotturaDTO.getFlagElimina() );

        return centroCotturaModel;
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

    protected CentroCotturaDTO centroCotturaModelToCentroCotturaDTO(CentroCotturaModel centroCotturaModel) {
        if ( centroCotturaModel == null ) {
            return null;
        }

        CentroCotturaDTO centroCotturaDTO = new CentroCotturaDTO();

        centroCotturaDTO.setId( centroCotturaModel.getId() );
        centroCotturaDTO.setDenominazione( centroCotturaModel.getDenominazione() );
        centroCotturaDTO.setIndirizzo( centroCotturaModel.getIndirizzo() );
        centroCotturaDTO.setCivico( centroCotturaModel.getCivico() );
        centroCotturaDTO.setCitta( centroCotturaModel.getCitta() );
        centroCotturaDTO.setProvincia( centroCotturaModel.getProvincia() );
        centroCotturaDTO.setReferente( centroCotturaModel.getReferente() );
        centroCotturaDTO.setTelefono( centroCotturaModel.getTelefono() );
        centroCotturaDTO.setFax( centroCotturaModel.getFax() );
        centroCotturaDTO.setEmail( centroCotturaModel.getEmail() );
        centroCotturaDTO.setPec( centroCotturaModel.getPec() );
        centroCotturaDTO.setFlagElimina( centroCotturaModel.getFlagElimina() );

        return centroCotturaDTO;
    }

    protected IstitutoDTO istitutoInnerDTOToIstitutoDTO(IstitutoInnerDTO istitutoInnerDTO) {
        if ( istitutoInnerDTO == null ) {
            return null;
        }

        IstitutoDTO istitutoDTO = new IstitutoDTO();

        istitutoDTO.setId( istitutoInnerDTO.getId() );

        return istitutoDTO;
    }

    protected CentroCotturaDTO centroCotturaInnerDTOToCentroCotturaDTO(CentroCotturaInnerDTO centroCotturaInnerDTO) {
        if ( centroCotturaInnerDTO == null ) {
            return null;
        }

        CentroCotturaDTO centroCotturaDTO = new CentroCotturaDTO();

        centroCotturaDTO.setId( centroCotturaInnerDTO.getId() );

        return centroCotturaDTO;
    }
}
