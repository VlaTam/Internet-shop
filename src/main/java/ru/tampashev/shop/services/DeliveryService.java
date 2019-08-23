package ru.tampashev.shop.services;

import ru.tampashev.shop.dto.Delivery;

import java.util.List;

public interface DeliveryService extends GenericService<Delivery> {

    List<Delivery> findAll();
}
