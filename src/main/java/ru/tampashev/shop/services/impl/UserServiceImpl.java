package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
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

    private final String roleCustomer = "ROLE_CUSTOMER";

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
    public User findByEmail(String email) {
        UserEntity userEntity = userDao.findByMailAddress(email);
        return userEntity != null ? userConverter.convertToDto(userEntity) : null;
    }

    @Override
    public Integer find(User user) {
        UserEntity userEntity = userConverter.convertToEntity(user);
        return userDao.find(userEntity);
    }

    @Override
    public Integer create(User user) {
        if(!user.getPassword().equals(user.getConfirmation()))
            return -1;

        setValidAddress(user);
        setValidRole(user);

        if (find(user) > 0)
            return -1;

        user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));

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
            user.setPassword(new BCryptPasswordEncoder().encode(user.getPassword()));
            UserEntity userEntity = userConverter.convertToEntity(user);
            userDao.update(userEntity);
            addressService.update(user.getAddress());
        }
    }
}
