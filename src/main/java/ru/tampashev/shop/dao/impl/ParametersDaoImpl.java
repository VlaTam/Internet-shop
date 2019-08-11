package ru.tampashev.shop.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tampashev.shop.dao.ParametersDao;
import ru.tampashev.shop.entities.ParametersEntity;

import java.util.Collection;

@Repository
public class ParametersDaoImpl extends AbstractGenericDao<ParametersEntity> implements ParametersDao {

    public ParametersDaoImpl(){
        type = ParametersEntity.class;
    }

    @Override
    public Collection<ParametersEntity> findAll() {
        return getSession().createNamedQuery("parameters-find-all", type).getResultList();
    }

    @Override
    public Integer find(ParametersEntity parametersEntity) {
        ParametersEntity existedEntity = getSession()
                .createNamedQuery("parameters-find", type)
                .setParameter("brand", parametersEntity.getBrand())
                .setParameter("width", parametersEntity.getWidth())
                .setParameter("height", parametersEntity.getHeight())
                .setParameter("radius", parametersEntity.getRadius())
                .uniqueResult();

        return existedEntity != null ? existedEntity.getId() : -1;
    }
}
