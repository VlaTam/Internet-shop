package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tampashev.shop.dto.Order;
import ru.tampashev.shop.services.CommonService;
import ru.tampashev.shop.services.DeliveryService;
import ru.tampashev.shop.services.PaymentService;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private CommonService commonService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DeliveryService deliveryService;

    @GetMapping("/add")
    public String openAddOrder(Model model){
        model.addAttribute("order", new Order());
        model.addAttribute("paymentList", paymentService.findAll());
        model.addAttribute("deliveryList", deliveryService.findAll());
        model.addAttribute("user", commonService.getAuthorisedUser());
        return "user/add_order";
    }
}
