package ru.tampashev.shop.entities;

import javax.persistence.Entity;
import javax.persistence.Table;
import java.math.BigDecimal;
import java.util.Date;

@Entity
@Table(name = "order", schema = "internet_shop")
public class OrderEntity {

    private Integer id;
    //private Integer userId;
    //private Integer paymentId;
    //private Integer deliveryId;
    private Date date;
    private BigDecimal orderPrice;




}
