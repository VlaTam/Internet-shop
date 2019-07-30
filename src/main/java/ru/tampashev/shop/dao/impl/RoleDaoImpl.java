package ru.tampashev.shop.dao.impl;

import ru.tampashev.shop.dao.RoleDao;
import ru.tampashev.shop.entities.RoleEntity;

public class RoleDaoImpl extends AbstractGenericDao<RoleEntity> implements RoleDao {

    public RoleDaoImpl() {
        type = RoleEntity.class;
    }
}
