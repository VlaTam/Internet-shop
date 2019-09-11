package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import ru.tampashev.shop.dto.Parameters;
import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.services.CategoryService;
import ru.tampashev.shop.services.JmsService;
import ru.tampashev.shop.services.ProductService;

import javax.validation.Valid;

@Controller
@RequestMapping("/product")
public class ProductController {

    @Autowired
    private CategoryService categoryService;

    @Autowired
    private JmsService jmsService;

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
    public String saveProduct(@ModelAttribute("product") @Valid Product product, BindingResult bindingResult){
        if (bindingResult.hasErrors()){
            return "employee/product/add";
        }
        return productService.create(product) > 0 ? "index" : "errors/product";
    }

    @GetMapping("/{id}")
    public String openProduct(@PathVariable("id") Integer id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        return "product";
    }

    @GetMapping("/update/{id}")
    public String openUpdateProduct(@PathVariable("id") Integer id, Model model){
        Product product = productService.findById(id);
        model.addAttribute("product", product);
        model.addAttribute("categoryList", categoryService.findAll());
        return "employee/product/update_product";
    }

    @PutMapping("/update")
    public String updateProduct(@ModelAttribute("product") Product product){
        productService.update(product);
        jmsService.sendMessage();
        return "redirect:/product/update/" + product.getId();
    }

    @GetMapping("/delete/{id}")
    public String openDeletePage(@PathVariable("id") Integer id, Model model){
        model.addAttribute("product", productService.findById(id));
        return "employee/product/delete-product";
    }

    @DeleteMapping("/delete")
    public String deletePage(@ModelAttribute("product") Product product){
        productService.delete(product);
        jmsService.sendMessage();
        return "redirect:/catalog";
    }
}
