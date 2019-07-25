package ru.tampashev.shop.services;

import org.springframework.stereotype.Repository;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.dto.Category;

import java.util.Collection;

//@Service
public interface CategoryService {

    Category createCategory(Category category);

    Collection<Category> findAll();

    Category findById(Integer id);

    void deleteCategory(Integer id);
}
