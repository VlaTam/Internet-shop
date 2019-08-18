package ru.tampashev.shop.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.Cookie;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

@Controller
@RequestMapping("bin")
public class BinController {

    private int i = 0;

    @GetMapping("/add")
    public String addProduct(HttpServletResponse response){
        i++;
        Cookie cookie = new Cookie("bin", "Nokian_wheel " + i);
        cookie.setPath("/");
        cookie.setMaxAge(86400);
        response.addCookie(cookie);
        response.setContentType("text/plain");
        response.setStatus(HttpServletResponse.SC_OK);
        return "redirect:/catalog";
    }
}
