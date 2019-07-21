package ru.tampashev.databaselayer.dao;

import ru.tampashev.databaselayer.entities.Category;

public class CategoryDao extends AbstractGenericDao<Category, Integer> {

    public CategoryDao() {
        super(Category.class);
    }
}
