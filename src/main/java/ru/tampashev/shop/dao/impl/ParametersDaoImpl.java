package ru.tampashev.shop.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tampashev.shop.dao.ParametersDao;
import ru.tampashev.shop.entities.ParametersEntity;

@Repository
public class ParametersDaoImpl extends AbstractGenericDao<ParametersEntity> implements ParametersDao {

    public ParametersDaoImpl(){
        type = ParametersEntity.class;
    }
}
