package ru.tampashev.shop.services;

import ru.tampashev.shop.dto.Payment;

import java.util.List;

public interface PaymentService extends GenericService<Payment> {

    List<Payment> findAll();
}
