package ru.tampashev.databaselayer.dao;

import ru.tampashev.databaselayer.entities.CategoryEntity;

import java.util.Collection;

public interface CategoryDao extends GenericDao<CategoryEntity> {

    Collection<CategoryEntity> findByCategoryName(String categoryName);

    Collection<CategoryEntity> findAll();

}
