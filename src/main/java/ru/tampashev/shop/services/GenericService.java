package ru.tampashev.shop.services;

import java.util.Collection;

public interface GenericService <E> {

    E create(E object);

    Collection<E> findAll();

    E findById(Integer id);

    void delete(E object);

    void update(E object);
}
