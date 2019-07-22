package ru.tampashev.databaselayer.dao.impl;

import ru.tampashev.databaselayer.entities.UserEntity;

public class UserDao extends AbstractGenericDao<UserEntity, Integer> {

    public UserDao(Class<UserEntity> type) {
        super(type);
    }
}
