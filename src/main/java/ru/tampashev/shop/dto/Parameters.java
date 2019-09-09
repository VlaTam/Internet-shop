package ru.tampashev.shop.dto;

import com.fasterxml.jackson.annotation.JsonAutoDetect;
import com.fasterxml.jackson.annotation.JsonIgnore;

import java.util.Collection;
import java.util.Objects;

@JsonAutoDetect
public class Parameters {

    @JsonIgnore
    private Integer id;
    private String brand;
    private Integer width;
    private Integer height;
    private Integer radius;
    @JsonIgnore
    private Collection<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Parameters)) return false;
        Parameters that = (Parameters) o;
        return Objects.equals(brand, that.brand) &&
                Objects.equals(width, that.width) &&
                Objects.equals(height, that.height) &&
                Objects.equals(radius, that.radius);
    }

    @Override
    public int hashCode() {
        return Objects.hash(brand, width, height, radius);
    }

    public Integer getId() {
        return id;
    }

    public String getBrand() {
        return brand;
    }

    public Integer getWidth() {
        return width;
    }

    public Integer getHeight() {
        return height;
    }

    public Integer getRadius() {
        return radius;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setBrand(String brand) {
        this.brand = brand;
    }

    public void setWidth(Integer width) {
        this.width = width;
    }

    public void setHeight(Integer height) {
        this.height = height;
    }

    public void setRadius(Integer radius) {
        this.radius = radius;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
