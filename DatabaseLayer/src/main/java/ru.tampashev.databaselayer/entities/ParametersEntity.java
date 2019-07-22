package ru.tampashev.databaselayer.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

//@SuppressWarnings(value = "unused")
@Entity(name = "internet_shop.parameters")
public class ParametersEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String brand;

    @Column(nullable = false)
    private Integer width;

    @Column(nullable = false)
    private Integer height;

    @Column(nullable = false)
    private Integer radius;

    @OneToMany(targetEntity = ProductEntity.class, mappedBy = "parameters", cascade = CascadeType.MERGE)
    private Set<ProductEntity> productEntities;

    public ParametersEntity() {
    }

    public ParametersEntity(String brand, Integer width, Integer height, Integer radius) {
        this.brand = brand;
        this.width = width;
        this.height = height;
        this.radius = radius;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParametersEntity)) return false;
        ParametersEntity that = (ParametersEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(width, that.width) &&
                Objects.equals(height, that.height) &&
                Objects.equals(radius, that.radius) &&
                Objects.equals(productEntities, that.productEntities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, width, height, radius, productEntities);
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
}
