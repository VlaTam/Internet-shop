package ru.tampashev.shop.services.impl;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import ru.tampashev.shop.converters.Converter;
import ru.tampashev.shop.dao.GenericDao;
import ru.tampashev.shop.dao.ProductDao;
import ru.tampashev.shop.dto.Category;
import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.entities.ProductEntity;
import ru.tampashev.shop.services.CategoryService;
import ru.tampashev.shop.services.ParametersService;
import ru.tampashev.shop.services.ProductService;

import javax.transaction.Transactional;
import java.util.Collection;
import java.util.HashSet;
import java.util.List;

@Service
@Transactional
public class ProductServiceImpl extends AbstractGenericService<ProductEntity, Product> implements ProductService {

    @Autowired
    private ProductDao productDao;

    @Autowired
    @Qualifier("productConverter")
    private Converter<ProductEntity, Product> productConverter;

    @Autowired
    private ParametersService parametersService;

    @Autowired
    private CategoryService categoryService;

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
        List<ProductEntity> productEntities = productDao.findAll();
        return productConverter.convertToDtoList(productEntities);
    }

    @Override
    public Integer find(Product product) {
        ProductEntity productEntity = productConverter.convertToEntity(product);
        return productDao.find(productEntity);
    }

    @Override
    public Integer create(Product product) {
        Integer userId = -1;
        System.out.println(product.getCategory());
        Category category = categoryService.findById(product.getCategory().getId());

        if (find(product) < 0 & category.getName() != null){
            product.setCategory(category);
            Integer parametersId = parametersService.create(product.getParameters());
            product.getParameters().setId(parametersId);

            ProductEntity productEntity = productConverter.convertToEntity(product);
            userId = productDao.create(productEntity);
        }

        return userId;
    }
}
