package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import ru.tampashev.shop.dto.Category;
import ru.tampashev.shop.services.CategoryService;

@Controller
public class CategoryController {

    @Autowired
    private CategoryService categoryService;

    @RequestMapping({"/category"})
    public String openPage(){
        return "category";
    }

    @RequestMapping(value = {"/category"}, method = RequestMethod.POST)
    public void addCategory(@RequestBody Category category){
        categoryService.createCategory(category);
    }
}
