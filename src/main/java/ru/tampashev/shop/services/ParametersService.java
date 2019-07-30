package ru.tampashev.shop.services;

import ru.tampashev.shop.dto.Parameters;

import java.util.Collection;

public interface ParametersService extends GenericService<Parameters> {

    Collection<Parameters> findAll();
}
