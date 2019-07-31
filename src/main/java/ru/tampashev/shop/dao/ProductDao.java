package ru.tampashev.shop.dao;

import ru.tampashev.shop.entities.ProductEntity;

import java.util.Collection;

public interface ProductDao extends GenericDao<ProductEntity> {

    Collection<ProductEntity> findAll();
}
