package ru.tampashev.shop.dao;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface GenericDao <E extends Serializable> {

    Integer create(E entity);
    E findById(Integer id);
    Integer find(E entity);
    void update(E entity);
    void delete(E entity);
}
