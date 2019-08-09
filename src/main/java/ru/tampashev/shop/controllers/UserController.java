package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tampashev.shop.dto.Address;
import ru.tampashev.shop.dto.User;
import ru.tampashev.shop.services.UserService;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    /*@GetMapping("/authorization")
    public String openPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "/user/authorization";
    }

    @PostMapping("/authorization")
    public String addUser(@ModelAttribute("user") User user){
        if (userService.authorize(user))
            return "/index";
        return "/user/authorization";
    }*/

    @GetMapping("/registration")
    public String openRegistration(Model model){
        User user = new User();
        model.addAttribute("user", user);
        Address address = new Address();
        model.addAttribute("address", address);
        return "registration";
    }

    @PostMapping("/registration")
    public String doRegistration(@ModelAttribute("user") User user){
        userService.register(user);
        return "redirect:/";
    }
}
