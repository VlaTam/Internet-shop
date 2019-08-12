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

import javax.transaction.Transactional;

@Service
@Transactional
public class DeliveryServiceImpl extends AbstractGenericService<DeliveryEntity, Delivery> implements DeliveryService {

    @Autowired
    @Qualifier("deliveryConverter")
    private Converter<DeliveryEntity, Delivery> deliveryConverter;

    @Autowired
    private DeliveryDao deliveryDao;

    @Override
    protected Converter<DeliveryEntity, Delivery> getUserConverter() {
        return deliveryConverter;
    }

    @Override
    protected GenericDao<DeliveryEntity> getDao() {
        return deliveryDao;
    }

    @Override
    public Integer find(Delivery delivery) {
        DeliveryEntity deliveryEntity = deliveryConverter.convertToEntity(delivery);
        return deliveryDao.find(deliveryEntity);
    }
}
