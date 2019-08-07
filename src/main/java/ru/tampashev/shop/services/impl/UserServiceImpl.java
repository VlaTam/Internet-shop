package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.converters.Converter;
import ru.tampashev.shop.dao.GenericDao;
import ru.tampashev.shop.dao.UserDao;
import ru.tampashev.shop.dto.User;
import ru.tampashev.shop.entities.UserEntity;
import ru.tampashev.shop.services.UserService;
import ru.tampashev.shop.transfer.ResponseTransfer;

@Service
public class UserServiceImpl extends AbstractGenericService<UserEntity, User> implements UserService {

    @Autowired
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

    @Override
    public User findByMailAddress(String mailAddress) {
        UserEntity userEntity = userDao.findByMailAddress(mailAddress);
        return converter.convertToDto(userEntity);
    }

    @Override
    public ResponseTransfer authorize(User user) {
        ResponseTransfer responseTransfer = new ResponseTransfer();

        User validUser = findByMailAddress(user.getMailAddress());
        if (validUser != null)
            responseTransfer.setAuthorized(true);
        return responseTransfer;
    }
}
