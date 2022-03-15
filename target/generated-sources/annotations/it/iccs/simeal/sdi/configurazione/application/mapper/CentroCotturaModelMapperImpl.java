package it.iccs.simeal.sdi.configurazione.application.mapper;

import it.iccs.simeal.sdi.configurazione.application.model.CentroCotturaModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.CentroCotturaCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.CentroCotturaDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.CentroCotturaUpdateDTO;
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
public class CentroCotturaModelMapperImpl implements CentroCotturaModelMapper {

    @Override
    public CentroCotturaModel toModel(CentroCotturaDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CentroCotturaModel centroCotturaModel = new CentroCotturaModel();

        centroCotturaModel.setId( dto.getId() );
        centroCotturaModel.setDenominazione( dto.getDenominazione() );
        centroCotturaModel.setIndirizzo( dto.getIndirizzo() );
        centroCotturaModel.setCivico( dto.getCivico() );
        centroCotturaModel.setCitta( dto.getCitta() );
        centroCotturaModel.setProvincia( dto.getProvincia() );
        centroCotturaModel.setReferente( dto.getReferente() );
        centroCotturaModel.setTelefono( dto.getTelefono() );
        centroCotturaModel.setFax( dto.getFax() );
        centroCotturaModel.setEmail( dto.getEmail() );
        centroCotturaModel.setPec( dto.getPec() );
        centroCotturaModel.setFlagElimina( dto.getFlagElimina() );

        return centroCotturaModel;
    }

    @Override
    public CentroCotturaDTO toDto(CentroCotturaModel entity) {
        if ( entity == null ) {
            return null;
        }

        CentroCotturaDTO centroCotturaDTO = new CentroCotturaDTO();

        centroCotturaDTO.setId( entity.getId() );
        centroCotturaDTO.setDenominazione( entity.getDenominazione() );
        centroCotturaDTO.setIndirizzo( entity.getIndirizzo() );
        centroCotturaDTO.setCivico( entity.getCivico() );
        centroCotturaDTO.setCitta( entity.getCitta() );
        centroCotturaDTO.setProvincia( entity.getProvincia() );
        centroCotturaDTO.setReferente( entity.getReferente() );
        centroCotturaDTO.setTelefono( entity.getTelefono() );
        centroCotturaDTO.setFax( entity.getFax() );
        centroCotturaDTO.setEmail( entity.getEmail() );
        centroCotturaDTO.setPec( entity.getPec() );
        centroCotturaDTO.setFlagElimina( entity.getFlagElimina() );

        return centroCotturaDTO;
    }

    @Override
    public List<CentroCotturaModel> toModel(List<CentroCotturaDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<CentroCotturaModel> list = new ArrayList<CentroCotturaModel>( dtoList.size() );
        for ( CentroCotturaDTO centroCotturaDTO : dtoList ) {
            list.add( toModel( centroCotturaDTO ) );
        }

        return list;
    }

    @Override
    public List<CentroCotturaDTO> toDto(List<CentroCotturaModel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<CentroCotturaDTO> list = new ArrayList<CentroCotturaDTO>( entityList.size() );
        for ( CentroCotturaModel centroCotturaModel : entityList ) {
            list.add( toDto( centroCotturaModel ) );
        }

        return list;
    }

    @Override
    public CentroCotturaDTO fromCreateDto(CentroCotturaCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CentroCotturaDTO centroCotturaDTO = new CentroCotturaDTO();

        centroCotturaDTO.setId( dto.getId() );
        centroCotturaDTO.setDenominazione( dto.getDenominazione() );
        centroCotturaDTO.setIndirizzo( dto.getIndirizzo() );
        centroCotturaDTO.setCivico( dto.getCivico() );
        centroCotturaDTO.setCitta( dto.getCitta() );
        centroCotturaDTO.setProvincia( dto.getProvincia() );
        centroCotturaDTO.setReferente( dto.getReferente() );
        centroCotturaDTO.setTelefono( dto.getTelefono() );
        centroCotturaDTO.setFax( dto.getFax() );
        centroCotturaDTO.setEmail( dto.getEmail() );
        centroCotturaDTO.setPec( dto.getPec() );

        return centroCotturaDTO;
    }

    @Override
    public CentroCotturaDTO fromUpdateDto(CentroCotturaUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        CentroCotturaDTO centroCotturaDTO = new CentroCotturaDTO();

        centroCotturaDTO.setId( dto.getId() );
        centroCotturaDTO.setDenominazione( dto.getDenominazione() );
        centroCotturaDTO.setIndirizzo( dto.getIndirizzo() );
        centroCotturaDTO.setCivico( dto.getCivico() );
        centroCotturaDTO.setCitta( dto.getCitta() );
        centroCotturaDTO.setProvincia( dto.getProvincia() );
        centroCotturaDTO.setReferente( dto.getReferente() );
        centroCotturaDTO.setTelefono( dto.getTelefono() );
        centroCotturaDTO.setFax( dto.getFax() );
        centroCotturaDTO.setEmail( dto.getEmail() );
        centroCotturaDTO.setPec( dto.getPec() );

        return centroCotturaDTO;
    }
}
