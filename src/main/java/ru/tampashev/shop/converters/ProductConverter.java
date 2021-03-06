package ru.tampashev.shop.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.entities.ProductEntity;

@Component
@SuppressWarnings("all")
public class ProductConverter implements Converter<ProductEntity, Product> {

    @Autowired
    private ParametersConverter parametersConverter;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public Product convertToDto(ProductEntity productEntity) {
        Product product = new Product();
        product.setId(productEntity.getId());
        product.setCategory(categoryConverter.convertToDto(productEntity.getCategory()));
        product.setName(productEntity.getName());
        product.setParameters(parametersConverter.convertToDto(productEntity.getParameters()));
        product.setVolume(productEntity.getVolume());
        product.setWeight(productEntity.getWeight());
        product.setPrice(productEntity.getPrice());
        product.setQuantityInStock(productEntity.getQuantityInStock());
        return product;
    }

    @Override
    public ProductEntity convertToEntity(Product product) {
        ProductEntity productEntity = new ProductEntity();
        productEntity.setId(product.getId());
        productEntity.setCategory(categoryConverter.convertToEntity(product.getCategory()));
        productEntity.setName(product.getName());
        productEntity.setParameters(parametersConverter.convertToEntity(product.getParameters()));
        productEntity.setVolume(product.getVolume());
        productEntity.setWeight(product.getWeight());
        productEntity.setPrice(product.getPrice());
        productEntity.setQuantityInStock(product.getQuantityInStock());
        return productEntity;
    }
}
