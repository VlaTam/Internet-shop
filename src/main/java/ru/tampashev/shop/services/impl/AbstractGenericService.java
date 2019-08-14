package ru.tampashev.shop.services.impl;


import ru.tampashev.shop.converters.Converter;
import ru.tampashev.shop.dao.GenericDao;
import ru.tampashev.shop.services.GenericService;

import java.io.Serializable;
import javax.transaction.Transactional;

@Transactional
public abstract class AbstractGenericService <E extends Serializable, T> implements GenericService<T> {

    @Override
    public Integer create(T object) {
        E entity = getConverter().convertToEntity(object);

        Integer entityId = getDao().find(entity);
        if (entityId > 0)
            return entityId;

        return getDao().create(entity);
    }

    @Override
    public void update(T object) {
        E entity = getConverter().convertToEntity(object);
        getDao().update(entity);
    }

    @Override
    public T findById(Integer id) {
        E entity = getDao().findById(id);
        return getConverter().convertToDto(entity);
    }

    @Override
    public void delete(T object) {
        E entity = getConverter().convertToEntity(object);
        getDao().delete(entity);
    }

    protected abstract Converter<E, T> getConverter();
    protected abstract GenericDao<E> getDao();
}
