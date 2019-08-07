package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tampashev.shop.dto.RegistrationForm;
import ru.tampashev.shop.dto.User;
import ru.tampashev.shop.services.RegistrationService;
import ru.tampashev.shop.services.UserService;
import ru.tampashev.shop.transfer.ResponseTransfer;



@Controller
@RequestMapping("/registration")
public class UserRegistrationController {

    @Autowired
    private RegistrationService registrationService;

    @Autowired
    private UserService userService;

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

    @GetMapping("/authorization")
    public String openAuthorization(){
        /*User user = new User();
        model.addAttribute("user", user);*/
        return "/user/authorization";
    }

    @PostMapping(value = "/authorization", consumes = MediaType.APPLICATION_JSON_VALUE, produces =
            MediaType.APPLICATION_JSON_VALUE)
    @ResponseBody
    @ResponseStatus(HttpStatus.OK)
    public ResponseTransfer authorize(@RequestBody User user){

        return userService.authorize(user);
    }
}
