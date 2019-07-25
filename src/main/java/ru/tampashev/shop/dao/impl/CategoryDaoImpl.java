package ru.tampashev.shop.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tampashev.shop.dao.CategoryDao;
import ru.tampashev.shop.entities.CategoryEntity;

import java.util.Collection;

@Repository
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
