package ru.tampashev.shop.services;

public interface GenericService <T> {

    T create(T object);

    T findById(Integer id);

    void delete(T object);

    void update(T object);
}
