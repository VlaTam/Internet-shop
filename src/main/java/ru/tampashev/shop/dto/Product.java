package ru.tampashev.shop.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import javax.validation.constraints.*;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

@JsonAutoDetect
public class Product {

    @JsonIgnore
    private Integer id;

    @NotBlank(message = "email is empty")
    private String name;

    @NotNull(message = "type price")
    @DecimalMin(value = "0", message = "price is negative, correct it")
    @DecimalMax(value = "1000000", message = "max price is 1000000")
    private BigDecimal price;

    @JsonIgnore
    @NotNull(message = "choose category")
    private Category category;

    @NotNull(message = "choose parameters")
    private Parameters parameters;

    @JsonIgnore
    @NotNull(message = "type weight")
    @DecimalMin(value = "0.1", message = "min weight is 0.1")
    @DecimalMax(value = "1000", message = "max weight is 1000")
    private BigDecimal weight ;

    @JsonIgnore
    @NotNull(message = "type volume")
    @DecimalMin(value = "0.1", message = "min volume is 0.1")
    @DecimalMax(value = "1000", message = "max volume is 1000")
    private BigDecimal volume;

    @JsonIgnore
    @NotNull(message = "type quantity in stock")
    @Min(value = 0, message = "quantity in stock: it is negative value")
    @Max(value = Integer.MAX_VALUE, message = "quantity in stock: max value is " + Integer.MAX_VALUE)
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
