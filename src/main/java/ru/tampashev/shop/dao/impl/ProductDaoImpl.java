package ru.tampashev.shop.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tampashev.shop.dao.ProductDao;
import ru.tampashev.shop.entities.ProductEntity;

import java.util.Collection;

@Repository
public class ProductDaoImpl extends AbstractGenericDao<ProductEntity> implements ProductDao {

    public ProductDaoImpl() {
        type = ProductEntity.class;
    }
}
