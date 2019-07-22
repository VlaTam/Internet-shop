package ru.tampashev.databaselayer.services.impl;

import ru.tampashev.databaselayer.converters.CategoryConverter;
import ru.tampashev.databaselayer.dao.CategoryDao;
import ru.tampashev.databaselayer.dto.Category;
import ru.tampashev.databaselayer.services.CategoryService;

import java.util.Collection;

public class CategoryServiceImpl implements CategoryService {

    private CategoryDao categoryDao;
    private CategoryConverter categoryConverter;

    public CategoryServiceImpl() {
    }

    public void addCategory(){

    }

    @Override
    public Category createCategory(Category category) {
        return null;
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
