package ru.tampashev.shop.services;

import org.springframework.beans.factory.annotation.Autowired;
import ru.tampashev.shop.converters.Converter;
import ru.tampashev.shop.converters.RoleConverter;
import ru.tampashev.shop.dao.GenericDao;
import ru.tampashev.shop.dao.RoleDao;
import ru.tampashev.shop.dto.Role;
import ru.tampashev.shop.entities.RoleEntity;
import ru.tampashev.shop.services.impl.AbstractGenericService;

public class RoleServiceImpl extends AbstractGenericService<RoleEntity, Role> implements RoleService {

    @Autowired
    private RoleConverter roleConverter;

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
}
