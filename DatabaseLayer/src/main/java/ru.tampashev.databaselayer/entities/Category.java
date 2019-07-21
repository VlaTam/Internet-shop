package ru.tampashev.databaselayer.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

//@SuppressWarnings(value = "unused")
@Entity(name = "internet_shop.category")
public class Category implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(targetEntity = Product.class, mappedBy = "category", cascade = CascadeType.MERGE)
    private Set<Product> products;

    public Category() {
    }

    public Category(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Category)) return false;
        Category category = (Category) other;
        return name.equals(category.name);
    }

    @Override
    public int hashCode() {
        return name.hashCode();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<Product> getProducts() {
        return products;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProducts(Set<Product> products) {
        this.products = products;
    }
}
