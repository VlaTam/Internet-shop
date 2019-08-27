package ru.tampashev.shop.dao;

import ru.tampashev.shop.entities.UserEntity;

import java.util.List;

public interface UserDao extends GenericDao<UserEntity> {

    UserEntity findByMailAddress(String mailAddress);

    List<UserEntity> getTopTenUsers();
}
