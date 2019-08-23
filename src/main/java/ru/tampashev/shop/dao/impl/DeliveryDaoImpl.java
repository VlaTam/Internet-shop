package ru.tampashev.shop.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tampashev.shop.dao.DeliveryDao;
import ru.tampashev.shop.entities.DeliveryEntity;

import java.util.List;

@Repository
public class DeliveryDaoImpl extends AbstractGenericDao<DeliveryEntity> implements DeliveryDao {

    public DeliveryDaoImpl() {
        type = DeliveryEntity.class;
    }

    @Override
    public Integer find(DeliveryEntity deliveryEntity) {
        DeliveryEntity existedDelivery = getSession()
                                            .createNamedQuery("delivery-find", type)
                                            .setParameter("method", deliveryEntity.getMethod())
                                            .setParameter("deliveryStatus", deliveryEntity.getDeliveryStatus())
                                            .uniqueResult();

        return existedDelivery != null ? existedDelivery.getId() : -1;
    }

    @Override
    public List<DeliveryEntity> findAll() {
        return getSession().createNamedQuery("delivery-find-all", type).getResultList();
    }
}
