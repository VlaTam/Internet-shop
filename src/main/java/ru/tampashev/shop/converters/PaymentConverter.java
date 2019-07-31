package ru.tampashev.shop.converters;

import org.springframework.stereotype.Component;
import ru.tampashev.shop.dto.Payment;
import ru.tampashev.shop.entities.PaymentEntity;

@Component
public class PaymentConverter implements Converter<PaymentEntity, Payment> {

    @Override
    public Payment convertToDto(PaymentEntity paymentEntity) {
        Payment payment = new Payment();
        payment.setId(paymentEntity.getId());
        payment.setMethod(paymentEntity.getMethod());
        payment.setStatus(paymentEntity.getStatus());
        return payment;
    }

    @Override
    public PaymentEntity convertToEntity(Payment payment) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setId(payment.getId());
        paymentEntity.setMethod(payment.getMethod());
        paymentEntity.setStatus(payment.getStatus());
        return paymentEntity;
    }
}
