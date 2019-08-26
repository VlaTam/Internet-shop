package ru.tampashev.shop.dto;

import org.springframework.format.annotation.DateTimeFormat;

import java.math.BigDecimal;
import java.util.Collection;
import java.util.Date;

public class Order {

    private Integer id;
    private User user;
    private Payment payment;
    private Delivery delivery;

    @DateTimeFormat(pattern = "yyyy-MM-dd")
    private Date date;
    private String comments;
    private BigDecimal totalPrice;
    private Collection<OrderProduct> orderProducts;

    public Integer getId() {
        return id;
    }

    public User getUser() {
        return user;
    }

    public Payment getPayment() {
        return payment;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public Date getDate() {
        return date;
    }

    public Collection<OrderProduct> getOrderProducts() {
        return orderProducts;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUser(User user) {
        this.user = user;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setOrderProducts(Collection<OrderProduct> orderProducts) {
        this.orderProducts = orderProducts;
    }

    public String getComments() {
        return comments;
    }

    public void setComments(String comments) {
        this.comments = comments;
    }

    public BigDecimal getTotalPrice() {
        return totalPrice;
    }

    public void setTotalPrice(BigDecimal totalPrice) {
        this.totalPrice = totalPrice;
    }
}
