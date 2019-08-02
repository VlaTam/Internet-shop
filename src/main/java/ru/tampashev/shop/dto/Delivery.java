package ru.tampashev.shop.dto;

import java.util.Collection;

public class Delivery {

    private Integer id;
    private String method;
    private String deliveryStatus;
    private Collection<Order> orders;

    public Integer getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
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

    public void setDeliveryStatus(String deliveryStatus) {
        this.deliveryStatus = deliveryStatus;
    }

    public void setOrders(Collection<Order> orders) {
        this.orders = orders;
    }
}
