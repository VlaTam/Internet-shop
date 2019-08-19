package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tampashev.shop.dto.User;
import ru.tampashev.shop.services.UserService;

@Controller
@RequestMapping("user")
//@SessionAttributes(names = "user", types = User.class)
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
        return "redirect:/";
    }

    @GetMapping("/login")
    public String openLogin() {
        return "user/login";
    }

    @GetMapping("/logout")
    public String openLogout() {
        return "redirect:/";
    }

    @GetMapping("/registration")
    public String openRegistration(Model model){
        model.addAttribute("user", new User());
        return "registration";
    }

    @PostMapping("/registration")
    public String register(@ModelAttribute("user") User user) {
        return userService.create(user) > 0 ? "redirect:/" : "/errors/register";
    }
}
