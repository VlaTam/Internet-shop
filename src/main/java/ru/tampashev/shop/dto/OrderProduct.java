package ru.tampashev.shop.dto;

import java.math.BigDecimal;

public class OrderProduct {

    private Integer id;
    private Order order;
    private Product product;
    private Integer quantityOfProduct;
    private BigDecimal fixProductPrice;

    public Integer getId() {
        return id;
    }

    public Order getOrder() {
        return order;
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantityOfProduct() {
        return quantityOfProduct;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setOrder(Order order) {
        this.order = order;
    }

    public void setProduct(Product product) {
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
