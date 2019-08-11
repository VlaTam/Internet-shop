package ru.tampashev.shop.dto;

import java.math.BigDecimal;
import java.util.Date;
import java.util.List;

public class Order {

    private Integer id;
    private User user;
    private Payment payment;
    private Delivery delivery;
    private Date date;
    private BigDecimal orderPrice;
    private List<Product> products;

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

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public List<Product> getProducts() {
        return products;
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

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }

    public void setProducts(List<Product> products) {
        this.products = products;
    }
}
