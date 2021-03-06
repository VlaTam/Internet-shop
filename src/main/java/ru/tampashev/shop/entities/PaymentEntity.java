package ru.tampashev.shop.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "payment", schema = "internet_shop")
public class PaymentEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false, nullable = false)
    private Integer id;

    @Column(nullable = false, unique = true)
    private String method;

    @Column(nullable = false)
    private String paymentStatus;

    @OneToMany(targetEntity = OrderEntity.class, mappedBy = "payment", cascade = CascadeType.MERGE)
    private Collection<OrderEntity> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof PaymentEntity)) return false;
        PaymentEntity that = (PaymentEntity) o;
        return Objects.equals(id, that.id) &&
                Objects.equals(method, that.method) &&
                Objects.equals(paymentStatus, that.paymentStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, method, paymentStatus);
    }

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

    public void setPaymentStatus(String status) {
        this.paymentStatus = status;
    }
}
