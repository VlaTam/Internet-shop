package ru.tampashev.shop.converters;

import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.entities.ProductEntity;

public class ProductConverter implements Converter<ProductEntity, Product> {

    @Override
    public Product convertToDto(ProductEntity entity) {

    }

    @Override
    public ProductEntity convertToEntity(Product dto) {
        return null;
    }
}
