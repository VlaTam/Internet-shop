package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.converters.CategoryConverter;
import ru.tampashev.shop.dao.CategoryDao;
import ru.tampashev.shop.dto.Category;
import ru.tampashev.shop.entities.CategoryEntity;
import ru.tampashev.shop.services.CategoryService;

import javax.transaction.Transactional;
import java.util.Collection;

@Service("categoryServiceImpl")
@Transactional
public class CategoryServiceImpl implements CategoryService {

    @Autowired
    private CategoryDao categoryDao;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public Category createCategory(Category category) {
        CategoryEntity categoryEntity = categoryConverter.convertToEntity(category);
        categoryDao.create(categoryEntity);
        return categoryConverter.convertToDao(categoryEntity);
    }

    @Override
    public Collection<Category> findAll() {
        return null;
    }

    @Override
    public Category findById(Integer id) {
        return null;
    }

    @Override
    public void deleteCategory(Integer id) {

    }
}
