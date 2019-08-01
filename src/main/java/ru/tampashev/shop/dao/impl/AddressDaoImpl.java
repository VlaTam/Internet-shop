package ru.tampashev.shop.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tampashev.shop.dao.AddressDao;
import ru.tampashev.shop.entities.AddressEntity;

@Repository
public class AddressDaoImpl extends AbstractGenericDao<AddressEntity> implements AddressDao {

    public AddressDaoImpl() {
        type = AddressEntity.class;
    }
}
