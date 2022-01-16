//package com.barreragerman.fr.c.war.ferreteriaCepillo_V02.util;
//
//import com.barreragerman.fr.c.war.ferreteriaCepillo_V02.entity.Cliente;
//import com.barreragerman.fr.c.war.ferreteriaCepillo_V02.service.ClienteService;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.boot.CommandLineRunner;
//import org.springframework.context.annotation.Bean;
//import org.springframework.context.annotation.Configuration;
//
//@Configuration
//public class SeedClientToDB {
//
//    @Autowired
//    private ClienteService clienteService;
//    public SeedClientToDB(ClienteService clienteService) {
//        this.clienteService = clienteService;
//    }
//
//    @Bean
//    CommandLineRunner clients(ClienteService clienteService) {
//        return args -> {
//
//            clienteService.save(new Cliente(1, "german", "barrera", "colTirolesa", "45.754.451", "12345678"));
//            clienteService.save(new Cliente(2, "Evange", "Cecato", "ColTirolesa", "24.568.123", "17545875"));
//        };
//
//    }
//}
