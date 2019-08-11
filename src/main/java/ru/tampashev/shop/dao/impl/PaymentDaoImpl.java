package ru.tampashev.shop.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tampashev.shop.dao.PaymentDao;
import ru.tampashev.shop.entities.PaymentEntity;

@Repository
public class PaymentDaoImpl extends AbstractGenericDao<PaymentEntity> implements PaymentDao {

    public PaymentDaoImpl() {
        type = PaymentEntity.class;
    }

    @Override
    public Integer find(PaymentEntity paymentEntity) {
        PaymentEntity existedPayment = getSession()
                                            .createNamedQuery("payment-find", type)
                                            .setParameter("method", paymentEntity.getMethod())
                                            .setParameter("paymentStatus", paymentEntity.getPaymentStatus())
                                            .uniqueResult();

        return existedPayment != null ? existedPayment.getId() : -1;
    }
}
