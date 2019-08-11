package ru.tampashev.shop.converters;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import ru.tampashev.shop.dto.Category;
import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.entities.CategoryEntity;
import ru.tampashev.shop.entities.ProductEntity;

import java.util.Collection;
import java.util.HashSet;
import java.util.Set;

@Component("categoryConverter")
public class CategoryConverter implements Converter<CategoryEntity, Category> {

    @Autowired
    private Converter<ProductEntity, Product> converter;

    @Override
    public Category convertToDto(CategoryEntity categoryEntity) {
        Category category = new Category();
        if (categoryEntity != null){
            category.setId(categoryEntity.getId());
            category.setName(categoryEntity.getName());
        }


       /* Collection<ProductEntity> productEntities = categoryEntity.getProductEntities();

        if (productEntities != null) {
            Set<Product> products = new HashSet<>(productEntities.size());

            for (ProductEntity productEntity : productEntities)
                products.add(converter.convertToDto(productEntity));

            category.setProducts(products);
        }*/
        return category;
    }

    @Override
    public CategoryEntity convertToEntity(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        if (category != null){
            categoryEntity.setId(category.getId());
            categoryEntity.setName(category.getName());
        }

        /*Collection<Product> products = category.getProducts();

        if (products != null) {
            Set<ProductEntity> productEntities = new HashSet<>(products.size());

            for (Product product : products)
                productEntities.add(converter.convertToEntity(product));

            categoryEntity.setProductEntities(productEntities);
        }*/
        return categoryEntity;
    }
}
