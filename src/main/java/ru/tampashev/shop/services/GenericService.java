package ru.tampashev.shop.services;

import ru.tampashev.shop.exceptions.ObjectAlreadyExistException;

public interface GenericService <T> {

    Integer create(T object) throws ObjectAlreadyExistException;

    T findById(Integer id);

    Integer find(T object);

    void delete(T object);

    void update(T object);

}
