package ru.tampashev.shop.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;

@Entity
@Table(name = "order_product", schema = "internet_shop")
@NamedQueries({
        @NamedQuery(name = "orderProduct-find-by-orderId",
                query = "FROM OrderProductEntity orderProduct " +
                        "WHERE orderProduct.order.id = :orderId ")
})
public class OrderProductEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @ManyToOne
    @JoinColumn(name = "order_id", nullable = false)
    private OrderEntity order;

    @ManyToOne
    @JoinColumn(name = "product_id", nullable = false)
    private ProductEntity product;

    @Column(name = "quantity_of_product")
    private Integer quantityOfProduct;

    @Column(name = "fix_product_price")
    private BigDecimal fixProductPrice;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public OrderEntity getOrder() {
        return order;
    }

    public void setOrder(OrderEntity order) {
        this.order = order;
    }

    public ProductEntity getProduct() {
        return product;
    }

    public void setProduct(ProductEntity product) {
        this.product = product;
    }

    public Integer getQuantityOfProduct() {
        return quantityOfProduct;
    }

    public void setQuantityOfProduct(Integer quantityOfProduct) {
        this.quantityOfProduct = quantityOfProduct;
    }

    public BigDecimal getFixProductPrice() {
        return fixProductPrice;
    }

    public void setFixProductPrice(BigDecimal fixPrice) {
        this.fixProductPrice = fixPrice;
    }
}
