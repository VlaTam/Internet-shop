package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.converters.Converter;
import ru.tampashev.shop.dao.GenericDao;
import ru.tampashev.shop.dao.OrderDao;
import ru.tampashev.shop.dto.*;
import ru.tampashev.shop.entities.OrderEntity;
import ru.tampashev.shop.entities.OrderProductEntity;
import ru.tampashev.shop.services.*;

import javax.servlet.http.HttpSession;
import javax.transaction.Transactional;
import java.math.BigDecimal;
import java.util.Date;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional
public class OrderServiceImpl extends AbstractGenericService<OrderEntity, Order> implements OrderService {

    @Autowired
    private HttpSession session;

    @Autowired
    private CommonService commonService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private ProductService productService;

    @Autowired
    private OrderProductService orderProductService;

    @Autowired
    private Converter<OrderProductEntity, OrderProduct> orderProductConverter;

    @Autowired
    private Converter<OrderEntity, Order> orderConverter;

    @Autowired
    private OrderDao orderDao;

    @Override
    protected Converter<OrderEntity, Order> getConverter() {
        return orderConverter;
    }

    @Override
    protected GenericDao<OrderEntity> getDao() {
        return orderDao;
    }

    @Override
    public Integer create(Order order) {
        order.setDate(new Date());
        order.setUser(commonService.getAuthorisedUser());

        BigDecimal totalPrice = new BigDecimal((String) session.getAttribute("totalPrice"));
        order.setTotalPrice(totalPrice);

        Payment payment = paymentService.findById(order.getPayment().getId());
        order.setPayment(payment);

        Delivery delivery = deliveryService.findById(order.getDelivery().getId());
        order.setDelivery(delivery);

        OrderEntity orderEntity = orderConverter.convertToEntity(order);
        Integer orderId = orderDao.create(orderEntity);

        createOrderProducts(orderId);

        return orderId;
    }

    private void createOrderProducts(Integer orderId){
        OrderProduct orderProduct = new OrderProduct();
        orderProduct.setOrder(findById(orderId));

        HashSet<Purchase> purchaseSet = (HashSet<Purchase>) session.getAttribute("purchaseSet");
        for (Purchase purchase : purchaseSet){
            orderProduct.setProduct(purchase.getProduct());
            orderProduct.setQuantityOfProduct(purchase.getQuantity());
            orderProduct.setFixProductPrice(purchase.getProduct().getPrice());
            orderProductService.create(orderProduct);
        }
    }

    @Override
    public List<Order> findUsersOrders() {
        Integer userId = commonService.getAuthorisedUser().getId();
        List<OrderEntity> orderEntityList = orderDao.findUsersOrders(userId);
        return orderConverter.convertToDtoList(orderEntityList);
    }
}
