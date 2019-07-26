package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.ui.ModelMap;
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
        return "category";
    }

    @PostMapping
    public void addCategory(@ModelAttribute("category") Category category) {
        System.out.println("Category name is " + category.getName());
        categoryService.createCategory(category);
    }
}
