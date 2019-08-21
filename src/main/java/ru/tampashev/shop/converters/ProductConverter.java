package ru.tampashev.shop.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tampashev.shop.dto.Category;
import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.entities.ProductEntity;

import java.util.ArrayList;
import java.util.List;
import java.util.stream.Collectors;

@Component
@SuppressWarnings("all")
public class ProductConverter implements Converter<ProductEntity, Product> {

    @Autowired
    private ParametersConverter parametersConverter;

    @Autowired
    private CategoryConverter categoryConverter;

    @Override
    public Product convertToDto(ProductEntity productEntity) {
        /*ModelMapper mapper = new ModelMapper();
        Product prod = mapper.map(productEntity, Product.class);*/
        Product product = new Product();
        product.setId(productEntity.getId());

        if (productEntity.getCategory() == null) {
            product.setCategory(getNotDefinedCategory());
        } else
            product.setCategory(categoryConverter.convertToDto(productEntity.getCategory()));

        product.setName(productEntity.getName());
        product.setParameters(parametersConverter.convertToDto(productEntity.getParameters()));
        product.setVolume(productEntity.getVolume());
        product.setWeight(productEntity.getWeight());
        product.setPrice(productEntity.getPrice());
        product.setQuantityInStock(productEntity.getQuantityInStock());
        product.setStatus(productEntity.getStatus());
        return product;
    }

    private Category getNotDefinedCategory(){
        Category category = new Category();
        category.setName("not defined");
        return category;
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
        productEntity.setStatus(product.getStatus());
        return productEntity;
    }

    @Override
    public List<Product> convertToDtoList(List<ProductEntity> productEntities) {
        List<Product> products = new ArrayList<>(productEntities.size());

        //productEntities.stream().map(productEntity -> convertToDtoList(productEntity)).collect(Collectors.toList());

        for (ProductEntity productEntity : productEntities) {
            Product product = convertToDto(productEntity);
            products.add(product);
        }

        return products;
    }

    @Override
    public List<ProductEntity> convertToEntityList(List<Product> products) {
        List<ProductEntity> productEntities = new ArrayList<>(products.size());

        for (Product product : products){
            ProductEntity productEntity = convertToEntity(product);
            productEntities.add(productEntity);
        }

        return productEntities;
    }
}
