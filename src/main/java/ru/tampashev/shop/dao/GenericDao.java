package ru.tampashev.shop.dao;

import org.springframework.stereotype.Repository;

import java.io.Serializable;

@Repository
public interface GenericDao <E extends Serializable> {

    Integer create(E entity);
    E findById(Integer id);
    default Integer find(E entity){return -1;}
    void update(E entity);
    void delete(E entity);
}
