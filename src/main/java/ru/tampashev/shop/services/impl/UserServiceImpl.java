package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.converters.Converter;
import ru.tampashev.shop.dao.GenericDao;
import ru.tampashev.shop.dao.UserDao;
import ru.tampashev.shop.dto.Role;
import ru.tampashev.shop.dto.User;
import ru.tampashev.shop.entities.UserEntity;
import ru.tampashev.shop.services.AddressService;
import ru.tampashev.shop.services.RoleService;
import ru.tampashev.shop.services.UserService;

@Service
public class UserServiceImpl extends AbstractGenericService<UserEntity, User> implements UserService {

    private final String roleCustomer = "customer";

    @Autowired
    private Converter<UserEntity, User> converter;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AddressService addressService;

    @Autowired
    private RoleService roleService;

    @Override
    protected Converter<UserEntity, User> getConverter() {
        return converter;
    }

    @Override
    protected GenericDao<UserEntity> getDao() {
        return userDao;
    }

    @Override
    public Integer find(User user) {
        UserEntity userEntity = converter.convertToEntity(user);
        return userDao.find(userEntity);
    }

    @Override
    public Integer create(User user) {
        if (find(user) > 0)
            return -1;

        setValidAddress(user);
        setValidRole(user);
        UserEntity userEntity = converter.convertToEntity(user);

        return userDao.create(userEntity);
    }

    private void setValidAddress(User user){
        Integer addressId = addressService.create(user.getAddress());
        user.getAddress().setId(addressId);
    }

    private void setValidRole(User user){
        Role role = new Role();
        role.setName(roleCustomer);
        Integer roleId = roleService.create(role);
        role.setId(roleId);
        user.setRole(role);
    }
}
