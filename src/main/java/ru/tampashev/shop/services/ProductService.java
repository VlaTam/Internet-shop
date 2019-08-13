package ru.tampashev.shop.services;

import ru.tampashev.shop.dto.Parameters;
import ru.tampashev.shop.dto.Product;

import java.util.List;

public interface ProductService extends GenericService<Product> {

    List<Product> findAll();

    List<Product> findByParameters(Parameters parameters);
}
