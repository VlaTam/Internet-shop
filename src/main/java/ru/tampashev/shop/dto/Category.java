package ru.tampashev.shop.dto;

import java.util.Collection;
import java.util.Objects;

public class Category {

    private Integer id;
    private String name;
    private String status;
    private Collection<Product> products;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof Category)) return false;
        Category category = (Category) o;
        return Objects.equals(name, category.name) &&
                Objects.equals(status, category.status);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, status);
    }

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

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
