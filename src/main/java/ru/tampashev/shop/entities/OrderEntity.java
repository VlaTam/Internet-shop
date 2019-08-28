package ru.tampashev.shop.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

@Entity
@Table(name = "order_in_store", schema = "internet_shop")
@NamedQueries({
        @NamedQuery(name = "order-find-history-of-user",
                    query = "FROM OrderEntity order " +
                            "WHERE order.user.id = :userId"),
        @NamedQuery(name = "order-find-all",
                    query = "FROM OrderEntity"),
        @NamedQuery(name = "order-find-profit",
                    query = "SELECT SUM(orderEntity.totalPrice) " +
                            "FROM OrderEntity orderEntity " +
                            "WHERE orderEntity.date BETWEEN :startOfPeriod AND :endOfPeriod")
})
public class OrderEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(updatable = false, nullable = false)
    private Integer id;

    @Column(name = "date", nullable = false)
    private Date date;

    @Column(name = "comments")
    private String comments;

    @Column(name = "order_price", nullable = false)
    private BigDecimal totalPrice;

    @ManyToOne
    @JoinColumn(name = "user_id", nullable = false)
    private UserEntity user;

    @ManyToOne
    @JoinColumn(name = "payment_id", nullable = false)
    private PaymentEntity payment;

    @ManyToOne
    @JoinColumn(name = "delivery_id", nullable = false)
    private DeliveryEntity delivery;

    @OneToMany(targetEntity = OrderProductEntity.class, mappedBy = "order", cascade = CascadeType.MERGE)
    private Collection<OrderProductEntity> orderProductEntityList;

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

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public Collection<OrderProductEntity> getOrderProductEntityList() {
        return orderProductEntityList;
    }

    public void setOrderProductEntityList(Collection<OrderProductEntity> orderProductEntityList) {
        this.orderProductEntityList = orderProductEntityList;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
