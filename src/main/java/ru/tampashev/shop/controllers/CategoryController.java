package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tampashev.shop.dto.Category;
import ru.tampashev.shop.services.CategoryService;

public class CategoryController {

    @Autowired
    private CategoryService categoryService;


    public String openPage(){
        return "category";
    }


    /*public void addCategory(@RequestBody Category category){
        categoryService.createCategory(category);
    }*/
}
