package it.iccs.simeal.sdi.configurazione.application.mapper;

import it.iccs.simeal.sdi.configurazione.application.model.IstitutoModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.IstitutoCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.IstitutoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.IstitutoUpdateDTO;
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
public class IstitutoModelMapperImpl implements IstitutoModelMapper {

    @Override
    public IstitutoModel toModel(IstitutoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        IstitutoModel istitutoModel = new IstitutoModel();

        istitutoModel.setId( dto.getId() );
        istitutoModel.setIdEnte( dto.getIdEnte() );
        istitutoModel.setDenominazione( dto.getDenominazione() );
        istitutoModel.setPartitaIva( dto.getPartitaIva() );
        istitutoModel.setIndirizzo( dto.getIndirizzo() );
        istitutoModel.setIdStradario( dto.getIdStradario() );
        istitutoModel.setCivico( dto.getCivico() );
        istitutoModel.setNumeroClassi( dto.getNumeroClassi() );
        istitutoModel.setNumeroAlunni( dto.getNumeroAlunni() );
        istitutoModel.setReferente( dto.getReferente() );
        istitutoModel.setTelefono( dto.getTelefono() );
        istitutoModel.setFax( dto.getFax() );
        istitutoModel.setEmail( dto.getEmail() );
        istitutoModel.setIdTipologiaIstituto( dto.getIdTipologiaIstituto() );
        istitutoModel.setDataInizio( dto.getDataInizio() );
        istitutoModel.setDataFine( dto.getDataFine() );
        istitutoModel.setMeccanograficoPlesso( dto.getMeccanograficoPlesso() );
        istitutoModel.setMeccanograficoScuola( dto.getMeccanograficoScuola() );
        istitutoModel.setLatitudine( dto.getLatitudine() );
        istitutoModel.setLongitudine( dto.getLongitudine() );
        istitutoModel.setFlagTipoIstituto( dto.getFlagTipoIstituto() );
        istitutoModel.setFlagAnticipo( dto.getFlagAnticipo() );
        istitutoModel.setFlagPosticipo( dto.getFlagPosticipo() );
        istitutoModel.setFlagTempoProlungato( dto.getFlagTempoProlungato() );
        istitutoModel.setSicraCodiceVia( dto.getSicraCodiceVia() );
        istitutoModel.setSicraCivico( dto.getSicraCivico() );
        istitutoModel.setCodiceEsterno( dto.getCodiceEsterno() );
        istitutoModel.setFlagElimina( dto.getFlagElimina() );

        return istitutoModel;
    }

    @Override
    public IstitutoDTO toDto(IstitutoModel entity) {
        if ( entity == null ) {
            return null;
        }

        IstitutoDTO istitutoDTO = new IstitutoDTO();

        istitutoDTO.setId( entity.getId() );
        istitutoDTO.setIdEnte( entity.getIdEnte() );
        istitutoDTO.setDenominazione( entity.getDenominazione() );
        istitutoDTO.setPartitaIva( entity.getPartitaIva() );
        istitutoDTO.setIndirizzo( entity.getIndirizzo() );
        istitutoDTO.setIdStradario( entity.getIdStradario() );
        istitutoDTO.setCivico( entity.getCivico() );
        istitutoDTO.setNumeroClassi( entity.getNumeroClassi() );
        istitutoDTO.setNumeroAlunni( entity.getNumeroAlunni() );
        istitutoDTO.setReferente( entity.getReferente() );
        istitutoDTO.setTelefono( entity.getTelefono() );
        istitutoDTO.setFax( entity.getFax() );
        istitutoDTO.setEmail( entity.getEmail() );
        istitutoDTO.setIdTipologiaIstituto( entity.getIdTipologiaIstituto() );
        istitutoDTO.setDataInizio( entity.getDataInizio() );
        istitutoDTO.setDataFine( entity.getDataFine() );
        istitutoDTO.setMeccanograficoPlesso( entity.getMeccanograficoPlesso() );
        istitutoDTO.setMeccanograficoScuola( entity.getMeccanograficoScuola() );
        istitutoDTO.setLatitudine( entity.getLatitudine() );
        istitutoDTO.setLongitudine( entity.getLongitudine() );
        istitutoDTO.setFlagTipoIstituto( entity.getFlagTipoIstituto() );
        istitutoDTO.setFlagAnticipo( entity.getFlagAnticipo() );
        istitutoDTO.setFlagPosticipo( entity.getFlagPosticipo() );
        istitutoDTO.setFlagTempoProlungato( entity.getFlagTempoProlungato() );
        istitutoDTO.setSicraCodiceVia( entity.getSicraCodiceVia() );
        istitutoDTO.setSicraCivico( entity.getSicraCivico() );
        istitutoDTO.setCodiceEsterno( entity.getCodiceEsterno() );
        istitutoDTO.setFlagElimina( entity.getFlagElimina() );

        return istitutoDTO;
    }

