package ru.tampashev.shop.controllers;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import ru.tampashev.shop.dto.Address;
import ru.tampashev.shop.services.AddressService;

@Controller
@RequestMapping("address")
public class AddressController {

    @Autowired
    private AddressService addressService;

    @GetMapping("/add")
    public String openPage(Model model){
        Address address = new Address();
        model.addAttribute("address", address);
        return "/customer/add_address";
    }

    @PostMapping("/add")
    public String addAddress(@ModelAttribute("address") Address address){
        addressService.create(address);
        return "redirect:/index";
    }
}
