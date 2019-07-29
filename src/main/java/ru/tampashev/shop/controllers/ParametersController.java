package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tampashev.shop.dto.Parameters;
import ru.tampashev.shop.services.ParametersService;

@Controller
@RequestMapping("/parameters")
public class ParametersController {

    @Autowired
    private ParametersService parametersService;

    @GetMapping
    public String openPage(Model model){
        Parameters parameters = new Parameters();
        model.addAttribute("parameters", parameters);
        return "employee/parameters";
    }

    @PostMapping
    public String addParameters(@ModelAttribute("parameters") Parameters parameters){
        parametersService.create(parameters);
        return "index";
    }
}
