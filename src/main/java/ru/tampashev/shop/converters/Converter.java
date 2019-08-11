package ru.tampashev.shop.converters;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.List;

public interface Converter <E extends Serializable, D> {

    D convertToDto(E entity);
    E convertToEntity(D dto);

    default List<D> convertToDtoList(List<E> entityList){
        return new ArrayList<>();
    }

    default List<E> convertToEntityList(List<D> dtoList){
        return new ArrayList<>();
    }
}
