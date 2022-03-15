package it.iccs.simeal.sdi.configurazione.application.mapper;

import it.iccs.simeal.sdi.configurazione.application.model.ClasseModel;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseCreateDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseDTO;
import it.iccs.simeal.sdi.configurazione.application.port.inbound.service.model.ClasseUpdateDTO;
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
public class ClasseModelMapperImpl implements ClasseModelMapper {

    @Override
    public ClasseModel toModel(ClasseDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ClasseModel classeModel = new ClasseModel();

        classeModel.setId( dto.getId() );
        classeModel.setDescrizione( dto.getDescrizione() );
        classeModel.setFlagElimina( dto.getFlagElimina() );

        return classeModel;
    }

    @Override
    public ClasseDTO toDto(ClasseModel entity) {
        if ( entity == null ) {
            return null;
        }

        ClasseDTO classeDTO = new ClasseDTO();

        classeDTO.setId( entity.getId() );
        classeDTO.setDescrizione( entity.getDescrizione() );
        classeDTO.setFlagElimina( entity.getFlagElimina() );

        return classeDTO;
    }

    @Override
    public List<ClasseModel> toModel(List<ClasseDTO> dtoList) {
        if ( dtoList == null ) {
            return null;
        }

        List<ClasseModel> list = new ArrayList<ClasseModel>( dtoList.size() );
        for ( ClasseDTO classeDTO : dtoList ) {
            list.add( toModel( classeDTO ) );
        }

        return list;
    }

    @Override
    public List<ClasseDTO> toDto(List<ClasseModel> entityList) {
        if ( entityList == null ) {
            return null;
        }

        List<ClasseDTO> list = new ArrayList<ClasseDTO>( entityList.size() );
        for ( ClasseModel classeModel : entityList ) {
            list.add( toDto( classeModel ) );
        }

        return list;
    }

    @Override
    public ClasseDTO fromCreateDto(ClasseCreateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ClasseDTO classeDTO = new ClasseDTO();

        classeDTO.setDescrizione( dto.getDescrizione() );

        return classeDTO;
    }

    @Override
    public ClasseDTO fromUpdateDto(ClasseUpdateDTO dto) {
        if ( dto == null ) {
            return null;
        }

        ClasseDTO classeDTO = new ClasseDTO();

        classeDTO.setId( dto.getId() );
        classeDTO.setDescrizione( dto.getDescrizione() );

        return classeDTO;
    }
}
