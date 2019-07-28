package ru.tampashev.shop.services;

import ru.tampashev.shop.dto.Category;

import java.util.Collection;

public interface CategoryService {

    Category createCategory(Category category);

    Collection<Category> findAll();

    Category findById(Integer id);

    void deleteCategory(Category category);

    void update(Category category);
}
