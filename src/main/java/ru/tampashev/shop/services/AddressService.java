package ru.tampashev.shop.services;

import ru.tampashev.shop.dto.Address;
import ru.tampashev.shop.entities.AddressEntity;

import java.util.Collection;

public interface AddressService extends GenericService<Address> {

    Collection<Address> findAll();

    //Integer findAddress(Address address);
}
