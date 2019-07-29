package ru.tampashev.shop.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Objects;
import java.util.Set;

@Entity
@Table(name = "category", schema = "internet_shop")
@NamedQueries({
        @NamedQuery(name = "category-find-all",
                query = "FROM CategoryEntity")
})
//@SuppressWarnings(value = "unused")
public class CategoryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @OneToMany(targetEntity = ProductEntity.class, mappedBy = "category", cascade = CascadeType.MERGE)
    private Set<ProductEntity> productEntities = null;

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
                Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, name);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Set<ProductEntity> getProductEntities() {
        return productEntities;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductEntities(Set<ProductEntity> productEntities) {
        this.productEntities = productEntities;
    }
}
