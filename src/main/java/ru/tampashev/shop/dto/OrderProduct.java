package ru.tampashev.shop.dto;

import ru.tampashev.shop.entities.OrderEntity;
import ru.tampashev.shop.entities.ProductEntity;

import java.math.BigDecimal;

public class OrderProduct {

    private Integer id;
    private OrderEntity order;
    private ProductEntity product;
    private Integer quantityOfProduct;
    private BigDecimal fixProductPrice;

    public Integer getId() {
        return id;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public Integer getQuantityOfProduct() {
        return quantityOfProduct;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public void setQuantityOfProduct(Integer quantityOfProduct) {
        this.quantityOfProduct = quantityOfProduct;
    }

    public BigDecimal getFixProductPrice() {
        return fixProductPrice;
    }

    public void setFixProductPrice(BigDecimal fixProductPrice) {
        this.fixProductPrice = fixProductPrice;
    }
}
