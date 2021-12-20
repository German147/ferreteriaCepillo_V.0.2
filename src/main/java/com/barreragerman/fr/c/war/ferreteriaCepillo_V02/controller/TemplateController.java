package com.barreragerman.fr.c.war.ferreteriaCepillo_V02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/api/v2")
public class TemplateController {

    @GetMapping("login")
    public String getLoginView(){
        return "login";
    }

    @GetMapping("clientes")
    public String getClienteview(){
        return "clientes";
    }

    @GetMapping("menu")
    public String getMenu(){
        return "menu";
    }

    @PostMapping("salir")
    public String salirMenu(){
        return "salir";
    }

    @PostMapping("inicio")
    public String inicio(){
        return "inicio";
    }

}
