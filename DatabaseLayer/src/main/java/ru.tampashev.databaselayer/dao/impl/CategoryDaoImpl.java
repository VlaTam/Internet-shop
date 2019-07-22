package ru.tampashev.databaselayer.dao.impl;

import ru.tampashev.databaselayer.dao.CategoryDao;
import ru.tampashev.databaselayer.entities.CategoryEntity;

import java.util.Collection;

public class CategoryDaoImpl extends AbstractGenericDao<CategoryEntity> implements CategoryDao {

    @Override
    protected Class<CategoryEntity> getEntityClass() {
        return CategoryEntity.class;
    }

    @Override
    public Collection<CategoryEntity> findByCategoryName(String categoryName) {
        return null;
    }

    @Override
    public Collection<CategoryEntity> findAll() {
        return null;
    }
}
