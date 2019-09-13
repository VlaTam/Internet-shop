package ru.tampashev.shop.test;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import ru.tampashev.shop.converters.ParametersConverter;
import ru.tampashev.shop.dao.ParametersDao;
import ru.tampashev.shop.dto.Parameters;
import ru.tampashev.shop.entities.ParametersEntity;
import ru.tampashev.shop.services.impl.ParametersServiceImpl;

import java.util.ArrayList;
import java.util.Collection;

import static org.junit.Assert.*;
import static org.mockito.Mockito.when;
import static org.mockito.Mockito.lenient;

@SuppressWarnings("all")
@RunWith(MockitoJUnitRunner.class)
public class ParametersServiceTest {

    @InjectMocks
    private ParametersServiceImpl parametersService;

    @Mock
    private ParametersConverter parametersConverter;

    @Mock
    private ParametersDao parametersDao;

    @Test
    public void parametersFindExpectedResult(){
        when(parametersConverter.convertToEntity(new Parameters())).thenReturn(new ParametersEntity());
        when(parametersDao.find(new ParametersEntity())).thenReturn(1);

        Integer parametersId = parametersService.find(new Parameters());
        assertEquals(new Integer(1), parametersId);
    }

    @Test
    public void parametersFindAllNotNull(){
        when(parametersDao.findAll()).thenReturn(new ArrayList<>());
        lenient().when(parametersConverter.convertToDto(new ParametersEntity())).thenReturn(new Parameters());

        Collection<Parameters> parametersCollection = parametersService.findAll();
        assertNotNull(parametersCollection);
    }
}
