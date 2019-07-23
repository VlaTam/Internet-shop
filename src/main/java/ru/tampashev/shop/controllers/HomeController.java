package ru.tampashev.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class HomeController {

    @RequestMapping({"/", "/home"})
    public String showHomePage(String model){
        model = "Hello, I'm Vladimir Tampashev - creator of the online store!";
        return "home";
    }
}
