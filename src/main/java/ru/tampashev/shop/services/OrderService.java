package ru.tampashev.shop.services;

import ru.tampashev.shop.dto.Order;
import ru.tampashev.shop.dto.OrderStatus;

import java.util.List;

public interface OrderService extends GenericService<Order> {

    List<Order> findUsersOrders();

    List<Order> findByStatus(OrderStatus orderStatus);

    List<Order> findActiveOrders();

    Integer changeStatus(Order order);
}
