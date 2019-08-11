package ru.tampashev.shop.dao;

import ru.tampashev.shop.entities.OrderProductEntity;

import java.util.List;

public interface OrderProductDao extends GenericDao<OrderProductEntity> {

    List<OrderProductEntity> findByOrderId(Integer orderId);
}
