package ru.tampashev.shop.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

//@SuppressWarnings(value = "unused")
@Entity(name = "internet_shop.category")
public class CategoryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    /*@OneToMany(targetEntity = ProductEntity.class, mappedBy = "category", cascade = CascadeType.MERGE)
    private Set<ProductEntity> productEntities = null;*/

    public CategoryEntity() {
    }

    public CategoryEntity(String name) {
        this.name = name;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryEntity)) return false;
        CategoryEntity that = (CategoryEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(name, that.name); /*&&
                Objects.equals(productEntities, that.productEntities);*/
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);//, productEntities);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    /*public Set<ProductEntity> getProductEntities() {
        return productEntities;
    }*/

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    /*public void setProductEntities(Set<ProductEntity> productEntities) {
        this.productEntities = productEntities;
    }*/
}
