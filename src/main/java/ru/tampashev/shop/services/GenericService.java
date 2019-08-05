package ru.tampashev.shop.services;

public interface GenericService <T> {

    Integer create(T object);

    T findById(Integer id);

    void delete(T object);

    void update(T object);
}
