package ru.tampashev.shop.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tampashev.shop.dto.*;
import ru.tampashev.shop.entities.*;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class OrderConverter implements Converter<OrderEntity, Order> {

    @Autowired
    private Converter<UserEntity, User> userConverter;

    @Autowired
    private Converter<DeliveryEntity, Delivery> deliveryConverter;

    @Autowired
    private Converter<PaymentEntity, Payment> paymentConverter;

    @Autowired
    private OrderProductConverter orderProductConverter;

    @Override
    public Order convertToDto(OrderEntity orderEntity) {
        Order order = new Order();
        order.setId(orderEntity.getId());
        order.setDate(orderEntity.getDate());
        order.setComments(orderEntity.getComments());
        order.setTotalPrice(orderEntity.getTotalPrice());

        Delivery delivery = deliveryConverter.convertToDto(orderEntity.getDelivery());
        order.setDelivery(delivery);

        Payment payment = paymentConverter.convertToDto(orderEntity.getPayment());
        order.setPayment(payment);

        User user = userConverter.convertToDto(orderEntity.getUser());
        order.setUser(user);

        List<OrderProduct> orderProductList = orderEntity.getOrderProductEntityList()
                .stream()
                .map(orderProductConverter::convertToDto)
                .collect(Collectors.toList());

        order.setOrderProducts(orderProductList);
        return order;
    }

    @Override
    public OrderEntity convertToEntity(Order order) {
        OrderEntity orderEntity = new OrderEntity();
        orderEntity.setId(order.getId());
        orderEntity.setDate(order.getDate());
        orderEntity.setComments(order.getComments());
        orderEntity.setTotalPrice(order.getTotalPrice());

        DeliveryEntity deliveryEntity = deliveryConverter.convertToEntity(order.getDelivery());
        orderEntity.setDelivery(deliveryEntity);

        PaymentEntity paymentEntity = paymentConverter.convertToEntity(order.getPayment());
        orderEntity.setPayment(paymentEntity);

        UserEntity userEntity = userConverter.convertToEntity(order.getUser());
        orderEntity.setUser(userEntity);

        List<OrderProductEntity> orderProductEntityList = order.getOrderProducts()
                .stream()
                .map(orderProductConverter::convertToEntity)
                .collect(Collectors.toList());

        orderEntity.setOrderProductEntityList(orderProductEntityList);
        return orderEntity;
    }
}
