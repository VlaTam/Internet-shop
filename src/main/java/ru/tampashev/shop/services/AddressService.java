package ru.tampashev.shop.services;

import ru.tampashev.shop.dto.Address;

import java.util.Collection;

public interface AddressService extends GenericService<Address> {

    Collection<Address> findAll();
}
