package com.barreragerman.fr.c.war.ferreteriaCepillo_V02;

import com.barreragerman.fr.c.war.ferreteriaCepillo_V02.dbConfig.DBConfig;
import lombok.extern.log4j.Log4j2;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.boot.autoconfigure.domain.EntityScan;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.context.annotation.Bean;

import java.util.Properties;

@EnableConfigurationProperties(DBConfig.class)
@SpringBootApplication
public class Cepillo {

    public static void main(String[] args) {
        SpringApplication.run(Cepillo.class, args);
    }


}
