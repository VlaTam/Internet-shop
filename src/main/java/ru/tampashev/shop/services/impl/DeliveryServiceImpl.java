package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.converters.Converter;
import ru.tampashev.shop.dao.DeliveryDao;
import ru.tampashev.shop.dao.GenericDao;
import ru.tampashev.shop.dto.Delivery;
import ru.tampashev.shop.entities.DeliveryEntity;
import ru.tampashev.shop.services.DeliveryService;

@Service
public class DeliveryServiceImpl extends AbstractGenericService<DeliveryEntity, Delivery> implements DeliveryService {

    @Autowired
    @Qualifier("deliveryConverter")
    private Converter<DeliveryEntity, Delivery> converter;

    @Autowired
    private DeliveryDao deliveryDao;

    @Override
    protected Converter<DeliveryEntity, Delivery> getConverter() {
        return converter;
    }

    @Override
    protected GenericDao<DeliveryEntity> getDao() {
        return deliveryDao;
    }
}
