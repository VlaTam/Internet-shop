package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tampashev.shop.dto.Category;
import ru.tampashev.shop.dto.Parameters;
import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.services.CategoryService;
import ru.tampashev.shop.services.ParametersService;
import ru.tampashev.shop.services.ProductService;

import java.util.Collection;

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

        Collection<Category> categories = categoryService.findAll();
        model.addAttribute("categories", categories);

        Collection<Parameters> parameters = parametersService.findAll();
        model.addAttribute("parameters", parameters);
        return "employee/product/add_product";
    }

    @PostMapping("/add")
    public String saveProduct(@ModelAttribute("product") Product product){
        Integer categoryId = product.getCategory().getId();
        Category category = categoryService.findById(categoryId);
        product.setCategory(category);

        Integer parametersId = product.getParameters().getId();
        Parameters parameters = parametersService.findById(parametersId);
        product.setParameters(parameters);

        productService.create(product);
        return "index";
    }
}
