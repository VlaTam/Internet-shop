package ru.tampashev.shop.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Objects;

//@SuppressWarnings(value = "unused")
@Entity
@Table(name = "product", schema = "internet_shop")
@NamedQueries({
        @NamedQuery(name = "product-find-all",
                query = "FROM ProductEntity")
})
public class ProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String name;

    @Column(nullable = false)
    private BigDecimal price;

    @ManyToOne
    @JoinColumn(name = "category_id", nullable = false)
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "parameter_id", nullable = false)
    private ParametersEntity parameters;

    @Column(nullable = false)
    private Integer weight;

    @Column(nullable = false)
    private Integer volume;

    @Column(name = "quantity_in_stock", nullable = false)
    private Integer quantityInStock;

    @ManyToMany
    @JoinTable( name = "order_product",
                joinColumns = @JoinColumn(name = "product_id"),
                inverseJoinColumns = @JoinColumn(name = "order_id"))
    private Collection<OrderEntity> orders;

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

    public BigDecimal getPrice() {
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

    public void setPrice(BigDecimal price) {
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
