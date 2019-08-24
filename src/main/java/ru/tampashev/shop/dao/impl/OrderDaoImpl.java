package ru.tampashev.shop.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tampashev.shop.dao.OrderDao;
import ru.tampashev.shop.entities.OrderEntity;

import java.util.List;

@Repository
public class OrderDaoImpl extends AbstractGenericDao<OrderEntity> implements OrderDao {

    public OrderDaoImpl() {
        type = OrderEntity.class;
    }

    @Override
    public List<OrderEntity> findUsersOrders(Integer userId) {
        return getSession()
                .createNamedQuery("order-find-history-of-user", type)
                .setParameter("userId", userId)
                .getResultList();
    }
}
