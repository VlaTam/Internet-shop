package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;
import ru.tampashev.shop.dto.Delivery;
import ru.tampashev.shop.dto.Order;
import ru.tampashev.shop.dto.OrderStatus;
import ru.tampashev.shop.dto.Payment;
import ru.tampashev.shop.services.CommonService;
import ru.tampashev.shop.services.DeliveryService;
import ru.tampashev.shop.services.OrderService;
import ru.tampashev.shop.services.PaymentService;

import java.util.HashSet;

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

    @GetMapping("/edit/{id}")
    public String openOrder(@PathVariable("id") Integer id, Model model){
        model.addAttribute("paymentList", paymentService.findAll());
        model.addAttribute("deliveryList", deliveryService.findAll());
        model.addAttribute(orderService.findById(id));
        return "employee/order/order_status";
    }

    @PutMapping("/edit")
    public String changeOrderStatus(@ModelAttribute("order") Order order){
        Order existedOrder = orderService.findById(order.getId());

        Payment payment = new Payment();
        payment.setMethod(order.getPayment().getMethod());
        payment.setPaymentStatus(order.getPayment().getPaymentStatus());
        payment.setId(paymentService.find(payment));

        Delivery delivery = new Delivery();
        delivery.setMethod(order.getDelivery().getMethod());
        delivery.setDeliveryStatus(order.getDelivery().getDeliveryStatus());
        delivery.setId(deliveryService.find(delivery));

        existedOrder.setPayment(payment);
        existedOrder.setDelivery(delivery);
        existedOrder.setOrderProducts(new HashSet<>());

        orderService.update(existedOrder);
        return "redirect:/order/edit/" + order.getId();
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
        model.addAttribute("orderStatus", new OrderStatus());
        return "employee/order/show_orders";
    }
}
