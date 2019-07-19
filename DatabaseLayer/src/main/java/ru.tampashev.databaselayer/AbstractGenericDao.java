package ru.tampashev.databaselayer;

import org.hibernate.HibernateException;
import org.hibernate.Session;
import org.hibernate.SessionFactory;

import java.io.Serializable;

public abstract class AbstractGenericDao <E, K extends Serializable> implements GenericDao <E, K> {

    private SessionFactory sessionFactory;
    private Class<E> type;

    public AbstractGenericDao(Class<E> type, SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
        this.type = type;
    }

    @SuppressWarnings(value = "all")
    protected Session getSession(){
        try {
            return sessionFactory.getCurrentSession();
        } catch (HibernateException e){
            return sessionFactory.openSession();
        }
    }

    @SuppressWarnings(value = "unchecked")
    public K create(E newInstance){
        return (K) getSession().save(newInstance);
    }

    public E getById(K id) {
        return getSession().get(type, id);
    }

    public void update(E transientObject){
        getSession().update(transientObject);
    }

    public void delete(E persistentObject){
        getSession().delete(persistentObject);
    }
}
