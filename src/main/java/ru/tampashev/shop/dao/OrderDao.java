package ru.tampashev.shop.dao;

import ru.tampashev.shop.entities.OrderEntity;

import java.util.List;

public interface OrderDao extends GenericDao<OrderEntity> {

    List<OrderEntity> findUsersOrders(Integer userId);
}
