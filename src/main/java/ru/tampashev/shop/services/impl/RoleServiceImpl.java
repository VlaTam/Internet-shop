package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.converters.Converter;
import ru.tampashev.shop.dao.GenericDao;
import ru.tampashev.shop.dao.RoleDao;
import ru.tampashev.shop.dto.Role;
import ru.tampashev.shop.entities.RoleEntity;
import ru.tampashev.shop.services.RoleService;

@Service
public class RoleServiceImpl extends AbstractGenericService<RoleEntity, Role> implements RoleService {

    @Autowired
    private Converter<RoleEntity, Role> roleConverter;

    @Autowired
    private RoleDao roleDao;

    @Override
    protected Converter<RoleEntity, Role> getConverter() {
        return roleConverter;
    }

    @Override
    protected GenericDao<RoleEntity> getDao() {
        return roleDao;
    }

    @Override
    public Integer find(Role role){
        RoleEntity roleEntity = roleConverter.convertToEntity(role);
        return roleDao.find(roleEntity);
    }
}
