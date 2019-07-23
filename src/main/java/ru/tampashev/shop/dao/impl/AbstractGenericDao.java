package ru.tampashev.shop.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.tampashev.shop.dao.GenericDao;

import java.io.Serializable;

//@SuppressWarnings(value = "unused")
@Repository
public abstract class AbstractGenericDao <E extends Serializable> implements GenericDao<E> {

    @Autowired
    private SessionFactory sessionFactory;

    private Class<E> type;

    protected abstract Class<E> getEntityClass();

    @SuppressWarnings(value = "all")
    protected Session getSession(){
        try {
            return sessionFactory.getCurrentSession();
        } catch (HibernateException e){
            return sessionFactory.openSession();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public Integer create(E entity){
        return (Integer) getSession().save(entity);
    }

    public E getById(Integer id) {
        return getSession().get(type, id);
    }

    public void update(E entity){
        getSession().update(entity);
    }

    public void delete(E entity){
        getSession().delete(entity);
    }
}
