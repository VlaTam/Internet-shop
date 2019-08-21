package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tampashev.shop.dto.Parameters;
import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.services.CategoryService;
import ru.tampashev.shop.services.ParametersService;
import ru.tampashev.shop.services.ProductService;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private ParametersService parametersService;

    @Autowired
    private ProductService productService;

    @GetMapping("/add")
    public String addProduct(Model model){
        model.addAttribute("product", new Product());
        model.addAttribute("parameters", new Parameters());
        model.addAttribute("categories", categoryService.findAll());
        return "employee/product/add";
    }

    @PostMapping("/add")
    public String saveProduct(@ModelAttribute("product") Product product){
        return productService.create(product) > 0 ? "index" : "errors/product";
    }

    @GetMapping("/{id}")
    public String openProduct(@PathVariable("id") Integer id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product";
    }
}
