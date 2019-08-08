package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tampashev.shop.dto.RegistrationForm;
import ru.tampashev.shop.dto.User;
import ru.tampashev.shop.services.RegistrationService;
import ru.tampashev.shop.services.UserService;
import ru.tampashev.shop.transfer.RequestTransfer;

@Controller
@RequestMapping("user")
public class UserController {

    @Autowired
    private UserService userService;

    @Autowired
    private RegistrationService registrationService;

    @GetMapping("/authorization")
    public String openPage(Model model) {
        User user = new User();
        model.addAttribute("user", user);
        return "/user/authorization";
    }

    /*@PostMapping("/authorization")
    public String addUser(@ModelAttribute("user") User user){
        if (userService.authorize(user))
            return "/index";
        return "/user/authorization";
    }*/


    @GetMapping("/registration")
    public String openRegistration(){
        return "registration";
    }

    @PostMapping("/registration")
    public void doRegistration(@RequestBody User user){
        System.out.println(user.getLastName());
        System.out.println(user.getAddress().getCountry());
    }


    /*@GetMapping("/registration")
    public String openRegistration(Model model){
        RegistrationForm registrationForm = new RegistrationForm();
        model.addAttribute("registrationForm", registrationForm);
        return "registration";
    }

    @PostMapping("/registration")
    public String doRegistration(@ModelAttribute("registrationForm") RegistrationForm registrationForm){
        if (registrationService.doRegistration(registrationForm))
            return "redirect:/";
        return "/registration";
    }*/
}
