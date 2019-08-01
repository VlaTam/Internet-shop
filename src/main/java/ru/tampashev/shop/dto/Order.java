package ru.tampashev.shop.dto;

import java.math.BigDecimal;
import java.util.Date;

public class Order {

    private Integer id;
    private Integer userId;
    private Integer paymentId;
    private Integer deliveryId;
    private Date date;
    private BigDecimal orderPrice;

    public Integer getId() {
        return id;
    }

    public Integer getUserId() {
        return userId;
    }

    public Integer getPaymentId() {
        return paymentId;
    }

    public Integer getDeliveryId() {
        return deliveryId;
    }

    public Date getDate() {
        return date;
    }

    public BigDecimal getOrderPrice() {
        return orderPrice;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    public void setPaymentId(Integer paymentId) {
        this.paymentId = paymentId;
    }

    public void setDeliveryId(Integer deliveryId) {
        this.deliveryId = deliveryId;
    }

    public void setDate(Date date) {
        this.date = date;
    }

    public void setOrderPrice(BigDecimal orderPrice) {
        this.orderPrice = orderPrice;
    }
}
