package ru.tampashev.shop.converters;

import org.springframework.stereotype.Component;
import ru.tampashev.shop.dto.Category;
import ru.tampashev.shop.entities.CategoryEntity;

@Component("categoryConverter")
public class CategoryConverter implements Converter<CategoryEntity, Category> {

    @Override
    public Category convertToDto(CategoryEntity categoryEntity) {
        Category category = new Category();
        category.setId(categoryEntity.getId());
        category.setName(categoryEntity.getName());
        return category;
    }

    @Override
    public CategoryEntity convertToEntity(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        categoryEntity.setId(category.getId());
        categoryEntity.setName(category.getName());
        return categoryEntity;
    }
}
