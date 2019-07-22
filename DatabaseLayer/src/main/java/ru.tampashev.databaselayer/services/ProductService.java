package ru.tampashev.databaselayer.services;

import ru.tampashev.databaselayer.entities.ProductEntity;

import javax.transaction.Transactional;

@Transactional
public class ProductService {

    public void addProduct(ProductEntity productEntity){
        new ProductDao().create(productEntity);
    }
}
