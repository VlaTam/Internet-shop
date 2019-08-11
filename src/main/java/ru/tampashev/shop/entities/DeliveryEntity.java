package ru.tampashev.shop.entities;

import javax.persistence.*;
import java.io.Serializable;
import java.util.Collection;
import java.util.Objects;

@Entity
@Table(name = "delivery", schema = "internet_shop")
@NamedQueries({
        @NamedQuery(name = "delivery-find-all",
                query = "FROM DeliveryEntity"),
        @NamedQuery(name = "delivery-find",
                query = "FROM DeliveryEntity delivery " +
                        "WHERE delivery.method = :method " +
                        "AND delivery.deliveryStatus = :deliveryStatus")
})
public class DeliveryEntity implements Serializable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(insertable = false, updatable = false, nullable = false)
    private Integer id;

    @Column(nullable = false)
    private String method;

    @Column(nullable = false)
    private String deliveryStatus;

    @OneToMany(targetEntity = OrderEntity.class, mappedBy = "delivery", cascade = CascadeType.MERGE)
    private Collection<OrderEntity> orders;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (!(o instanceof DeliveryEntity)) return false;
        DeliveryEntity that = (DeliveryEntity) o;
        return Objects.equals(method, that.method) &&
                Objects.equals(deliveryStatus, that.deliveryStatus);
    }

    @Override
    public int hashCode() {
        return Objects.hash(method, deliveryStatus);
    }

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

    public void setDeliveryStatus(String status) {
        this.deliveryStatus = status;
    }
}
