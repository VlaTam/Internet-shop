package ru.tampashev.shop.dao;

import ru.tampashev.shop.entities.AddressEntity;

import java.util.Collection;

public interface AddressDao extends GenericDao<AddressEntity> {

    Collection<AddressEntity> findAll();
}
