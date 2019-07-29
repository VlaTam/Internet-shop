package ru.tampashev.shop.dao;

import org.springframework.stereotype.Repository;
import ru.tampashev.shop.entities.CategoryEntity;

import java.util.Collection;

@Repository
public interface CategoryDao extends GenericDao<CategoryEntity> {

    Collection<CategoryEntity> findAll();
}
