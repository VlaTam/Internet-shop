package ru.tampashev.shop.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tampashev.shop.dao.CategoryDao;
import ru.tampashev.shop.entities.CategoryEntity;

import java.util.Collection;

@Repository
public class CategoryDaoImpl extends AbstractGenericDao<CategoryEntity> implements CategoryDao {

    public CategoryDaoImpl() {
        type = CategoryEntity.class;
    }

    @Override
    public Collection<CategoryEntity> findAll() {
        return getSession()
                .createNamedQuery("category-find-all", type)
                .setParameter("status", "valid")
                .getResultList();
    }

    @Override
    public Integer find(CategoryEntity categoryEntity) {
        CategoryEntity existedCategory = getSession()
                                                .createNamedQuery("category-find", type)
                                                .setParameter("name", categoryEntity.getName())
                                                .uniqueResult();

        return existedCategory != null ? existedCategory.getId() : -1;
    }
}
