package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tampashev.shop.services.CommonService;
import ru.tampashev.shop.services.JmsService;

@Controller
@RequestMapping("/")
public class HomeController {

    @Autowired
    private JmsService jmsService;

    @Autowired
    private CommonService commonService;

    @GetMapping
    public String showHomePage(Model model) {
        model.addAttribute("user", commonService.getAuthorisedUser());
        return "index";
    }

    @GetMapping("message")
    public String sendMessage(){
        jmsService.sendMessage();
        return "redirect:/";
    }
}
