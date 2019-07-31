package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.converters.Converter;
import ru.tampashev.shop.dao.GenericDao;
import ru.tampashev.shop.dao.ProductDao;
import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.entities.ProductEntity;
import ru.tampashev.shop.services.ProductService;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;

@Service
@Transactional
public class ProductServiceImpl extends AbstractGenericService<ProductEntity, Product> implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    @Qualifier("productConverter")
    private Converter<ProductEntity, Product> productConverter;

    @Override
    protected Converter<ProductEntity, Product> getConverter() {
        return productConverter;
    }

    @Override
    protected GenericDao<ProductEntity> getDao() {
        return productDao;
    }

    @Override
    public Collection<Product> findAll() {
        Collection<ProductEntity> productEntities = productDao.findAll();
        Collection<Product> products = new HashSet<>(productEntities.size());

        for (ProductEntity productEntity : productEntities) {
            Product product = productConverter.convertToDto(productEntity);
            products.add(product);
        }
        return products;
    }
}
