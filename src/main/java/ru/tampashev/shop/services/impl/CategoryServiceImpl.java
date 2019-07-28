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
import java.util.HashSet;

@Service
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
        return categoryConverter.convertToDto(categoryEntity);
    }

    @Override
    public void update(Category category) {
        CategoryEntity categoryEntity = categoryConverter.convertToEntity(category);
        categoryDao.update(categoryEntity);
    }

    @Override
    public Collection<Category> findAll() {
        Collection<CategoryEntity> entities = categoryDao.findAll();
        Collection<Category> categories = new HashSet<>(entities.size());

        for (CategoryEntity categoryEntity : entities) {
            Category category = new CategoryConverter().convertToDto(categoryEntity);
            categories.add(category);
        }
        return categories;
    }

    @Override
    public Category findById(Integer id) {
        CategoryEntity categoryEntity = categoryDao.findById(id);
        return new CategoryConverter().convertToDto(categoryEntity);
    }

    @Override
    public void deleteCategory(Category category) {
        CategoryEntity categoryEntity = categoryConverter.convertToEntity(category);
        categoryDao.delete(categoryEntity);
    }
}
