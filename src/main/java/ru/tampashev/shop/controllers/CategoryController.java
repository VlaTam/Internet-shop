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
        return "employee/product/category";
    }

    @PostMapping
    public String addCategory(@ModelAttribute("category") Category category) {
        categoryService.create(category);
        return "redirect:/category";
    }

    @GetMapping("/edit/{id}")
    public String openEditPage(@PathVariable("id") Integer id, Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "employee/product/edit_category";
    }

    @PutMapping("/edit")
    public String updateCategory(@ModelAttribute("category") Category category){
        categoryService.update(category);
        return "redirect:/category";
    }

    @GetMapping("/delete/{id}")
    public String openDeletePage(@PathVariable("id") Integer id, Model model){
        Category category = categoryService.findById(id);
        model.addAttribute("category", category);
        return "employee/product/delete_category";
    }

    @DeleteMapping("/delete")
    public String deleteCategory(@ModelAttribute("category") Category category){
        categoryService.delete(category);
        return "redirect:/category";
    }
}
