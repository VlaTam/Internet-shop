package ru.tampashev.shop.dto;

import java.util.Collection;

public class Payment {

    private Integer id;
    private String method;
    private String paymentStatus;
    private Collection<Order> orders;

    public Integer getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }

    public String getPaymentStatus() {
        return paymentStatus;
    }

    public Collection<Order> getOrders() {
        return orders;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setPaymentStatus(String paymentStatus) {
        this.paymentStatus = paymentStatus;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }
}
