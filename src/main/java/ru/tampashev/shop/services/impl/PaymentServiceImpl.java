package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.converters.Converter;
import ru.tampashev.shop.dao.GenericDao;
import ru.tampashev.shop.dao.PaymentDao;
import ru.tampashev.shop.dto.Payment;
import ru.tampashev.shop.entities.PaymentEntity;
import ru.tampashev.shop.services.PaymentService;

import javax.transaction.Transactional;
import java.util.Comparator;
import java.util.List;

@Service
@Transactional
public class PaymentServiceImpl extends AbstractGenericService<PaymentEntity, Payment> implements PaymentService {

    @Autowired
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

    @Override
    public List<Payment> findAll() {
        List<PaymentEntity> paymentEntities = paymentDao.findAll();
        paymentEntities.sort(Comparator.comparing(PaymentEntity::getMethod));
        return paymentConverter.convertToDtoList(paymentEntities);
    }
}
