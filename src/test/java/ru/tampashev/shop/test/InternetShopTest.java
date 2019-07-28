package ru.tampashev.shop.test;

import org.hibernate.SessionFactory;
import org.junit.Assert;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.tampashev.shop.config.DatabaseConfig;
import ru.tampashev.shop.converters.CategoryConverter;
import ru.tampashev.shop.dao.impl.CategoryDaoImpl;
import ru.tampashev.shop.dto.Category;
import ru.tampashev.shop.entities.CategoryEntity;
import ru.tampashev.shop.services.CategoryService;
import ru.tampashev.shop.services.impl.CategoryServiceImpl;

import java.util.Collection;

public class InternetShopTest {

    @Ignore
    @Test
    public void createContext(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);

        SessionFactory sessionFactory = (SessionFactory) context.getBean("sessionFactory");
        Assert.assertNotNull(sessionFactory);
        System.out.println(sessionFactory);
    }

    @Ignore
    @Test
    public void addCategory(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DatabaseConfig.class, CategoryEntity.class, CategoryDaoImpl.class, CategoryConverter.class, CategoryServiceImpl.class, Category.class);
        context.refresh();

        Category category = new Category();
        category.setName("Winter tyres");

        CategoryService categoryService = (CategoryService) context.getBean("categoryServiceImpl");
        categoryService.createCategory(category);
    }

    @Ignore
    @Test
    public void findAllCategories(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DatabaseConfig.class, CategoryEntity.class, CategoryDaoImpl.class, CategoryConverter.class, CategoryServiceImpl.class, Category.class);
        context.refresh();

        CategoryService categoryService = (CategoryService) context.getBean("categoryServiceImpl");
        Collection<Category> categories = categoryService.findAll();
        for (Category category : categories)
            System.out.println(category.getId() + " " + category.getName());
    }

    @Ignore
    @Test
    public void findByIdCategories(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DatabaseConfig.class, CategoryEntity.class, CategoryDaoImpl.class, CategoryConverter.class, CategoryServiceImpl.class, Category.class);
        context.refresh();

        CategoryService categoryService = (CategoryService) context.getBean("categoryServiceImpl");
        Category category = categoryService.findById(3);
        System.out.println(category);
        Assert.assertNotNull(category);
    }

    @Test
    public void deleteCategory(){
        AnnotationConfigApplicationContext context = new AnnotationConfigApplicationContext();
        context.register(DatabaseConfig.class, CategoryEntity.class, CategoryDaoImpl.class, CategoryConverter.class, CategoryServiceImpl.class, Category.class);
        context.refresh();

        Category category = new Category();
        category.setId(1);
        category.setName("winter tyres");

        CategoryService categoryService = (CategoryService) context.getBean("categoryServiceImpl");
        categoryService.deleteCategory(category);
    }
}
