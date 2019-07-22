package ru.tampashev.databaselayer.dao.impl;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import ru.tampashev.databaselayer.dao.GenericDao;

import java.io.Serializable;

//@SuppressWarnings(value = "unused")
public abstract class AbstractGenericDao <E extends Serializable> implements GenericDao<E> {

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
    public Integer create(E newInstance){
        return (Integer) getSession().save(newInstance);
    }

    public E getById(Integer id) {
        return getSession().get(type, id);
    }

    public void update(E transientObject){
        getSession().update(transientObject);
    }

    public void delete(E persistentObject){
        getSession().delete(persistentObject);
    }
}
