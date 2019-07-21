package ru.tampashev.databaselayer.dao;

import ru.tampashev.databaselayer.entities.User;

public class UserDao extends AbstractGenericDao<User, Integer> {

    public UserDao(Class<User> type) {
        super(type);
    }
}
