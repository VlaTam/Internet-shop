package ru.tampashev.shop.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tampashev.shop.dao.PaymentDao;
import ru.tampashev.shop.entities.PaymentEntity;

@Repository
public class PaymentDaoImpl extends AbstractGenericDao<PaymentEntity> implements PaymentDao {

    public PaymentDaoImpl() {
        type = PaymentEntity.class;
    }
}
