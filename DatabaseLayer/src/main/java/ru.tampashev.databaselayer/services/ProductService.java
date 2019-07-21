package ru.tampashev.databaselayer.services;

import ru.tampashev.databaselayer.dao.ProductDao;
import ru.tampashev.databaselayer.entities.Product;

import javax.transaction.Transactional;

@Transactional
public class ProductService {

    public void addProduct(Product product){
        new ProductDao().create(product);
    }
}
