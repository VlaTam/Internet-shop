package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.converters.Converter;
import ru.tampashev.shop.dao.AddressDao;
import ru.tampashev.shop.dao.GenericDao;
import ru.tampashev.shop.dao.UserDao;
import ru.tampashev.shop.dto.Role;
import ru.tampashev.shop.dto.User;
import ru.tampashev.shop.entities.AddressEntity;
import ru.tampashev.shop.entities.UserEntity;
import ru.tampashev.shop.exceptions.ObjectAlreadyExistException;
import ru.tampashev.shop.services.AddressService;
import ru.tampashev.shop.services.RoleService;
import ru.tampashev.shop.services.UserService;

@Service
public class UserServiceImpl extends AbstractGenericService<UserEntity, User> implements UserService {

    private final String roleName = "customer";

    @Autowired
    private Converter<UserEntity, User> converter;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AddressDao addressDao;

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
    public User findByMailAddress(String mailAddress) {
        UserEntity userEntity = userDao.findByMailAddress(mailAddress);
        return converter.convertToDto(userEntity);
    }

    //TODO: override method create instead of register, check user on valid
    @Override
    public Integer create(User user) throws ObjectAlreadyExistException {
        Role role = roleService.findByName(roleName);
        user.setRole(role);


        AddressEntity addressEntity =

        Integer addressId = addressDao.find(user.getAddress());
        if (addressId < 0)
            addressId = addressDao.create(user.getAddress());
        user.getAddress().setId(addressId);

        UserEntity userEntity = converter.convertToEntity(user);
        return userDao.create(userEntity);
    }


}
