package ru.tampashev.shop.dto;

public class Payment {

    private Integer id;
    private String method;
    private String paymentStatus;

    public Integer getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }

    public String getPaymentStatus() {
        return paymentStatus;
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
}
