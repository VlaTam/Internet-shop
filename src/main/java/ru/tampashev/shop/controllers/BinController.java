package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tampashev.shop.services.BinService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

@Controller
@RequestMapping("bin")
public class BinController {

    @Autowired
    private BinService binService;

    @GetMapping
    public String openBin(){
        return "bin";
    }

    @PostMapping("/add")
    public String addToBin(HttpSession session, HttpServletRequest request){
        boolean result = binService.add(session, request);
        return result ? "redirect:/catalog" : "redirect:/product?message=Product has not added into the bin";
    }
}
