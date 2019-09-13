package ru.tampashev.shop.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import ru.tampashev.shop.converters.ProductConverter;
import ru.tampashev.shop.dao.ProductDao;
import ru.tampashev.shop.dto.Category;
import ru.tampashev.shop.dto.Parameters;
import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.entities.ProductEntity;
import ru.tampashev.shop.services.CategoryService;
import ru.tampashev.shop.services.ParametersService;
import ru.tampashev.shop.services.impl.ProductServiceImpl;

import java.util.ArrayList;
import java.util.List;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class ProductServiceTest {

    @InjectMocks
    private ProductServiceImpl productService;

    @Mock
    private ProductDao productDao;

    @Mock
    private ProductConverter productConverter;

    @Mock
    private CategoryService categoryService;

    @Mock
    private ParametersService parametersService;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void productFindAllNotNull(){
        when(productDao.findAll()).thenReturn(new ArrayList<>());
        when(productConverter.convertToDtoList(new ArrayList<>())).thenReturn(new ArrayList<>());

        List<Product> productList = productService.findAll();
        assertNotNull(productList);
    }

    @Test
    public void productFindExpectedResult(){
        when(productConverter.convertToEntity(new Product())).thenReturn(new ProductEntity());
        when(productDao.find(new ProductEntity())).thenReturn(1);

        Integer productId = productService.find(new Product());
        assertEquals(new Integer(1), productId);
    }

    @Test
    public void productCreateExpectedResult(){
        Category category = new Category();
        category.setId(1);
        category.setName("Winter tyres");
        Parameters parameters = new Parameters();
        parameters.setId(1);

        Product product = new Product();
        product.setCategory(category);
        product.setParameters(parameters);

        when(productConverter.convertToEntity(product)).thenReturn(new ProductEntity());
        when(productDao.create(new ProductEntity())).thenReturn(1);
        when(categoryService.findById(product.getCategory().getId())).thenReturn(category);
        when(parametersService.create(new Parameters())).thenReturn(1);
        when(productService.find(product)).thenReturn(-1);

        Integer productId = productService.create(product);
        assertEquals(new Integer(1), productId);
    }
}
