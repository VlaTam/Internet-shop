package ru.tampashev.shop.services;

import ru.tampashev.shop.dto.Product;

public interface BinService {

    boolean add(Product product, Integer quantity);
}
