package com.barreragerman.fr.c.war.ferreteriaCepillo_V02.service;

import com.barreragerman.fr.c.war.ferreteriaCepillo_V02.entity.Cliente;

import java.util.List;

public interface ClienteService {

    List<Cliente> findAll();
    Cliente findById(Integer id);
    Cliente save(Cliente cliente);
    Cliente update(Cliente cliente,Integer id);
    void deleteById(Integer id);
}
