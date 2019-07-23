package ru.tampashev.shop.config;

import org.apache.commons.dbcp2.BasicDataSource;
import org.hibernate.cfg.Environment;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;
import org.springframework.orm.hibernate5.HibernateTransactionManager;
import org.springframework.orm.hibernate5.LocalSessionFactoryBean;
import org.springframework.transaction.annotation.EnableTransactionManagement;

import java.util.Properties;

@Configuration
@EnableTransactionManagement
@PropertySource("classpath:properties/hibernate.properties")
public class DatabaseConfig {

    @Value("${hibernate.driver}")
    private String driver;

    @Value("${hibernate.url}")
    private String url;

    @Value("${hibernate.username}")
    private String user;

    @Value("${hibernate.password}")
    private String password;

    @Value("${hibernate.initial.size}")
    private Integer initialSize;

    @Value("${hibernate.max.total}")
    private Integer maxTotal;

    @Value("${hibernate.dialect}")
    private String dialect;

    @Bean
    public BasicDataSource dataSource(){
        BasicDataSource dataSource = new BasicDataSource();

        dataSource.setDriverClassName(driver);
        dataSource.setUrl(url);
        dataSource.setUsername(user);
        dataSource.setPassword(password);
        dataSource.setInitialSize(initialSize);
        dataSource.setMaxTotal(maxTotal);

        return dataSource;
    }

    @Bean
    public LocalSessionFactoryBean sessionFactory() {
        LocalSessionFactoryBean sessionFactory = new LocalSessionFactoryBean();
        sessionFactory.setDataSource(dataSource());
        sessionFactory.setPackagesToScan("ru.tampashev.shop.entities");

        Properties hibernateProperties = new Properties();
        hibernateProperties.setProperty(Environment.DIALECT, dialect);

        sessionFactory.setHibernateProperties(hibernateProperties);
        return sessionFactory;
    }

    @Bean
    public HibernateTransactionManager transactionManager(){
        HibernateTransactionManager transactionManager = new HibernateTransactionManager();
        transactionManager.setSessionFactory(sessionFactory().getObject());
        return transactionManager;
    }
}
