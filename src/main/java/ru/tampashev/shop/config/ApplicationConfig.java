package ru.tampashev.shop.config;

import org.springframework.context.annotation.ComponentScan;
import org.springframework.context.annotation.Import;
import org.springframework.web.servlet.support.AbstractAnnotationConfigDispatcherServletInitializer;

@Import(DatabaseConfig.class)
//@ComponentScan(basePackages = {"ru.tampashev.shop.dao", "ru.tampashev.shop.converters", "ru.tampashev.shop.services", "ru.tampashev.shop.controllers"})
public class ApplicationConfig extends AbstractAnnotationConfigDispatcherServletInitializer {

    // для ресурсов
    @Override
    protected Class<?>[] getRootConfigClasses() {
        return new Class<?>[] {RootConfig.class};
    }

    // Тут добавляем конфигурацию, в которой инициализируем ViewResolver
    @Override
    protected Class<?>[] getServletConfigClasses() {
        return new Class<?>[] {WebConfig.class};
    }

    @Override
    protected String[] getServletMappings() {
        return new String[] {"/"};
    }
}
