package ru.tampashev.shop.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tampashev.shop.dao.OrderDao;
import ru.tampashev.shop.entities.OrderEntity;

@Repository
public class OrderDaoImpl extends AbstractGenericDao<OrderEntity> implements OrderDao {

    public OrderDaoImpl() {
        type = OrderEntity.class;
    }
}
