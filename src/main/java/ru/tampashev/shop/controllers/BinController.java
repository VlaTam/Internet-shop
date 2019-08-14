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

    @GetMapping("/add")
    public String addProduct(HttpServletRequest request, HttpServletResponse response){
        Cookie[] cookies = request.getCookies();
        for (Cookie cookie : cookies) {
            System.out.println(cookie.getName() + "     " + cookie.getValue());
            /*if (cookie.getName().equals("product")) {
                System.out.println(cookie.getName() + " " + cookie.getValue());
            }
            if (cookie.getName().equals("quantity")){
                System.out.println(cookie.getName() + " " + cookie.getValue());
            }*/
        }

        //response.addCookie(new Cookie());
        return "redirect:/catalog";
    }
}
