package ru.tampashev.databaselayer.converters;

import ru.tampashev.databaselayer.dto.CategoryDto;
import ru.tampashev.databaselayer.entities.Category;

import java.util.HashSet;
import java.util.Set;

public class CategoryConverter implements Converter<Category, CategoryDto> {

    public CategoryDto convertToDao(Category category) {
        CategoryDto categoryDto = new CategoryDto();
        categoryDto.id = category.getId();
        categoryDto.name = category.getName();
        return categoryDto;
    }

    public Set<CategoryDto> convertToDaoSet(Set<Category> categories) {
        HashSet<CategoryDto> categoryDtoSet = new HashSet<CategoryDto>(categories.size());

        for (Category category : categories){
            CategoryDto categoryDto = new CategoryDto();
            categoryDto.id = category.getId();
            categoryDto.name = category.getName();
            categoryDtoSet.add(categoryDto);
        }

        return categoryDtoSet;
    }

    public Category convertToEntity(CategoryDto categoryDto) {
        Category category = new Category();
        category.setId(categoryDto.id);
        category.setName(categoryDto.name);
        return category;
    }

    public Set<Category> convertToEntitySet(Set<CategoryDto> categoryDtoSet) {
        HashSet<Category> categorySet = new HashSet<Category>(categoryDtoSet.size());

        for (CategoryDto categoryDto : categoryDtoSet){
            Category category = new Category();
            category.setId(categoryDto.id);
            category.setName(categoryDto.name);
        }

        return categorySet;
    }
}
