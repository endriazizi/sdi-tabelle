package it.iccs.simeal.sdi.configurazione.application.mapper;

import it.iccs.simeal.sdi.configurazione.application.model.AnnoModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AnnoCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AnnoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.AnnoUpdateDTO;
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
public class AnnoModelMapperImpl implements AnnoModelMapper {

    @Override
    public AnnoModel toModel(AnnoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AnnoModel annoModel = new AnnoModel();

        annoModel.setId( dto.getId() );
        annoModel.setAnno( dto.getAnno() );
        annoModel.setDescrizione( dto.getDescrizione() );
        annoModel.setAnnoCorrente( dto.getAnnoCorrente() );
        annoModel.setFlagCongelaAnno( dto.getFlagCongelaAnno() );
        annoModel.setFlagIseeCalcolo( dto.getFlagIseeCalcolo() );

        return annoModel;
    }

    @Override
    public AnnoDTO toDto(AnnoModel entity) {
        if ( entity == null ) {
            return null;
        }

        AnnoDTO annoDTO = new AnnoDTO();

        annoDTO.setId( entity.getId() );
        annoDTO.setAnno( entity.getAnno() );
        annoDTO.setDescrizione( entity.getDescrizione() );
        annoDTO.setAnnoCorrente( entity.getAnnoCorrente() );
        annoDTO.setFlagCongelaAnno( entity.getFlagCongelaAnno() );
        annoDTO.setFlagIseeCalcolo( entity.getFlagIseeCalcolo() );

        return annoDTO;
    }

    @Override
    public List<AnnoModel> toModel(List<AnnoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<AnnoModel> list = new ArrayList<AnnoModel>( dtoList.size() );
        for ( AnnoDTO annoDTO : dtoList ) {
            list.add( toModel( annoDTO ) );
        }

        return list;
    }

    @Override
    public List<AnnoDTO> toDto(List<AnnoModel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<AnnoDTO> list = new ArrayList<AnnoDTO>( entityList.size() );
        for ( AnnoModel annoModel : entityList ) {
            list.add( toDto( annoModel ) );
        }

        return list;
    }

    @Override
    public AnnoDTO fromCreateDto(AnnoCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AnnoDTO annoDTO = new AnnoDTO();

        annoDTO.setAnno( dto.getAnno() );
        annoDTO.setDescrizione( dto.getDescrizione() );
        annoDTO.setAnnoCorrente( dto.getAnnoCorrente() );
        annoDTO.setFlagCongelaAnno( dto.getFlagCongelaAnno() );
        annoDTO.setFlagIseeCalcolo( dto.getFlagIseeCalcolo() );

        return annoDTO;
    }

    @Override
    public AnnoDTO fromUpdateDto(AnnoUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        AnnoDTO annoDTO = new AnnoDTO();

        annoDTO.setId( dto.getId() );
        annoDTO.setAnno( dto.getAnno() );
        annoDTO.setDescrizione( dto.getDescrizione() );
        annoDTO.setAnnoCorrente( dto.getAnnoCorrente() );
        annoDTO.setFlagCongelaAnno( dto.getFlagCongelaAnno() );
        annoDTO.setFlagIseeCalcolo( dto.getFlagIseeCalcolo() );

        return annoDTO;
    }
}
