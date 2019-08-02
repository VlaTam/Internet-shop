package ru.tampashev.shop.dto;

import java.util.Collection;

public class Parameters {

    private Integer id;
    private String brand;
    private Integer width;
    private Integer height;
    private Integer radius;
    private Collection<Product> products;

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
