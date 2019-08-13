package ru.tampashev.shop.dao;

import ru.tampashev.shop.entities.ParametersEntity;
import ru.tampashev.shop.entities.ProductEntity;

import java.util.List;

public interface ProductDao extends GenericDao<ProductEntity> {

    List<ProductEntity> findAll();

    List<ProductEntity> findByParameters(ParametersEntity parametersEntity);
}
