package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.converters.Converter;
import ru.tampashev.shop.dao.GenericDao;
import ru.tampashev.shop.dao.OrderProductDao;
import ru.tampashev.shop.dto.OrderProduct;
import ru.tampashev.shop.entities.OrderProductEntity;
import ru.tampashev.shop.services.OrderProductService;

import javax.transaction.Transactional;
import java.util.List;

@Service
@Transactional
public class OrderProductServiceImpl extends AbstractGenericService<OrderProductEntity, OrderProduct>
                                    implements OrderProductService {

    @Autowired
    private Converter<OrderProductEntity, OrderProduct> orderProductConverter;

    @Autowired
    private OrderProductDao orderProductDao;

    @Override
    protected Converter<OrderProductEntity, OrderProduct> getUserConverter() {
        return orderProductConverter;
    }

    @Override
    protected GenericDao<OrderProductEntity> getDao() {
        return orderProductDao;
    }

    @Override
    public List<OrderProduct> findByOrderId(Integer orderId) {
        List<OrderProductEntity> orderProductEntities = orderProductDao.findByOrderId(orderId);
        return orderProductConverter.convertToDtoList(orderProductEntities);
    }
}
