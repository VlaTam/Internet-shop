package ru.tampashev.databaselayer.entities;

import javax.persistence.*;

//@SuppressWarnings(value = "unused")
@Entity(name = "internet_shop.parameters")
public class Product {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price = 1;

    @ManyToOne
    @JoinColumn(name = "category.id", nullable = false)
    private Category category;

    @ManyToOne
    @JoinColumn(name = "parameters.id", nullable = false)
    private Parameters parameters;

    @Column(nullable = false)
    private Integer weight = 1;

    @Column(nullable = false)
    private Integer volume = 1;

    @Column(name = "quantity_in_stock", nullable = false)
    private Integer quantityInStock = 0;

    public Product() {
    }

    public Product(String name, Category category) {
        this.name = name;
        this.category = category;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Product)) return false;
        Product product = (Product) other;
        return  name.equals(product.name) &&
                price.equals(product.price) &&
                category.equals(product.category) &&
                parameters.equals(product.parameters) &&
                weight.equals(product.weight) &&
                volume.equals(product.volume) &&
                quantityInStock.equals(product.quantityInStock);
    }

    @Override
    public int hashCode() {
        return  name.hashCode() + price.hashCode() + category.hashCode() +
                parameters.hashCode() + weight.hashCode() + volume.hashCode() + quantityInStock.hashCode();
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Integer getPrice() {
        return price;
    }

    public Category getCategory() {
        return category;
    }

    public Parameters getParameters() {
        return parameters;
    }

    public Integer getWeight() {
        return weight;
    }

    public Integer getVolume() {
        return volume;
    }

    public Integer getQuantityInStock() {
        return quantityInStock;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setPrice(Integer price) {
        this.price = price;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    public void setParameters(Parameters parameters) {
        this.parameters = parameters;
    }

    public void setWeight(Integer weight) {
        this.weight = weight;
    }

    public void setVolume(Integer volume) {
        this.volume = volume;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
