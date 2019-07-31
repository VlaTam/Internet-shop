package ru.tampashev.shop.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tampashev.shop.dao.DeliveryDao;
import ru.tampashev.shop.entities.DeliveryEntity;

@Repository
public class DeliveryDaoImpl extends AbstractGenericDao<DeliveryEntity> implements DeliveryDao {

    public DeliveryDaoImpl() {
        type = DeliveryEntity.class;
    }
}
