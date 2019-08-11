package ru.tampashev.shop.services;

public interface GenericService <T> {

    Integer create(T object);

    T findById(Integer id);

    default Integer find(T object){return -1;}

    void delete(T object);

    void update(T object);

}
