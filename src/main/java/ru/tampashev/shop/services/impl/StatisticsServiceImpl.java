package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.converters.ProductConverter;
import ru.tampashev.shop.converters.UserConverter;
import ru.tampashev.shop.dao.ProductDao;
import ru.tampashev.shop.dao.UserDao;
import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.dto.User;
import ru.tampashev.shop.entities.ProductEntity;
import ru.tampashev.shop.entities.UserEntity;
import ru.tampashev.shop.services.StatisticsService;

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
}
