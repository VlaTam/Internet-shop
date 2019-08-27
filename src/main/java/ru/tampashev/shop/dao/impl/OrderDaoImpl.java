package ru.tampashev.shop.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tampashev.shop.dao.OrderDao;
import ru.tampashev.shop.entities.DeliveryEntity;
import ru.tampashev.shop.entities.OrderEntity;
import ru.tampashev.shop.entities.PaymentEntity;
import ru.tampashev.shop.entities.UserEntity;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.util.List;
import java.util.stream.Collectors;

@Repository
public class OrderDaoImpl extends AbstractGenericDao<OrderEntity> implements OrderDao {

    public OrderDaoImpl() {
        type = OrderEntity.class;
    }

    @Override
    public List<OrderEntity> findUsersOrders(Integer userId) {
        return getSession()
                .createNamedQuery("order-find-history-of-user", type)
                .setParameter("userId", userId)
                .getResultList();
    }

    @Override
    public List<OrderEntity> findByStatus(DeliveryEntity deliveryEntity, PaymentEntity paymentEntity) {
        CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
        CriteriaQuery<OrderEntity> query = criteriaBuilder.createQuery(OrderEntity.class);
        Root<OrderEntity> orderEntityRoot = query.from(OrderEntity.class);
        query.select(orderEntityRoot);

        Predicate predicateDeliveryMethod = criteriaBuilder.and();
        if (deliveryEntity.getMethod() != null && !deliveryEntity.getMethod().isEmpty()){
            predicateDeliveryMethod = criteriaBuilder.equal(orderEntityRoot.get("delivery").get("method"), deliveryEntity.getMethod());
        }

        Predicate predicateDeliveryStatus = criteriaBuilder.and();
        if (deliveryEntity.getDeliveryStatus() != null && !deliveryEntity.getDeliveryStatus().isEmpty()){
            predicateDeliveryStatus = criteriaBuilder.equal(orderEntityRoot.get("delivery").get("deliveryStatus"), deliveryEntity.getDeliveryStatus());
        }

        Predicate predicatePaymentMethod = criteriaBuilder.and();
        if (paymentEntity.getMethod() != null && !paymentEntity.getMethod().isEmpty()){
            predicatePaymentMethod = criteriaBuilder.equal(orderEntityRoot.get("payment").get("method"), paymentEntity.getMethod());
        }

        Predicate predicatePaymentStatus = criteriaBuilder.and();
        if (paymentEntity.getPaymentStatus() != null && !paymentEntity.getPaymentStatus().isEmpty()){
            predicatePaymentStatus = criteriaBuilder.equal(orderEntityRoot.get("payment").get("paymentStatus"), paymentEntity.getPaymentStatus());
        }

        Predicate predicate = criteriaBuilder.and(predicateDeliveryMethod, predicatePaymentMethod, predicateDeliveryStatus, predicatePaymentStatus);
        query.where(predicate);
        return getSession().createQuery(query).getResultList();
    }

    @Override
    public List<OrderEntity> findActiveOrders() {
        return getSession().createNamedQuery("order-find-all", type).getResultList();
    }
}
