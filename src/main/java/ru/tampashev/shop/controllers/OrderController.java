package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tampashev.shop.dto.Order;
import ru.tampashev.shop.dto.OrderStatus;

import ru.tampashev.shop.services.*;

@Controller
@RequestMapping("/order")
public class OrderController {

    @Autowired
    private OrderService orderService;

    @Autowired
    private CommonService commonService;

    @Autowired
    private PaymentService paymentService;

    @Autowired
    private DeliveryService deliveryService;

    @Autowired
    private JmsService jmsService;

    @GetMapping("/edit/{id}")
    public String openOrder(@PathVariable("id") Integer id, Model model){
        model.addAttribute("paymentList", paymentService.findAll());
        model.addAttribute("deliveryList", deliveryService.findAll());
        model.addAttribute(orderService.findById(id));
        return "employee/order/order_status";
    }

    @PostMapping("/edit")
    public String changeOrderStatus(@ModelAttribute("order") Order order){
        orderService.changeStatus(order);
        return "redirect:/order/edit/" + order.getId() + "?message=Order has updated";
    }

    @GetMapping("/add")
    public String openAddOrder(Model model){
        model.addAttribute("order", new Order());
        model.addAttribute("paymentList", paymentService.findAll());
        model.addAttribute("deliveryList", deliveryService.findAll());
        model.addAttribute("user", commonService.getAuthorisedUser());
        return "user/add_order";
    }

    @PostMapping("/add")
    public String addOrder(@ModelAttribute("order") Order order){
        orderService.create(order);
        jmsService.sendMessage();
        return "redirect:/";
    }

    @GetMapping("/history")
    public String openOrderHistory(Model model){
        model.addAttribute("orderList", orderService.findUsersOrders());
        return "user/order_history";
    }

    @GetMapping("/manage")
    public String openActiveOrders(Model model){
        model.addAttribute("paymentList", paymentService.findAll());
        model.addAttribute("deliveryList", deliveryService.findAll());
        model.addAttribute("activeOrders", orderService.findActiveOrders());
        model.addAttribute("orderStatus", new OrderStatus());
        return "employee/order/show_orders";
    }

    @GetMapping("/filtered")
    public String openFilteredOrders(@ModelAttribute("orderStatus") OrderStatus orderStatus, Model model){
        model.addAttribute("paymentList", paymentService.findAll());
        model.addAttribute("deliveryList", deliveryService.findAll());
        model.addAttribute("activeOrders", orderService.findByStatus(orderStatus));
        model.addAttribute("orderStatus", orderStatus);
        return "employee/order/show_orders";
    }
}
