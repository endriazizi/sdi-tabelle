package it.iccs.simeal.sdi.configurazione.application.mapper;

import it.iccs.simeal.sdi.configurazione.application.model.PastoAlternativoModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.PastoAlternativoCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.PastoAlternativoDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.PastoAlternativoUpdateDTO;
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
public class PastoAlternativoModelMapperImpl implements PastoAlternativoModelMapper {

    @Override
    public PastoAlternativoModel toModel(PastoAlternativoDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PastoAlternativoModel pastoAlternativoModel = new PastoAlternativoModel();

        pastoAlternativoModel.setId( dto.getId() );
        pastoAlternativoModel.setDescrizione( dto.getDescrizione() );
        pastoAlternativoModel.setFlagAbilitato( dto.getFlagAbilitato() );
        pastoAlternativoModel.setOrdinePasto( dto.getOrdinePasto() );

        return pastoAlternativoModel;
    }

    @Override
    public PastoAlternativoDTO toDto(PastoAlternativoModel entity) {
        if ( entity == null ) {
            return null;
        }

        PastoAlternativoDTO pastoAlternativoDTO = new PastoAlternativoDTO();

        pastoAlternativoDTO.setId( entity.getId() );
        pastoAlternativoDTO.setDescrizione( entity.getDescrizione() );
        pastoAlternativoDTO.setFlagAbilitato( entity.getFlagAbilitato() );
        pastoAlternativoDTO.setOrdinePasto( entity.getOrdinePasto() );

        return pastoAlternativoDTO;
    }

    @Override
    public List<PastoAlternativoModel> toModel(List<PastoAlternativoDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<PastoAlternativoModel> list = new ArrayList<PastoAlternativoModel>( dtoList.size() );
        for ( PastoAlternativoDTO pastoAlternativoDTO : dtoList ) {
            list.add( toModel( pastoAlternativoDTO ) );
        }

        return list;
    }

    @Override
    public List<PastoAlternativoDTO> toDto(List<PastoAlternativoModel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<PastoAlternativoDTO> list = new ArrayList<PastoAlternativoDTO>( entityList.size() );
        for ( PastoAlternativoModel pastoAlternativoModel : entityList ) {
            list.add( toDto( pastoAlternativoModel ) );
        }

        return list;
    }

    @Override
    public PastoAlternativoDTO fromCreateDto(PastoAlternativoCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PastoAlternativoDTO pastoAlternativoDTO = new PastoAlternativoDTO();

        pastoAlternativoDTO.setDescrizione( dto.getDescrizione() );
        pastoAlternativoDTO.setOrdinePasto( dto.getOrdinePasto() );

        return pastoAlternativoDTO;
    }

    @Override
    public PastoAlternativoDTO fromUpdateDto(PastoAlternativoUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        PastoAlternativoDTO pastoAlternativoDTO = new PastoAlternativoDTO();

        pastoAlternativoDTO.setId( dto.getId() );
        pastoAlternativoDTO.setDescrizione( dto.getDescrizione() );
        pastoAlternativoDTO.setOrdinePasto( dto.getOrdinePasto() );

        return pastoAlternativoDTO;
    }
}
