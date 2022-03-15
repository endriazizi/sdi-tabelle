package it.iccs.simeal.sdi.configurazione.application.mapper;

import java.util.List;

public interface ModelMapper<D, E> {
	
	E toModel(D dto);

    D toDto(E entity);

    List <E> toModel(List<D> dtoList);
    
    List <D> toDto(List<E> entityList);

}
