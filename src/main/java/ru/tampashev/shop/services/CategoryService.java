package ru.tampashev.shop.services;

import ru.tampashev.shop.dto.Category;
import ru.tampashev.shop.exceptions.NoSuchCategoryException;

import java.util.Collection;

public interface CategoryService extends GenericService<Category>{

    Collection<Category> findAll();
}
