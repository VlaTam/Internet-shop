package ru.tampashev.shop.dao.impl;

import ru.tampashev.shop.dao.ParametersDao;
import ru.tampashev.shop.entities.ParametersEntity;

public class ParametersDaoImpl extends AbstractGenericDao<ParametersEntity> implements ParametersDao {

    public ParametersDaoImpl(){
        type = ParametersEntity.class;
    }
}
