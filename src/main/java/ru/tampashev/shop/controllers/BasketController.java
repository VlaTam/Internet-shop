package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.services.BasketService;

@Controller
@RequestMapping("basket")
public class BasketController {

    @Autowired
    private BasketService binService;

    @GetMapping
    public String openBin(Model model){
        model.addAttribute("product", new Product());
        return "basket";
    }

    @PostMapping("/add")
    public String addToBin(){
        return binService.add() ? "redirect:/catalog" : "redirect:/product?message=Product has not added into the bin";
    }

    @DeleteMapping("/delete")
    public String deletePurchase(@ModelAttribute("product") Product product){
        return binService.delete(product) ? "redirect:/basket" : "redirect:/basket?message=Product has not deleted";
    }
}
