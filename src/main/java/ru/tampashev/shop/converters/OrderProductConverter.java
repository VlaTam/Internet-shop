package ru.tampashev.shop.converters;

import org.springframework.stereotype.Component;
import ru.tampashev.shop.dto.OrderProduct;
import ru.tampashev.shop.entities.OrderProductEntity;

import java.util.ArrayList;
import java.util.List;

@Component
@SuppressWarnings("all")
public class OrderProductConverter implements Converter<OrderProductEntity, OrderProduct> {

    @Override
    public OrderProduct convertToDto(OrderProductEntity orderProductEntity) {
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setId(orderProductEntity.getId());
        orderProduct.setOrder(orderProductEntity.getOrder());
        orderProduct.setProduct(orderProductEntity.getProduct());
        orderProduct.setQuantityOfProduct(orderProductEntity.getQuantityOfProduct());
        orderProduct.setFixProductPrice(orderProductEntity.getFixProductPrice());
        return orderProduct;
    }

    @Override
    public OrderProductEntity convertToEntity(OrderProduct orderProduct) {
        OrderProductEntity orderProductEntity = new OrderProductEntity();
        orderProductEntity.setId(orderProduct.getId());
        orderProductEntity.setOrder(orderProduct.getOrder());
        orderProductEntity.setProduct(orderProduct.getProduct());
        orderProductEntity.setQuantityOfProduct(orderProduct.getQuantityOfProduct());
        orderProductEntity.setFixProductPrice(orderProduct.getFixProductPrice());
        return orderProductEntity;
    }

    @Override
    public List<OrderProduct> convertToDtoList(List<OrderProductEntity> orderProductEntities){
        List<OrderProduct> orderProducts = new ArrayList<>(orderProductEntities.size());

        for(OrderProductEntity orderProductEntity : orderProductEntities) {
            OrderProduct orderProduct = convertToDto(orderProductEntity);
            orderProducts.add(orderProduct);
        }
        return orderProducts;
    }
}
