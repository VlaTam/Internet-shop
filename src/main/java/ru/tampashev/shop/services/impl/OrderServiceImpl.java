package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.converters.Converter;
import ru.tampashev.shop.dao.GenericDao;
import ru.tampashev.shop.dao.OrderDao;
import ru.tampashev.shop.dto.Order;
import ru.tampashev.shop.entities.OrderEntity;
import ru.tampashev.shop.services.OrderService;

import javax.transaction.Transactional;

@Service
@Transactional
public class OrderServiceImpl extends AbstractGenericService<OrderEntity, Order> implements OrderService {

    @Autowired
    private Converter<OrderEntity, Order> orderConverter;

    @Autowired
    private OrderDao orderDao;

    @Override
    protected Converter<OrderEntity, Order> getUserConverter() {
        return orderConverter;
    }

    @Override
    protected GenericDao<OrderEntity> getDao() {
        return orderDao;
    }
}