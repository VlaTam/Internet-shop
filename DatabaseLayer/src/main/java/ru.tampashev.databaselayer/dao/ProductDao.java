package ru.tampashev.databaselayer.dao;

import ru.tampashev.databaselayer.entities.Product;

public class ProductDao extends AbstractGenericDao<Product, Integer> {

    public ProductDao() {
        super(Product.class);
    }
}
