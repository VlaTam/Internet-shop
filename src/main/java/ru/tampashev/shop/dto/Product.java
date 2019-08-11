package ru.tampashev.shop.dto;

import java.math.BigDecimal;
import java.util.Collection;

public class Product {

    private Integer id;
    private String name;
    private BigDecimal price;
    private Category category;
    private Parameters parameters;
    private BigDecimal weight ;
    private BigDecimal volume;
    private Integer quantityInStock;
    private Collection<Order> orders;

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public BigDecimal getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getVolume() {
        return volume;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(BigDecimal price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }
}
