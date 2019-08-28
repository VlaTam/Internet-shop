package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tampashev.shop.services.StatisticsService;

@Controller
@RequestMapping("statistics")
public class StatisticsController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/products")
    public String openTopTenProducts(Model model){
        model.addAttribute("topTenProducts", statisticsService.getTopTenProducts());
        return "employee/statistics/top_products";
    }

    @GetMapping("/users")
    public String openTopTenUsers(Model model){
        model.addAttribute("topTenUsers", statisticsService.getTopTenUsers());
        return "employee/statistics/top_users";
    }

    @GetMapping("/profit")
    public String openProfit(Model model){
        model.addAttribute("profitForWeek", statisticsService.getProfitLastWeek());
        model.addAttribute("profitForMonth", statisticsService.getProfitLastMonth());
        return "employee/statistics/profit";
    }
}
