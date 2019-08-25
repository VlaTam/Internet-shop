package ru.tampashev.shop.dto;

public class OrderStatus {

    private Payment payment;
    private Delivery delivery;

    public Payment getPayment() {
        return payment;
    }

    public Delivery getDelivery() {
        return delivery;
    }

    public void setPayment(Payment payment) {
        this.payment = payment;
    }

    public void setDelivery(Delivery delivery) {
        this.delivery = delivery;
    }
}
