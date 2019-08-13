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

        //List<Predicate> predicateList = new ArrayList<>();

        Predicate[] predicateArray = new Predicate[4];

        if (parametersEntity.getBrand() != null){
            predicateArray[0] = criteriaBuilder.equal(productEntityRoot.get("parameters").get("brand"), parametersEntity.getBrand());
            //predicateList.add(predicate);
        }

        if (parametersEntity.getWidth() != null){
            predicateArray[1] = criteriaBuilder.equal(productEntityRoot.get("parameters").get("width"), parametersEntity.getWidth());
            //predicateList.add(predicate);
        }

        if (parametersEntity.getHeight() != null){
            predicateArray[2] = criteriaBuilder.equal(productEntityRoot.get("parameters").get("height"), parametersEntity.getHeight());
            //predicateList.add(predicate);
        }

        if (parametersEntity.getRadius() != null){
            predicateArray[3] = criteriaBuilder.equal(productEntityRoot.get("parameters").get("radius"), parametersEntity.getRadius());
            //predicateList.add(predicate);
        }

        //Predicate[] predicateArray = new Predicate[predicateList.size()];
        //Predicate predicate = criteriaBuilder.and( predicateList.toArray(predicateArray));

        //query.where(predicateArray);
        return getSession().createQuery(query).getResultList();
    }
}
