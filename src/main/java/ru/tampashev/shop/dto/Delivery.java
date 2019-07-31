package ru.tampashev.shop.dto;

public class Delivery {

    private Integer id;
    private String method;
    private String status;

    public Integer getId() {
        return id;
    }

    public String getMethod() {
        return method;
    }

    public String getStatus() {
        return status;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public void setMethod(String method) {
        this.method = method;
    }

    public void setStatus(String status) {
        this.status = status;
    }
}
