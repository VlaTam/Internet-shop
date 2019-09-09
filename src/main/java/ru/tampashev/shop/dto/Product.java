package ru.tampashev.shop.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@JsonAutoDetect
public class Product {

    @JsonIgnore
    private Integer id;
    private String name;
    private BigDecimal price;
    @JsonIgnore
    private Category category;
    private Parameters parameters;
    @JsonIgnore
    private BigDecimal weight ;
    @JsonIgnore
    private BigDecimal volume;
    @JsonIgnore
    private Integer quantityInStock;
    @JsonIgnore
    private String status;
    @JsonIgnore
    private Collection<Order> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Product)) return false;
        Product product = (Product) o;
        return Objects.equals(name, product.name) &&
                Objects.equals(category, product.category) &&
                Objects.equals(parameters, product.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, parameters);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }

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
