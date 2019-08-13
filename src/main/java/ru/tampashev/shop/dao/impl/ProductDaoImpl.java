package ru.tampashev.shop.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tampashev.shop.dao.ProductDao;
import ru.tampashev.shop.entities.ParametersEntity;
import ru.tampashev.shop.entities.ProductEntity;

import javax.persistence.criteria.*;
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

    @Override
    public List<ProductEntity> findByParameters(ParametersEntity parametersEntity) {
        CriteriaBuilder criteriaBuilder = getSession().getCriteriaBuilder();
        CriteriaQuery<ProductEntity> query = criteriaBuilder.createQuery(ProductEntity.class);
        Root<ProductEntity> productEntityRoot = query.from(ProductEntity.class);
        query.select(productEntityRoot);

        Predicate predicateBrand = criteriaBuilder.and();
        if (parametersEntity.getBrand() != null && !parametersEntity.getBrand().isEmpty()){
            predicateBrand = criteriaBuilder.equal(productEntityRoot.get("parameters").get("brand"), parametersEntity.getBrand());
        }

        Predicate predicateWidth = criteriaBuilder.and();
        if (parametersEntity.getWidth() != null){
            predicateWidth = criteriaBuilder.equal(productEntityRoot.get("parameters").get("width"), parametersEntity.getWidth());
        }

        Predicate predicateHeight = criteriaBuilder.and();
        if (parametersEntity.getHeight() != null){
            predicateHeight = criteriaBuilder.equal(productEntityRoot.get("parameters").get("height"), parametersEntity.getHeight());
        }

        Predicate predicateRadius = criteriaBuilder.and();
        if (parametersEntity.getRadius() != null){
            predicateRadius = criteriaBuilder.equal(productEntityRoot.get("parameters").get("radius"), parametersEntity.getRadius());
        }

        Predicate predicate = criteriaBuilder.and(predicateBrand, predicateHeight, predicateWidth, predicateRadius);
        query.where(predicate);
        return getSession().createQuery(query).getResultList();
    }
}
