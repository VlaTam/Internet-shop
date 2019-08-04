package ru.tampashev.shop.dao;

import ru.tampashev.shop.entities.UserEntity;

public interface UserDao extends GenericDao<UserEntity> {

    UserEntity findByMailAddress(String mailAddress);
}
