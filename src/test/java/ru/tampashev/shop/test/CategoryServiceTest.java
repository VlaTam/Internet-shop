package ru.tampashev.shop.test;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.MockitoAnnotations;
import org.mockito.junit.MockitoJUnitRunner;
import ru.tampashev.shop.converters.CategoryConverter;
import ru.tampashev.shop.dao.CategoryDao;
import ru.tampashev.shop.dto.Category;
import ru.tampashev.shop.entities.CategoryEntity;
import ru.tampashev.shop.services.impl.CategoryServiceImpl;

import java.util.*;

import static org.junit.Assert.*;
import static org.mockito.Mockito.lenient;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class CategoryServiceTest {

    @InjectMocks
    private CategoryServiceImpl categoryService;

    @Mock
    private CategoryConverter categoryConverter;

    @Mock
    private CategoryDao categoryDao;

    @Before
    public void init(){
        MockitoAnnotations.initMocks(this);
    }

    @Test
    public void categoryCreateExpectedResult(){
        when(categoryConverter.convertToEntity(new Category())).thenReturn(new CategoryEntity());
        when(categoryDao.create(new CategoryEntity())).thenReturn(1);

        Integer categoryId = categoryService.create(new Category());
        assertEquals(new Integer(1), categoryId);
    }

    @Test
    public void categoryFindExpectedResult(){
        when(categoryConverter.convertToEntity(new Category())).thenReturn(new CategoryEntity());
        when(categoryDao.find(new CategoryEntity())).thenReturn(1);

        Integer categoryId = categoryService.find(new Category());
        assertEquals(new Integer(1), categoryId);
    }

    @Test
    public void categoryFindAllNotNull(){
        lenient().when(categoryConverter.convertToDto(new CategoryEntity())).thenReturn(new Category());
        Set<CategoryEntity> categoryEntitySet = new HashSet<>();
        when(categoryDao.findAll()).thenReturn(categoryEntitySet);

        Collection<Category> categoryCollection = categoryService.findAll();
        assertNotNull(categoryCollection);
    }
}
