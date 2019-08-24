package ru.tampashev.shop.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tampashev.shop.dto.Order;
import ru.tampashev.shop.dto.OrderProduct;
import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.entities.OrderEntity;
import ru.tampashev.shop.entities.OrderProductEntity;
import ru.tampashev.shop.entities.ProductEntity;

import java.util.List;
import java.util.stream.Collectors;

@Component
@SuppressWarnings("all")
public class OrderProductConverter implements Converter<OrderProductEntity, OrderProduct> {

    @Autowired
    private OrderConverter orderConverter;

    @Autowired
    private ProductConverter productConverter;

    @Override
    public OrderProduct convertToDto(OrderProductEntity orderProductEntity) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId(orderProductEntity.getId());

        Order order = orderConverter.convertToDto(orderProductEntity.getOrder());
        orderProduct.setOrder(order);

        Product product = productConverter.convertToDto(orderProductEntity.getProduct());
        orderProduct.setProduct(product);

        orderProduct.setQuantityOfProduct(orderProductEntity.getQuantityOfProduct());
        orderProduct.setFixProductPrice(orderProductEntity.getFixProductPrice());
        return orderProduct;
    }

    @Override
    public OrderProductEntity convertToEntity(OrderProduct orderProduct) {
        OrderProductEntity orderProductEntity = new OrderProductEntity();
        orderProductEntity.setId(orderProduct.getId());

        OrderEntity orderEntity = orderConverter.convertToEntity(orderProduct.getOrder());
        orderProductEntity.setOrder(orderEntity);

        ProductEntity productEntity = productConverter.convertToEntity(orderProduct.getProduct());
        orderProductEntity.setProduct(productEntity);

        orderProductEntity.setQuantityOfProduct(orderProduct.getQuantityOfProduct());
        orderProductEntity.setFixProductPrice(orderProduct.getFixProductPrice());
        return orderProductEntity;
    }

    @Override
    public List<OrderProduct> convertToDtoList(List<OrderProductEntity> orderProductEntities){
        return orderProductEntities.stream().map(this::convertToDto).collect(Collectors.toList());
    }
}
