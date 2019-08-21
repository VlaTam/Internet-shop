package ru.tampashev.shop.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "category", schema = "internet_shop")
@NamedQueries({
        @NamedQuery(name = "category-find-all",
                    query = "FROM CategoryEntity category " +
                            "WHERE category.status = 'valid'"),
        @NamedQuery(name = "category-find",
                    query = "FROM CategoryEntity category " +
                            "WHERE category.name = :name " +
                            "AND category.status = 'valid'")
})
//@SuppressWarnings(value = "unused")
public class CategoryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(unique = true, nullable = false)
    private String name;

    @Column(nullable = false)
    private String status;

    @OneToMany(targetEntity = ProductEntity.class, mappedBy = "category", cascade = {CascadeType.MERGE, CascadeType.REFRESH})
    private Collection<ProductEntity> productEntities;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof CategoryEntity)) return false;
        CategoryEntity that = (CategoryEntity) o;
        return Objects.equals(name, that.name);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name);
    }

    public Integer getId() {
        return id;
    }

    public String getName() {
        return name;
    }

    public Collection<ProductEntity> getProductEntities() {
        return productEntities;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setName(String name) {
        this.name = name;
    }

    public void setProductEntities(Collection<ProductEntity> productEntities) {
        this.productEntities = productEntities;
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
