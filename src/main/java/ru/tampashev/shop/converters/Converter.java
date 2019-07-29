package ru.tampashev.shop.converters;

import java.io.Serializable;

public interface Converter <E extends Serializable, D> {

    D convertToDto(E entity);
    E convertToEntity(D dto);
}
