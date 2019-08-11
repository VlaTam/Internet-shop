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

    @GetMapping(value = "/{id}")
    public String openProfile(@PathVariable Integer id, Model model){
        model.addAttribute("user", userService.findById(id));
        return "user/profile";
    }

    @PutMapping
    public String editProfile(@ModelAttribute("user") User user){
        userService.update(user);
        return "index";
    }

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
        model.addAttribute("user", new User());
        model.addAttribute("address", new Address());
        return "registration";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute("user") User user) {
        return userService.create(user) > 0 ? "redirect:/" : "/errors/register";
    }
}
