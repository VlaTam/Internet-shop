package ru.tampashev.shop.dto;

import java.math.BigDecimal;
import java.util.Objects;

public class Purchase {

    private Product product;
    private Integer quantity;
    private BigDecimal totalCost;

    public Purchase() {
    }

    public Purchase(Product product, Integer quantity) {
        this.product = product;
        this.quantity = quantity;
        totalCost = product.getPrice().multiply(new BigDecimal(quantity));
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Purchase)) return false;
        Purchase purchase = (Purchase) o;
        return Objects.equals(product, purchase.product);
    }

    @Override
    public int hashCode() {
        return Objects.hash(product);
    }

    public Product getProduct() {
        return product;
    }

    public Integer getQuantity() {
        return quantity;
    }

    public BigDecimal getTotalCost() {
        return totalCost;
    }

    public void setProduct(Product product) {
        this.product = product;
    }

    public void setQuantity(Integer quantity) {
        this.quantity = quantity;
    }

    public void setTotalCost(BigDecimal totalCost) {
        this.totalCost = totalCost;
    }
}