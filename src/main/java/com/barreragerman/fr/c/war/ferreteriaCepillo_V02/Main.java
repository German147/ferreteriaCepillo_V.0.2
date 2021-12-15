package com.barreragerman.fr.c.war.ferreteriaCepillo_V02;

import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.context.annotation.Bean;
import org.springframework.orm.jpa.JpaVendorAdapter;
import org.springframework.orm.jpa.LocalContainerEntityManagerFactoryBean;
import org.springframework.orm.jpa.vendor.HibernateJpaVendorAdapter;

import java.util.Properties;

@Log4j2
@EntityScan(basePackages = {"com.barreragerman.fr.c.war.ferreteriaCepillo_V02.entity"})  // scan JPA entities
@SpringBootApplication
public class Main {

    public static void main(String[] args) {
        System.setProperty("java.awt.headless", "false");
        SpringApplication.run(Main.class, args);
    }

    @Bean
    public Properties dbProperties(Properties prop) {

        Properties properties = new Properties();
        properties.setProperty("hibernate.dialect", "org.hibernate.dialect.PostgreSQLDialect");
        properties.setProperty("hibernate.hbm2ddl.auto", "update");//create-drop//create//auto
        properties.setProperty("spring.jpa.show-sql", "true");

        return properties;
    }

}
