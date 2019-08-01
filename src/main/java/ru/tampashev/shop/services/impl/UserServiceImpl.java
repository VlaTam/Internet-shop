package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.converters.Converter;
import ru.tampashev.shop.dao.GenericDao;
import ru.tampashev.shop.dao.UserDao;
import ru.tampashev.shop.dto.User;
import ru.tampashev.shop.entities.UserEntity;
import ru.tampashev.shop.services.UserService;

@Service
public class UserServiceImpl extends AbstractGenericService<UserEntity, User> implements UserService {

    @Autowired
    @Qualifier("userConverter")
    private Converter<UserEntity, User> converter;

    @Autowired
    private UserDao userDao;

    @Override
    protected Converter<UserEntity, User> getConverter() {
        return converter;
    }

    @Override
    protected GenericDao<UserEntity> getDao() {
        return userDao;
    }
}
