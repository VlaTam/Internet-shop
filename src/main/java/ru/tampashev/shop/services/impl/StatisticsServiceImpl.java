package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.converters.ProductConverter;
import ru.tampashev.shop.converters.UserConverter;
import ru.tampashev.shop.dao.OrderDao;
import ru.tampashev.shop.dao.ProductDao;
import ru.tampashev.shop.dao.UserDao;
import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.dto.User;
import ru.tampashev.shop.entities.ProductEntity;
import ru.tampashev.shop.entities.UserEntity;
import ru.tampashev.shop.services.StatisticsService;

import java.math.BigDecimal;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

@Service
public class StatisticsServiceImpl implements StatisticsService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductConverter productConverter;

    @Autowired
    private UserDao userDao;

    @Autowired
    private UserConverter userConverter;

    @Autowired
    private OrderDao orderDao;

    @Override
    public List<Product> getTopTenProducts() {
        List<ProductEntity> productEntityList = productDao.getTopTenProducts();
        return productConverter.convertToDtoList(productEntityList);
    }

    @Override
    public List<User> getTopTenUsers() {
        List<UserEntity> userEntityList = userDao.getTopTenUsers();
        return userConverter.convertToDtoList(userEntityList);
    }

    @Override
    public BigDecimal getProfitLastWeek() {
        GregorianCalendar calendar = new GregorianCalendar();
        Date endOfPeriod = calendar.getTime();

        calendar.add(Calendar.DAY_OF_MONTH, -7);
        Date startOfPeriod = calendar.getTime();

        return orderDao.getProfit(startOfPeriod, endOfPeriod);
    }

    @Override
    public BigDecimal getProfitLastMonth() {
        GregorianCalendar calendar = new GregorianCalendar();
        Date endOfPeriod = calendar.getTime();

        calendar.add(Calendar.MONTH, -1);
        Date startOfPeriod = calendar.getTime();

        return orderDao.getProfit(startOfPeriod, endOfPeriod);
    }
}
