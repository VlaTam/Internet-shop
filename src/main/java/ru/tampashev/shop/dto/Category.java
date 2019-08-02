package ru.tampashev.shop.dto;

import java.util.Collection;

public class Category {

    private Integer id;
    private String name;
    private Collection<Product> products;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    public Collection<Product> getProducts() {
        return products;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getId() {
        return id;
    }

    public void setProducts(Collection<Product> products) {
        this.products = products;
    }
}
