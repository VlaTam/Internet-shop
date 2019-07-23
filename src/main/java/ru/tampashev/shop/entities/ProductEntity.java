package ru.tampashev.shop.entities;

import javax.persistence.*;
import java.util.Objects;

//@SuppressWarnings(value = "unused")
@Entity(name = "internet_shop.parameters")
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
    @JoinColumn(name = "categoryEntity.id", nullable = false)
    private CategoryEntity categoryEntity;

    @ManyToOne
    @JoinColumn(name = "parametersEntity.id", nullable = false)
    private ParametersEntity parametersEntity;

    @Column(nullable = false)
    private Integer weight = 1;

    @Column(nullable = false)
    private Integer volume = 1;

    @Column(name = "quantity_in_stock", nullable = false)
    private Integer quantityInStock = 0;

    public ProductEntity() {
    }

    public ProductEntity(String name, CategoryEntity categoryEntity) {
        this.name = name;
        this.categoryEntity = categoryEntity;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ProductEntity)) return false;
        ProductEntity that = (ProductEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name) &&
                Objects.equals(price, that.price) &&
                Objects.equals(categoryEntity, that.categoryEntity) &&
                Objects.equals(parametersEntity, that.parametersEntity) &&
                Objects.equals(weight, that.weight) &&
                Objects.equals(volume, that.volume) &&
                Objects.equals(quantityInStock, that.quantityInStock);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name, price, categoryEntity, parametersEntity, weight, volume, quantityInStock);
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

    public CategoryEntity getCategoryEntity() {
        return categoryEntity;
    }

    public ParametersEntity getParametersEntity() {
        return parametersEntity;
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

    public void setCategoryEntity(CategoryEntity categoryEntity) {
        this.categoryEntity = categoryEntity;
    }

    public void setParametersEntity(ParametersEntity parametersEntity) {
        this.parametersEntity = parametersEntity;
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
