package ru.tampashev.shop.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

@Entity
@Table(name = "order", schema = "internet_shop")

public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private Date date;

    @Column(nullable = false)
    private BigDecimal orderPrice;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private PaymentEntity payment;

    @ManyToOne
    @JoinColumn(name = "delivery_id", nullable = false)
    private DeliveryEntity delivery;

    @ManyToMany
    @JoinTable( name = "order_product",
                joinColumns = @JoinColumn(name = "order_id"),
                inverseJoinColumns = @JoinColumn(name = "product_id"))
    private List<ProductEntity> products;

    public Integer getId() {
        return id;
    }

    public UserEntity getUser() {
        return user;
    }

    public PaymentEntity getPayment() {
        return payment;
    }

    public DeliveryEntity getDelivery() {
        return delivery;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public List<ProductEntity> getProducts() {
        return products;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser(UserEntity user) {
        this.user = user;
    }

    public void setPayment(PaymentEntity payment) {
        this.payment = payment;
    }

    public void setDelivery(DeliveryEntity delivery) {
        this.delivery = delivery;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public void setProducts(List<ProductEntity> products) {
        this.products = products;
    }
}
