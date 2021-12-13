package com.barreragerman.fr.c.war.ferreteriaCepillo_V02.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class TemplateController {

    @GetMapping("login")
    public String getLoginView(){
        return "login";
    }

    @GetMapping("clientes")
    public String getClienteview(){
        return "clientes";
    }


}
