package ru.tampashev.shop.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tampashev.shop.dao.RoleDao;
import ru.tampashev.shop.entities.RoleEntity;

@Repository
public class RoleDaoImpl extends AbstractGenericDao<RoleEntity> implements RoleDao {

    public RoleDaoImpl() {
        type = RoleEntity.class;
    }

    @Override
    public RoleEntity findByName(String name) {
        return  getSession().createNamedQuery("role-find-by-name", type)
                .setParameter("name", name).getSingleResult();
    }
}