    @Override
    public List<IstitutoModel> toModel(List<IstitutoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<IstitutoModel> list = new ArrayList<IstitutoModel>( dtoList.size() );
        for ( IstitutoDTO istitutoDTO : dtoList ) {
            list.add( toModel( istitutoDTO ) );
        }

        return list;
    }

    @Override
    public List<IstitutoDTO> toDto(List<IstitutoModel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<IstitutoDTO> list = new ArrayList<IstitutoDTO>( entityList.size() );
        for ( IstitutoModel istitutoModel : entityList ) {
            list.add( toDto( istitutoModel ) );
        }

        return list;
    }

    @Override
    public IstitutoDTO fromCreateDto(IstitutoCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        IstitutoDTO istitutoDTO = new IstitutoDTO();

        istitutoDTO.setIdEnte( dto.getIdEnte() );
        istitutoDTO.setDenominazione( dto.getDenominazione() );
        istitutoDTO.setPartitaIva( dto.getPartitaIva() );
        istitutoDTO.setIndirizzo( dto.getIndirizzo() );
        istitutoDTO.setIdStradario( dto.getIdStradario() );
        istitutoDTO.setCivico( dto.getCivico() );
        istitutoDTO.setNumeroClassi( dto.getNumeroClassi() );
        istitutoDTO.setNumeroAlunni( dto.getNumeroAlunni() );
        istitutoDTO.setReferente( dto.getReferente() );
        istitutoDTO.setTelefono( dto.getTelefono() );
        istitutoDTO.setFax( dto.getFax() );
        istitutoDTO.setEmail( dto.getEmail() );
        istitutoDTO.setIdTipologiaIstituto( dto.getIdTipologiaIstituto() );
        istitutoDTO.setDataInizio( dto.getDataInizio() );
        istitutoDTO.setDataFine( dto.getDataFine() );
        istitutoDTO.setMeccanograficoPlesso( dto.getMeccanograficoPlesso() );
        istitutoDTO.setMeccanograficoScuola( dto.getMeccanograficoScuola() );
        istitutoDTO.setLatitudine( dto.getLatitudine() );
        istitutoDTO.setLongitudine( dto.getLongitudine() );
        istitutoDTO.setFlagTipoIstituto( dto.getFlagTipoIstituto() );
        istitutoDTO.setFlagAnticipo( dto.getFlagAnticipo() );
        istitutoDTO.setFlagPosticipo( dto.getFlagPosticipo() );
        istitutoDTO.setFlagTempoProlungato( dto.getFlagTempoProlungato() );
        istitutoDTO.setSicraCodiceVia( dto.getSicraCodiceVia() );
        istitutoDTO.setSicraCivico( dto.getSicraCivico() );
        istitutoDTO.setCodiceEsterno( dto.getCodiceEsterno() );

        return istitutoDTO;
    }

    @Override
    public IstitutoDTO fromUpdateDto(IstitutoUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        IstitutoDTO istitutoDTO = new IstitutoDTO();

        istitutoDTO.setId( dto.getId() );
        istitutoDTO.setIdEnte( dto.getIdEnte() );
        istitutoDTO.setDenominazione( dto.getDenominazione() );
        istitutoDTO.setPartitaIva( dto.getPartitaIva() );
        istitutoDTO.setIndirizzo( dto.getIndirizzo() );
        istitutoDTO.setIdStradario( dto.getIdStradario() );
        istitutoDTO.setCivico( dto.getCivico() );
        istitutoDTO.setNumeroClassi( dto.getNumeroClassi() );
        istitutoDTO.setNumeroAlunni( dto.getNumeroAlunni() );
        istitutoDTO.setReferente( dto.getReferente() );
        istitutoDTO.setTelefono( dto.getTelefono() );
        istitutoDTO.setFax( dto.getFax() );
        istitutoDTO.setEmail( dto.getEmail() );
        istitutoDTO.setIdTipologiaIstituto( dto.getIdTipologiaIstituto() );
        istitutoDTO.setDataInizio( dto.getDataInizio() );
        istitutoDTO.setDataFine( dto.getDataFine() );
        istitutoDTO.setMeccanograficoPlesso( dto.getMeccanograficoPlesso() );
        istitutoDTO.setMeccanograficoScuola( dto.getMeccanograficoScuola() );
        istitutoDTO.setLatitudine( dto.getLatitudine() );
        istitutoDTO.setLongitudine( dto.getLongitudine() );
        istitutoDTO.setFlagTipoIstituto( dto.getFlagTipoIstituto() );
        istitutoDTO.setFlagAnticipo( dto.getFlagAnticipo() );
        istitutoDTO.setFlagPosticipo( dto.getFlagPosticipo() );
        istitutoDTO.setFlagTempoProlungato( dto.getFlagTempoProlungato() );
        istitutoDTO.setSicraCodiceVia( dto.getSicraCodiceVia() );
        istitutoDTO.setSicraCivico( dto.getSicraCivico() );
        istitutoDTO.setCodiceEsterno( dto.getCodiceEsterno() );

        return istitutoDTO;
    }
}
