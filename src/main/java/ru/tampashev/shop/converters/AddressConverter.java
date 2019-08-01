package ru.tampashev.shop.converters;

import org.springframework.stereotype.Component;
import ru.tampashev.shop.dto.Address;
import ru.tampashev.shop.entities.AddressEntity;

@Component
@SuppressWarnings("all")
public class AddressConverter implements Converter<AddressEntity, Address> {

    @Override
    public Address convertToDto(AddressEntity addressEntity) {
        Address address = new Address();
        address.setId(addressEntity.getId());
        address.setCountry(addressEntity.getCountry());
        address.setCity(addressEntity.getCity());
        address.setStreet(addressEntity.getStreet());
        address.setHouseNumber(addressEntity.getHouseNumber());
        address.setFlatNumber(addressEntity.getFlatNumber());
        address.setPostalCode(addressEntity.getPostalCode());
        return address;
    }

    @Override
    public AddressEntity convertToEntity(Address address) {
        AddressEntity addressEntity = new AddressEntity();
        addressEntity.setId(address.getId());
        addressEntity.setCountry(address.getCountry());
        addressEntity.setCity(address.getCity());
        addressEntity.setStreet(address.getStreet());
        addressEntity.setHouseNumber(address.getHouseNumber());
        addressEntity.setFlatNumber(address.getFlatNumber());
        addressEntity.setPostalCode(address.getPostalCode());
        return addressEntity;
    }
}
