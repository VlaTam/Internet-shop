package ru.tampashev.shop.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.tampashev.shop.converters.ProductConverter;
import ru.tampashev.shop.converters.UserConverter;
import ru.tampashev.shop.dao.ProductDao;
import ru.tampashev.shop.dao.UserDao;
import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.dto.User;
import ru.tampashev.shop.services.impl.StatisticsServiceImpl;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class StatisticsServiceTest {

    @InjectMocks
    private StatisticsServiceImpl statisticsService;

    @Mock
    private ProductDao productDao;

    @Mock
    private ProductConverter productConverter;

    @Mock
    private UserDao userDao;

    @Mock
    private UserConverter userConverter;

    @Test
    public void statisticsGetTopTenProductsNotNull(){
        when(productDao.getTopTenProducts()).thenReturn(new ArrayList<>());
        when(productConverter.convertToDtoList(new ArrayList<>())).thenReturn(new ArrayList<>());

        List<Product> productList = statisticsService.getTopTenProducts();
        assertNotNull(productList);
    }

    @Test
    public void statisticsGetTopTenUsersNotNull(){
        when(userDao.getTopTenUsers()).thenReturn(new ArrayList<>());
        when(userConverter.convertToDtoList(new ArrayList<>())).thenReturn(new ArrayList<>());

        List<User> userList = statisticsService.getTopTenUsers();
        assertNotNull(userList);
    }
}
