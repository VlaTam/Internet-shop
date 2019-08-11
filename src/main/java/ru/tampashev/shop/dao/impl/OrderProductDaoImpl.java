package ru.tampashev.shop.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tampashev.shop.dao.OrderProductDao;
import ru.tampashev.shop.entities.OrderProductEntity;

import java.util.List;

@Repository
public class OrderProductDaoImpl extends AbstractGenericDao<OrderProductEntity> implements OrderProductDao {

    public OrderProductDaoImpl() {
        type = OrderProductEntity.class;
    }

    @Override
    public List<OrderProductEntity> findByOrderId(Integer orderId) {
        return getSession()
                    .createNamedQuery("orderProduct-find-by-orderId", type)
                    .setParameter("orderId", orderId)
                    .getResultList();
    }
}
