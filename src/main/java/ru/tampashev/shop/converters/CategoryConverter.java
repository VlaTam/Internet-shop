package ru.tampashev.shop.converters;

import org.springframework.stereotype.Component;
import ru.tampashev.shop.dto.Category;
import ru.tampashev.shop.entities.CategoryEntity;

@Component("categoryConverter")
public class CategoryConverter extends AbstractConverter<CategoryEntity, Category> {

    @Override
    protected Category convertEntity(CategoryEntity categoryEntity) {
        Category category = new Category();
        //category.id = categoryEntity.getId();
        category.name = categoryEntity.getName();
        return category;
    }

    @Override
    protected CategoryEntity convertDto(Category category) {
        CategoryEntity categoryEntity = new CategoryEntity();
        //categoryEntity.setId(category.id);
        categoryEntity.setName(category.name);
        return categoryEntity;
    }
}
