package ru.tampashev.shop.dto;

import org.springframework.stereotype.Component;

@Component
public class Category {

    private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
}
