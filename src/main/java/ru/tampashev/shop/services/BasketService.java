package ru.tampashev.shop.services;

import ru.tampashev.shop.dto.Product;

public interface BasketService {

    boolean add();
    boolean delete(Product product);
}
