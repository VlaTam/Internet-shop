package ru.tampashev.shop.test;

import org.junit.Test;
import org.springframework.context.ApplicationContext;
import org.springframework.context.annotation.AnnotationConfigApplicationContext;
import ru.tampashev.shop.config.ApplicationConfig;
import ru.tampashev.shop.config.DatabaseConfig;

public class InternetShopTest {

    @Test
    public void createContext(){
        ApplicationContext context = new AnnotationConfigApplicationContext(DatabaseConfig.class);
    }
}
