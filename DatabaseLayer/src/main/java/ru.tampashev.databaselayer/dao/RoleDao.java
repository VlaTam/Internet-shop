package ru.tampashev.databaselayer.dao;

import ru.tampashev.databaselayer.entities.Role;

public class RoleDao extends AbstractGenericDao<Role, Integer> {

    public RoleDao(Class<Role> type) {
        super(type);
    }
}
