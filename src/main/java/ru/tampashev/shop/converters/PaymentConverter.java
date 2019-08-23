package ru.tampashev.shop.converters;

import org.springframework.stereotype.Component;
import ru.tampashev.shop.dto.Payment;
import ru.tampashev.shop.entities.PaymentEntity;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class PaymentConverter implements Converter<PaymentEntity, Payment> {

    @Override
    public Payment convertToDto(PaymentEntity paymentEntity) {
        Payment payment = new Payment();
        payment.setId(paymentEntity.getId());
        payment.setMethod(paymentEntity.getMethod());
        payment.setPaymentStatus(paymentEntity.getPaymentStatus());
        return payment;
    }

    @Override
    public PaymentEntity convertToEntity(Payment payment) {
        PaymentEntity paymentEntity = new PaymentEntity();
        paymentEntity.setId(payment.getId());
        paymentEntity.setMethod(payment.getMethod());
        paymentEntity.setPaymentStatus(payment.getPaymentStatus());
        return paymentEntity;
    }

    @Override
    public List<Payment> convertToDtoList(List<PaymentEntity> paymentEntities) {
        return paymentEntities.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
