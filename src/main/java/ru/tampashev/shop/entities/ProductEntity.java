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
                    query = "FROM ProductEntity product " +
                            "WHERE product.status = 'valid'"),
        @NamedQuery(name = "product-find",
                    query = "FROM ProductEntity product " +
                            "WHERE product.name = :name " +
                            "AND product.parameters.brand = :brand " +
                            "AND product.parameters.width = :width " +
                            "AND product.parameters.height = :height " +
                            "AND product.parameters.radius = :radius " +
                            "AND product.status = 'valid'"),
        @NamedQuery(name = "product-find-by-parameters",
                    query = "FROM ProductEntity product " +
                            "WHERE product.parameters.brand = :brand " +
                            "AND product.parameters.width = :width " +
                            "AND product.parameters.height = :height " +
                            "AND product.parameters.radius = :radius " +
                            "AND product.status = 'valid'")
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
    @JoinColumn(name = "category_id")
    private CategoryEntity category;

    @ManyToOne
    @JoinColumn(name = "parameter_id", nullable = false)
    private ParametersEntity parameters;

    @Column(nullable = false)
    private BigDecimal weight;

    @Column(nullable = false)
    private BigDecimal volume;

    @Column(name = "quantity_in_stock", nullable = false)
    private Integer quantityInStock;

    @Column(nullable = false)
    private String status;

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
        return Objects.equals(name, that.name) &&
                Objects.equals(category, that.category) &&
                Objects.equals(parameters, that.parameters);
    }

    @Override
    public int hashCode() {
        return Objects.hash(name, category, parameters);
    }

    public String getStatus() {
        return status;
    }

    public void setStatus(String status) {
        this.status = status;
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

    public BigDecimal getWeight() {
        return weight;
    }

    public BigDecimal getVolume() {
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

    public void setWeight(BigDecimal weight) {
        this.weight = weight;
    }

    public void setVolume(BigDecimal volume) {
        this.volume = volume;
    }

    public void setQuantityInStock(Integer quantityInStock) {
        this.quantityInStock = quantityInStock;
    }
}
