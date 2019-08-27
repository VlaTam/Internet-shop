package ru.tampashev.shop.dao;

import ru.tampashev.shop.entities.OrderProductEntity;
import ru.tampashev.shop.entities.ProductEntity;

import java.util.List;

public interface OrderProductDao extends GenericDao<OrderProductEntity> {

    List<OrderProductEntity> findByOrderId(Integer orderId);
}
