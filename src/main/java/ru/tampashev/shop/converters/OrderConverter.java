package ru.tampashev.shop.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tampashev.shop.dto.*;
import ru.tampashev.shop.entities.*;

import java.util.List;

@Component
public class OrderConverter implements Converter<OrderEntity, Order> {

    @Autowired
    private Converter<UserEntity, User> userConverter;

    @Autowired
    private Converter<DeliveryEntity, Delivery> deliveryConverter;

    @Autowired
    private Converter<PaymentEntity, Payment> paymentConverter;

    @Autowired
    private Converter<ProductEntity, Product> productConverter;

    @Override
    public Order convertToDto(OrderEntity orderEntity) {
        Order order = new Order();
        order.setId(orderEntity.getId());
        order.setDate(orderEntity.getDate());
        order.setOrderPrice(orderEntity.getOrderPrice());

        Delivery delivery = deliveryConverter.convertToDto(orderEntity.getDelivery());
        order.setDelivery(delivery);

        Payment payment = paymentConverter.convertToDto(orderEntity.getPayment());
        order.setPayment(payment);

        User user = userConverter.convertToDto(orderEntity.getUser());
        order.setUser(user);

        List<Product> products = productConverter.convertToDtoList(orderEntity.getProducts());
        order.setProducts(products);
        return order;
    }

    @Override
    public OrderEntity convertToEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId());
        orderEntity.setDate(order.getDate());
        orderEntity.setOrderPrice(order.getOrderPrice());

        DeliveryEntity deliveryEntity = deliveryConverter.convertToEntity(order.getDelivery());
        orderEntity.setDelivery(deliveryEntity);

        PaymentEntity paymentEntity = paymentConverter.convertToEntity(order.getPayment());
        orderEntity.setPayment(paymentEntity);

        UserEntity userEntity = userConverter.convertToEntity(order.getUser());
        orderEntity.setUser(userEntity);

        List<ProductEntity> productEntities = productConverter.convertToEntityList(order.getProducts());
        orderEntity.setProducts(productEntities);
        return orderEntity;
    }
}
