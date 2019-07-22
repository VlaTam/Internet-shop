package ru.tampashev.databaselayer.dao;

import java.io.Serializable;

public interface GenericDao <E extends Serializable> {

    Integer create(E newInstance);
    E getById(Integer id);
    void update(E transientObject);
    void delete(E persistentObject);
}
