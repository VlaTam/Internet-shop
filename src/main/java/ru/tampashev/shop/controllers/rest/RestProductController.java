package ru.tampashev.shop.controllers.rest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import ru.tampashev.shop.dto.Product;
import ru.tampashev.shop.services.StatisticsService;

import java.util.List;

@RestController
@RequestMapping("/rest")
public class RestProductController {

    @Autowired
    private StatisticsService statisticsService;

    @GetMapping("/products")
    public List<Product> getTopOfProducts(){
        return statisticsService.getTopTenProducts();
    }
}
