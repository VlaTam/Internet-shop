package ru.tampashev.shop.dto;

public class Delivery {

    private Integer id;
    private String method;
    private String deliveryStatus;

    public Integer getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }

    public String getDeliveryStatus() {
        return deliveryStatus;
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
}
