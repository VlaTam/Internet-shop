package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.converters.Converter;
import ru.tampashev.shop.dao.GenericDao;
import ru.tampashev.shop.dao.PaymentDao;
import ru.tampashev.shop.dto.Payment;
import ru.tampashev.shop.entities.PaymentEntity;
import ru.tampashev.shop.services.PaymentService;

@Service
public class PaymentServiceImpl extends AbstractGenericService<PaymentEntity, Payment> implements PaymentService {

    @Autowired
    @Qualifier("paymentConverter")
    private Converter<PaymentEntity, Payment> paymentConverter;

    @Autowired
    private PaymentDao paymentDao;

    @Override
    protected Converter<PaymentEntity, Payment> getConverter() {
        return paymentConverter;
    }

    @Override
    protected GenericDao<PaymentEntity> getDao() {
        return paymentDao;
    }

    @Override
    public Integer find(Payment payment) {
        PaymentEntity paymentEntity = paymentConverter.convertToEntity(payment);
        return paymentDao.find(paymentEntity);
    }
}
