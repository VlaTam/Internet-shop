package ru.tampashev.databaselayer;

import java.io.Serializable;

public interface GenericDao <E, K extends Serializable>{

    K create(E newInstance);
    E getById(K id);
    void update(E transientObject);
    void delete(E persistentObject);
}
