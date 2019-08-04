package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tampashev.shop.dto.User;
import ru.tampashev.shop.services.UserService;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

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
    public String openRegistration(){
        return "registration";
    }
}
