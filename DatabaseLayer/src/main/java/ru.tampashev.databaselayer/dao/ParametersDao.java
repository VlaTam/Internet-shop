package ru.tampashev.databaselayer.dao;

import ru.tampashev.databaselayer.entities.Parameters;

public class ParametersDao extends AbstractGenericDao<Parameters, Integer> {

    public ParametersDao(Class<Parameters> type) {
        super(type);
    }
}
