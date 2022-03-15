package it.iccs.simeal.sdi.configurazione.application.mapper;

import it.iccs.simeal.sdi.configurazione.application.model.ServizioAnnoModel;
import it.iccs.simeal.sdi.configurazione.application.model.ServizioModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioAnnoCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioAnnoCreateDTO.ServizioInnerDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioAnnoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioAnnoUpdateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ServizioDTO;
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
public class ServizioAnnoModelMapperImpl implements ServizioAnnoModelMapper {

    @Override
    public ServizioAnnoModel toModel(ServizioAnnoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ServizioAnnoModel servizioAnnoModel = new ServizioAnnoModel();

        servizioAnnoModel.setId( dto.getId() );
        servizioAnnoModel.setAnno( dto.getAnno() );
        servizioAnnoModel.setServizio( servizioDTOToServizioModel( dto.getServizio() ) );
        servizioAnnoModel.setTipologiaRilevazione( dto.getTipologiaRilevazione() );

        return servizioAnnoModel;
    }

    @Override
    public ServizioAnnoDTO toDto(ServizioAnnoModel entity) {
        if ( entity == null ) {
            return null;
        }

        ServizioAnnoDTO servizioAnnoDTO = new ServizioAnnoDTO();

        servizioAnnoDTO.setId( entity.getId() );
        servizioAnnoDTO.setServizio( servizioModelToServizioDTO( entity.getServizio() ) );
        servizioAnnoDTO.setAnno( entity.getAnno() );
        servizioAnnoDTO.setTipologiaRilevazione( entity.getTipologiaRilevazione() );

        return servizioAnnoDTO;
    }

    @Override
    public List<ServizioAnnoModel> toModel(List<ServizioAnnoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ServizioAnnoModel> list = new ArrayList<ServizioAnnoModel>( dtoList.size() );
        for ( ServizioAnnoDTO servizioAnnoDTO : dtoList ) {
            list.add( toModel( servizioAnnoDTO ) );
        }

        return list;
    }

    @Override
    public List<ServizioAnnoDTO> toDto(List<ServizioAnnoModel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ServizioAnnoDTO> list = new ArrayList<ServizioAnnoDTO>( entityList.size() );
        for ( ServizioAnnoModel servizioAnnoModel : entityList ) {
            list.add( toDto( servizioAnnoModel ) );
        }

        return list;
    }

    @Override
    public ServizioAnnoDTO fromCreateDto(ServizioAnnoCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ServizioAnnoDTO servizioAnnoDTO = new ServizioAnnoDTO();

        servizioAnnoDTO.setServizio( servizioInnerDTOToServizioDTO( dto.getServizio() ) );
        servizioAnnoDTO.setAnno( dto.getAnno() );
        servizioAnnoDTO.setTipologiaRilevazione( dto.getTipologiaRilevazione() );

        return servizioAnnoDTO;
    }

    @Override
    public ServizioAnnoDTO fromUpdateDto(ServizioAnnoUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ServizioAnnoDTO servizioAnnoDTO = new ServizioAnnoDTO();

        servizioAnnoDTO.setId( dto.getId() );
        servizioAnnoDTO.setServizio( servizioInnerDTOToServizioDTO1( dto.getServizio() ) );
        servizioAnnoDTO.setAnno( dto.getAnno() );
        servizioAnnoDTO.setTipologiaRilevazione( dto.getTipologiaRilevazione() );

        return servizioAnnoDTO;
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

    protected ServizioDTO servizioInnerDTOToServizioDTO(ServizioInnerDTO servizioInnerDTO) {
        if ( servizioInnerDTO == null ) {
            return null;
        }

        ServizioDTO servizioDTO = new ServizioDTO();

        servizioDTO.setId( servizioInnerDTO.getId() );

        return servizioDTO;
    }

    protected ServizioDTO servizioInnerDTOToServizioDTO1(it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AbstractServizioDTO.ServizioInnerDTO servizioInnerDTO) {
        if ( servizioInnerDTO == null ) {
            return null;
        }

        ServizioDTO servizioDTO = new ServizioDTO();

        servizioDTO.setId( servizioInnerDTO.getId() );

        return servizioDTO;
    }
}
