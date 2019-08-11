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

    @Override
    public Integer find(AddressEntity addressEntity) {
        AddressEntity existedAddress = getSession()
                                            .createNamedQuery("address-find-unique", type)
                                            .setParameter("country", addressEntity.getCountry())
                                            .setParameter("city", addressEntity.getCity())
                                            .setParameter("street", addressEntity.getStreet())
                                            .setParameter("postalCode", addressEntity.getPostalCode())
                                            .setParameter("houseNumber", addressEntity.getHouseNumber())
                                            .setParameter("flatNumber", addressEntity.getFlatNumber())
                                            .uniqueResult();

        return (existedAddress != null) ? existedAddress.getId() : -1;
    }
}
