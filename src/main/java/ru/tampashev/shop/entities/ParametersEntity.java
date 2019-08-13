package ru.tampashev.shop.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "parameters", schema = "internet_shop")
@NamedQueries({
        @NamedQuery(name = "parameters-find-all",
                    query = "FROM ParametersEntity"),
        @NamedQuery(name = "parameters-find",
                    query = "FROM ParametersEntity parameters " +
                            "WHERE parameters.brand = :brand " +
                                    "AND parameters.width = :width " +
                                    "AND parameters.height = :height " +
                                    "AND parameters.radius = :radius")
})
//@SuppressWarnings(value = "unused")
public class ParametersEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String brand;

    @Column(nullable = false)
    private Integer width;

    @Column(nullable = false)
    private Integer height;

    @Column(nullable = false)
    private Integer radius;

    @OneToMany(targetEntity = ProductEntity.class, mappedBy = "parameters", cascade = CascadeType.MERGE)
    private Collection<ProductEntity> productEntities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof ParametersEntity)) return false;
        ParametersEntity that = (ParametersEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(brand, that.brand) &&
                Objects.equals(width, that.width) &&
                Objects.equals(height, that.height) &&
                Objects.equals(radius, that.radius);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, brand, width, height, radius);
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

    public Collection<ProductEntity> getProductEntities() {
        return productEntities;
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

    public void setProductEntities(Collection<ProductEntity> productEntities) {
        this.productEntities = productEntities;
    }
}
