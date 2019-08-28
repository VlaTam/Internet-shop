package ru.tampashev.shop.dao;

import ru.tampashev.shop.entities.DeliveryEntity;
import ru.tampashev.shop.entities.OrderEntity;
import ru.tampashev.shop.entities.PaymentEntity;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public interface OrderDao extends GenericDao<OrderEntity> {

    List<OrderEntity> findUsersOrders(Integer userId);

    List<OrderEntity> findByStatus(DeliveryEntity deliveryEntity, PaymentEntity paymentEntity);

    List<OrderEntity> findActiveOrders();

    BigDecimal getProfit(Date startOfPeriod, Date endOfPeriod);
}
