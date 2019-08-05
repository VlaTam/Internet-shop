package ru.tampashev.shop.dao.impl;

import org.springframework.stereotype.Repository;
import ru.tampashev.shop.dao.AddressDao;
import ru.tampashev.shop.entities.AddressEntity;

import java.util.Collection;

@Repository
public class AddressDaoImpl extends AbstractGenericDao<AddressEntity> implements AddressDao {

    public AddressDaoImpl() {
        type = AddressEntity.class;
    }

    @Override
    public Collection<AddressEntity> findAll() {
        return getSession().createNamedQuery("address-find-all", type).getResultList();
    }
}
