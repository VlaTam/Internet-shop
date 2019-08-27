package ru.tampashev.shop.services;

import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.dto.User;

import java.util.List;

public interface StatisticsService {

    List<Product> getTopTenProducts();

    List<User> getTopTenUsers();
}
