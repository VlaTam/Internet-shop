package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tampashev.shop.dto.RegistrationForm;
import ru.tampashev.shop.dto.User;
import ru.tampashev.shop.services.RegistrationService;
import ru.tampashev.shop.services.UserService;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/authorization")
    public String openPage(Model model){
        User user = new User();
        model.addAttribute("user", user);
        return "/customer/authorization";
    }

    @PostMapping("/authorization")
    public String addUser(@ModelAttribute("user") User user){
        userService.create(user);
        return "redirect:/address/add";
    }

    @GetMapping("/registration")
    public String openRegistration(Model model){
        RegistrationForm registrationForm = new RegistrationForm();
        model.addAttribute("registrationForm", registrationForm);
        return "registration";
    }

    @PostMapping("/registration")
    public String doRegistration(@ModelAttribute("registrationForm") RegistrationForm registrationForm){
        System.out.println(registrationForm.getBirthday());
        if (registrationService.doRegistration(registrationForm))
            return "redirect:/";
        return "/registration";
    }
}
