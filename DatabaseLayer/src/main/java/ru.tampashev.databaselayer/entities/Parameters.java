package ru.tampashev.databaselayer.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Set;

//@SuppressWarnings(value = "unused")
@Entity(name = "internet_shop.parameters")
public class Parameters implements Serializable {

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

    @OneToMany(targetEntity = Product.class, mappedBy = "parameters", cascade = CascadeType.MERGE)
    private Set<Product> products;

    public Parameters() {
    }

    public Parameters(String brand, Integer width, Integer height, Integer radius) {
        this.brand = brand;
        this.width = width;
        this.height = height;
        this.radius = radius;
    }

    @Override
    public boolean equals(Object other) {
        if (this == other) return true;
        if (!(other instanceof Parameters)) return false;
        Parameters that = (Parameters) other;
        return  brand.equals(that.brand) &&
                width.equals(that.width) &&
                height.equals(that.height) &&
                radius.equals(that.radius);
    }

    @Override
    public int hashCode() {
        return brand.hashCode() + width.hashCode() + height.hashCode() + radius.hashCode();
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
