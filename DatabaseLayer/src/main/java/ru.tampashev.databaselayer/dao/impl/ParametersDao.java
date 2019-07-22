package ru.tampashev.databaselayer.dao.impl;

import ru.tampashev.databaselayer.entities.ParametersEntity;

public class ParametersDao extends AbstractGenericDao<ParametersEntity, Integer> {

    public ParametersDao(Class<ParametersEntity> type) {
        super(type);
    }
}
