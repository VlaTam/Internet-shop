package ru.tampashev.shop.services;

import ru.tampashev.shop.dto.Order;
import ru.tampashev.shop.dto.Product;

import java.util.List;

public interface OrderService extends GenericService<Order> {

    List<Order> findUsersOrders();
}
