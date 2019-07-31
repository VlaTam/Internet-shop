package ru.tampashev.shop.services;

import ru.tampashev.shop.dto.Product;

import java.util.Collection;

public interface ProductService extends GenericService<Product> {

    Collection<Product> findAll();
}
