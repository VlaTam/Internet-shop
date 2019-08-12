package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.converters.Converter;
import ru.tampashev.shop.dao.CategoryDao;
import ru.tampashev.shop.dao.GenericDao;
import ru.tampashev.shop.dto.Category;
import ru.tampashev.shop.entities.CategoryEntity;
import ru.tampashev.shop.exceptions.NoSuchCategoryException;
import ru.tampashev.shop.services.CategoryService;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;

@Service
@Transactional
public class CategoryServiceImpl extends AbstractGenericService<CategoryEntity, Category> implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    @Qualifier("categoryConverter")
    private Converter<CategoryEntity, Category> categoryConverter;

    @Override
    public Collection<Category> findAll() {
        Collection<CategoryEntity> entities = categoryDao.findAll();
        Collection<Category> categories = new HashSet<>(entities.size());

        for (CategoryEntity categoryEntity : entities) {
            Category category = categoryConverter.convertToDto(categoryEntity);
            categories.add(category);
        }
        return categories;
    }

    @Override
    protected Converter<CategoryEntity, Category> getUserConverter() {
        return categoryConverter;
    }

    @Override
    protected GenericDao<CategoryEntity> getDao() {
        return categoryDao;
    }


    public Integer find(Category category) {
        CategoryEntity categoryEntity = categoryConverter.convertToEntity(category);
        return categoryDao.find(categoryEntity);
    }
}
