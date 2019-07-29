package ru.tampashev.shop.entities;

import javax.persistence.*;
import java.util.Objects;

//@SuppressWarnings(value = "unused")
@Entity
@Table(name = "product", schema = "internet_shop")
public class ProductEntity {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private Integer price = 1;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "id", nullable = false)
    private ParametersEntity parameters;

    @Column(nullable = false)
    private Integer weight = 1;

    @Column(nullable = false)
    private Integer volume = 1;

    @Column(name = "quantity_in_stock", nullable = false)
    private Integer quantityInStock = 0;

    public ProductEntity() {
    }

    public ProductEntity(String name, CategoryEntity category) {
        this.name = name;
        this.category = category;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductEntity)) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(price, that.price) &&
                Objects.equals(category, that.category) &&
                Objects.equals(parameters, that.parameters) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(volume, that.volume) &&
                Objects.equals(quantityInStock, that.quantityInStock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, category, parameters, weight, volume, quantityInStock);
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

    public CategoryEntity getCategory() {
        return category;
    }

    public ParametersEntity getParameters() {
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

    public void setCategory(CategoryEntity category) {
        this.category = category;
    }

    public void setParameters(ParametersEntity parameters) {
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
