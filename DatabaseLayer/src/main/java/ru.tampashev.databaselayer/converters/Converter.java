package ru.tampashev.databaselayer.converters;

import java.util.Set;

public interface Converter <E, D> {

    D convertToDao(E entity);
    Set<D> convertToDaoSet(Set<E> entities);
    E convertToEntity(D dao);
    Set<E> convertToEntitySet(Set<D> daoSet);
}
