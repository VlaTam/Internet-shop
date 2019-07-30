package ru.tampashev.shop.dao;

import ru.tampashev.shop.entities.ParametersEntity;

import java.util.Collection;

public interface ParametersDao extends GenericDao<ParametersEntity>{

    Collection<ParametersEntity> findAll();
}
