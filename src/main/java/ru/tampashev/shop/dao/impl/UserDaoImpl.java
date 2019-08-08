package ru.tampashev.shop.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tampashev.shop.dao.UserDao;
import ru.tampashev.shop.entities.UserEntity;

@Repository
public class UserDaoImpl extends AbstractGenericDao<UserEntity> implements UserDao {

    public UserDaoImpl() {
        type = UserEntity.class;
    }

    @Override
    public UserEntity findByMailAddress(String mailAddress) {
        return getSession().createNamedQuery("user-find-by-email", type)
                                .setParameter("mailAddress", mailAddress).uniqueResult();
    }
}
