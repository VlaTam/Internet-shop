package ru.tampashev.shop.converters;

import java.io.Serializable;

public abstract class AbstractConverter <E extends Serializable, D> implements Converter<E, D> {

    public D convertToDao(E entity) {
        return entity == null ? null : convertEntity(entity);
    }

    public E convertToEntity(D dto) {
        return dto == null ? null : convertDto(dto);
    }

    protected abstract D convertEntity(E entity);

    protected abstract E convertDto(D dto);
}
