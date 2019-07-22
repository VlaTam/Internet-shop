package ru.tampashev.databaselayer.services;

import ru.tampashev.databaselayer.dto.Category;

import java.util.Collection;

public interface CategoryService {

    Category createCategory(Category category);

    Collection<Category> findAll();

    Category findById(Integer id);

    void deleteCategory(Integer id);
}
