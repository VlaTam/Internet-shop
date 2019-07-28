package ru.tampashev.shop.converters;

import ru.tampashev.shop.exceptions.ConverterException;

import java.io.Serializable;

public interface Converter <E extends Serializable, D> {

    D convertToDto(E entity) throws ConverterException;
    E convertToEntity(D dto) throws ConverterException;
}
