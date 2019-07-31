package ru.tampashev.shop.converters;

import org.springframework.stereotype.Component;
import ru.tampashev.shop.dto.Delivery;
import ru.tampashev.shop.entities.DeliveryEntity;

@Component
public class DeliveryConverter implements Converter<DeliveryEntity, Delivery> {

    @Override
    public Delivery convertToDto(DeliveryEntity deliveryEntity) {
        Delivery delivery = new Delivery();
        delivery.setId(deliveryEntity.getId());
        delivery.setMethod(deliveryEntity.getMethod());
        delivery.setStatus(deliveryEntity.getStatus());
        return delivery;
    }

    @Override
    public DeliveryEntity convertToEntity(Delivery delivery) {
        DeliveryEntity deliveryEntity = new DeliveryEntity();
        deliveryEntity.setId(delivery.getId());
        deliveryEntity.setMethod(delivery.getMethod());
        deliveryEntity.setStatus(delivery.getStatus());
        return deliveryEntity;
    }
}
