package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.converters.Converter;
import ru.tampashev.shop.converters.ParametersConverter;
import ru.tampashev.shop.dao.GenericDao;
import ru.tampashev.shop.dao.ParametersDao;
import ru.tampashev.shop.dto.Parameters;
import ru.tampashev.shop.entities.ParametersEntity;
import ru.tampashev.shop.services.ParametersService;

@Service
public class ParametersServiceImpl extends AbstractGenericService<ParametersEntity, Parameters> implements ParametersService {

    @Autowired
    private ParametersDao parametersDao;

    @Autowired
    private ParametersConverter parametersConverter;

    @Override
    protected Converter<ParametersEntity, Parameters> getConverter() {
        return parametersConverter;
    }

    @Override
    protected GenericDao<ParametersEntity> getDao() {
        return parametersDao;
    }
}
