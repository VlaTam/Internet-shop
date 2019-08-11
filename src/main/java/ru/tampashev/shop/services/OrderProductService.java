package ru.tampashev.shop.services;

import ru.tampashev.shop.dto.OrderProduct;

import java.util.List;

public interface OrderProductService extends GenericService<OrderProduct> {

    List<OrderProduct> findByOrderId(Integer orderId);
}
