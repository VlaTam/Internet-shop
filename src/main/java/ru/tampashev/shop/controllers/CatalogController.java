package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tampashev.shop.dto.Parameters;
import ru.tampashev.shop.services.ParametersService;
import ru.tampashev.shop.services.ProductService;

@Controller
@RequestMapping("catalog")
public class CatalogController {

    @Autowired
    private ProductService productService;

    @Autowired
    private ParametersService parametersService;

    @GetMapping
    public String openCatalog(Model model){
        model.addAttribute("products", productService.findAll());
        model.addAttribute("parametersList", parametersService.findAll());
        model.addAttribute("parameters", new Parameters());
        return "catalog";
    }

    @GetMapping("/filtered")
    public String openFilteredCatalog(@ModelAttribute("parameters") Parameters parameters, Model model){
        model.addAttribute("products", productService.findByParameters(parameters));
        model.addAttribute("pList", parametersService.findAll());
        //model.addAttribute("parametersList", parametersService.findAll());
        model.addAttribute("parameters", parameters);
        return "catalog";
    }
}
