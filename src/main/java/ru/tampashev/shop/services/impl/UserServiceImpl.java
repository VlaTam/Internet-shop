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

import javax.transaction.Transactional;

@Service
@Transactional
public class UserServiceImpl extends AbstractGenericService<UserEntity, User> implements UserService {

    private final String roleCustomer = "customer";

    @Autowired
    private Converter<UserEntity, User> userConverter;

    @Autowired
    private UserDao userDao;

    @Autowired
    private AddressService addressService;

    @Autowired
    private RoleService roleService;

    @Override
    protected Converter<UserEntity, User> getConverter() {
        return userConverter;
    }

    @Override
    protected GenericDao<UserEntity> getDao() {
        return userDao;
    }

    @Override
    public Integer find(User user) {
        UserEntity userEntity = userConverter.convertToEntity(user);
        return userDao.find(userEntity);
    }

    @Override
    public Integer create(User user) {
        if (find(user) > 0)
            return -1;

        setValidAddress(user);
        setValidRole(user);
        UserEntity userEntity = userConverter.convertToEntity(user);

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

    @Override
    public void update(User user) {
        String password = user.getPassword();
        String confirmation = user.getConfirmation();
        if (password.equals(confirmation)){
            UserEntity userEntity = userConverter.convertToEntity(user);
            userDao.update(userEntity);
            addressService.update(user.getAddress());
        }
    }
}
