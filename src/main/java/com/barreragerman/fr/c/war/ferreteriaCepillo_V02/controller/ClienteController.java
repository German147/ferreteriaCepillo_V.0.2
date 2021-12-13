package com.barreragerman.fr.c.war.ferreteriaCepillo_V02.controller;

import com.barreragerman.fr.c.war.ferreteriaCepillo_V02.entity.Cliente;
import com.barreragerman.fr.c.war.ferreteriaCepillo_V02.service.ClienteService;
import org.apache.logging.log4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("api/v1/cliente")
public class ClienteController {


    @Autowired
    private ClienteService clienteService;

    @GetMapping
    public @ResponseBody
    List<Cliente> findAll() {
        System.out.println("findAllClientes");
        return clienteService.findAll();
    }
    //localhost:8080/cliente/2
    @GetMapping("/{id}")
    // @PreAuthorize("hasAnyRole('ROLE_ADMIN','ROLE_ADMINTRAINEE')")
    public @ResponseBody
    Cliente findById(@PathVariable("id") Integer id) {
        return clienteService.findById(id);
    }
    @PostMapping
    //this @PreAuthorize anotations is to control what ROLES or PERMISSSIONS can access to these services
    // @PreAuthorize("hasAuthority('paciente:write')")
    public @ResponseBody
    Cliente save(@RequestBody Cliente cliente) {
        return clienteService.save(cliente);
    }

    @PutMapping("/{id}")
    // @PreAuthorize("hasAuthority('paciente:write')")
    public @ResponseBody Cliente update(@PathVariable("id") Integer id,
                                         @RequestBody Cliente paciente) {
        return clienteService.update(paciente, id);
    }

    @DeleteMapping("/{id}")
    // @PreAuthorize("hasAuthority('paciente:write')")
    public ResponseEntity<Object> eliminar(@PathVariable("id") Integer id) throws Exception{
        clienteService.deleteById(id);
        return new ResponseEntity<Object>(HttpStatus.OK);
    }


}
