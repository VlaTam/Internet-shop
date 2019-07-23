package ru.tampashev.shop.converters;

import java.io.Serializable;

public interface Converter <E extends Serializable, D> {

    D convertToDao(E entity);
    E convertToEntity(D dto);
}
