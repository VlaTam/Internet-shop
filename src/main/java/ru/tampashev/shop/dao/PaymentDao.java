package ru.tampashev.shop.dao;

import ru.tampashev.shop.entities.PaymentEntity;

import java.util.List;

public interface PaymentDao extends GenericDao<PaymentEntity> {

    List<PaymentEntity> findAll();
}
