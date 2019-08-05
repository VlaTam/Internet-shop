package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.converters.Converter;
import ru.tampashev.shop.dao.AddressDao;
import ru.tampashev.shop.dao.GenericDao;
import ru.tampashev.shop.dto.Address;
import ru.tampashev.shop.entities.AddressEntity;
import ru.tampashev.shop.services.AddressService;

import javax.transaction.Transactional;
import java.util.ArrayList;
import java.util.Collection;

@Service
@Transactional
public class AddressServiceImpl extends AbstractGenericService<AddressEntity, Address> implements AddressService {

    @Autowired
    private Converter<AddressEntity, Address> addressConverter;

    @Autowired
    private AddressDao addressDao;

    @Override
    protected Converter<AddressEntity, Address> getConverter() {
        return addressConverter;
    }

    @Override
    protected GenericDao<AddressEntity> getDao() {
        return addressDao;
    }

    @Override
    public Collection<Address> findAll() {
        Collection<AddressEntity> addressEntities = addressDao.findAll();
        Collection<Address> addresses = new ArrayList<>(addressEntities.size());

        for (AddressEntity addressEntity : addressEntities) {
            Address address = addressConverter.convertToDto(addressEntity);
            addresses.add(address);
        }
        return addresses;
    }
}
