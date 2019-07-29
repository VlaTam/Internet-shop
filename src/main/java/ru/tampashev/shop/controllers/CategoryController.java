package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tampashev.shop.dto.Category;
import ru.tampashev.shop.services.CategoryService;

@Controller
@RequestMapping("/category")
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @GetMapping
    public String openPage(Model model){
        model.addAttribute("category", new Category());
        model.addAttribute("categories", categoryService.findAll());
        return "category";
    }

    @GetMapping("/edit/{id}")
    public String openEditPage(@PathVariable("id") Integer categoryId, Model model){
        Category category = categoryService.findById(categoryId);
        model.addAttribute("category", category);
        return "edit_category";
    }

    @PostMapping
    public void addCategory(@ModelAttribute("category") Category category) {
        categoryService.create(category);
    }

    @PostMapping("/edit")
    public String updateCategory(@ModelAttribute("category") Category category, Model model){
        categoryService.update(category);
        Category newCategory = categoryService.findById(category.getId());
        model.addAttribute("category", newCategory);
        return "updated_category";
    }

    @GetMapping("/delete/{id}")
    public String deleteCategory(@PathVariable("id") Integer id){
        Category category = categoryService.findById(id);
        categoryService.delete(category);
        return "delete_category";
    }
}
