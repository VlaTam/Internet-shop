package ru.tampashev.shop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Import;

@Configuration
@ComponentScan(basePackages = { "ru.tampashev.shop.entities",
                                "ru.tampashev.shop.dao",
                                "ru.tampashev.shop.converters",
                                "ru.tampashev.shop.services",
                                "ru.tampashev.shop.controllers"})
@Import({DatabaseConfig.class})
@ComponentScan("ru.tampashev.shop")
public class ApplicationConfig {

}
