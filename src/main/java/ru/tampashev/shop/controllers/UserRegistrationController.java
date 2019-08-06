package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tampashev.shop.dto.RegistrationForm;
import ru.tampashev.shop.services.RegistrationService;

@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @GetMapping
    public String openRegistration(Model model){
        RegistrationForm registrationForm = new RegistrationForm();
        model.addAttribute("registrationForm", registrationForm);
        return "registration";
    }

    @PostMapping
    public String doRegistration(@ModelAttribute("registrationForm") RegistrationForm registrationForm){
        if (registrationService.doRegistration(registrationForm))
            return "redirect:/";
        return "/registration";
    }
}
