package ru.tampashev.shop.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.tampashev.shop.converters.AddressConverter;
import ru.tampashev.shop.dao.AddressDao;
import ru.tampashev.shop.dto.Address;
import ru.tampashev.shop.entities.AddressEntity;
import ru.tampashev.shop.services.impl.AddressServiceImpl;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.lenient;

@SuppressWarnings("all")
@RunWith(MockitoJUnitRunner.class)
public class AddressServiceTest {

    @InjectMocks
    private AddressServiceImpl addressService;

    @Mock
    private AddressConverter addressConverter;

    @Mock
    private AddressDao addressDao;

    @Test
    public void addressFindExpectedValue(){
        when(addressConverter.convertToEntity(new Address())).thenReturn(new AddressEntity());
        when(addressDao.find(new AddressEntity())).thenReturn(1);

        Integer addressId = addressService.find(new Address());
        assertEquals(new Integer(1), addressId);
    }

    @Test
    public void addressFindAllNotNull(){
        when(addressDao.findAll()).thenReturn(new ArrayList<>());
        lenient().when(addressConverter.convertToDto(new AddressEntity())).thenReturn(new Address());

        Collection<Address> addressCollection = addressService.findAll();
        assertNotNull(addressCollection);
    }
}
