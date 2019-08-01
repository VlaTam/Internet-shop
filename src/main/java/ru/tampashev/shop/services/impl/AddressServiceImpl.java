package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.converters.Converter;
import ru.tampashev.shop.dao.AddressDao;
import ru.tampashev.shop.dao.GenericDao;
import ru.tampashev.shop.dto.Address;
import ru.tampashev.shop.entities.AddressEntity;
import ru.tampashev.shop.services.AddressService;

@Service
public class AddressServiceImpl extends AbstractGenericService<AddressEntity, Address> implements AddressService {

    @Autowired
    @Qualifier("addressConverter")
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
}
