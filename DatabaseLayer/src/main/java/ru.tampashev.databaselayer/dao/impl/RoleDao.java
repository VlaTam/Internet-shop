package ru.tampashev.databaselayer.dao.impl;

import ru.tampashev.databaselayer.entities.RoleEntity;

public class RoleDao extends AbstractGenericDao<RoleEntity, Integer> {

    public RoleDao(Class<RoleEntity> type) {
        super(type);
    }
}
