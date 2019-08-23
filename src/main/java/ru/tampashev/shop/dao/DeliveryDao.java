package ru.tampashev.shop.dao;

import ru.tampashev.shop.entities.DeliveryEntity;

import java.util.List;

public interface DeliveryDao extends GenericDao<DeliveryEntity> {

    List<DeliveryEntity> findAll();
}
