package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.converters.Converter;
import ru.tampashev.shop.converters.ProductConverter;
import ru.tampashev.shop.dao.GenericDao;
import ru.tampashev.shop.dao.ProductDao;
import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.entities.ProductEntity;
import ru.tampashev.shop.services.ProductService;

@Service
public class ProductServiceImpl extends AbstractGenericService<ProductEntity, Product> implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    private ProductConverter productConverter;

    @Override
    protected Converter<ProductEntity, Product> getConverter() {
        return productConverter;
    }

    @Override
    protected GenericDao<ProductEntity> getDao() {
        return productDao;
    }
}
