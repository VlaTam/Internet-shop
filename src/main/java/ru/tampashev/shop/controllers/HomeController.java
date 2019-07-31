package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.services.ProductService;

import java.util.Collection;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private ProductService productService;

    @GetMapping
    public String showHomePage(){
        return "index";
    }

    @GetMapping("catalog")
    public String openCatalog(Model model){
        Collection<Product> products = productService.findAll();
        model.addAttribute("products", products);
        return "catalog";
    }
}
