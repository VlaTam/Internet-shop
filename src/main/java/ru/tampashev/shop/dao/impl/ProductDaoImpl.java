package ru.tampashev.shop.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tampashev.shop.dao.ProductDao;
import ru.tampashev.shop.entities.ProductEntity;

import java.util.List;

@Repository
public class ProductDaoImpl extends AbstractGenericDao<ProductEntity> implements ProductDao {

    public ProductDaoImpl() {
        type = ProductEntity.class;
    }

    @Override
    public List<ProductEntity> findAll() {
        return getSession().createNamedQuery("product-find-all", type).getResultList();
    }

    @Override
    public Integer find(ProductEntity productEntity) {
        ProductEntity existedEntity = getSession()
                .createNamedQuery("product-find", type)
                .setParameter("name", productEntity.getName())
                .setParameter("brand", productEntity.getParameters().getBrand())
                .setParameter("width", productEntity.getParameters().getWidth())
                .setParameter("height", productEntity.getParameters().getHeight())
                .setParameter("radius", productEntity.getParameters().getRadius())
                .uniqueResult();

        return existedEntity != null ? existedEntity.getId() : -1;
    }
}
