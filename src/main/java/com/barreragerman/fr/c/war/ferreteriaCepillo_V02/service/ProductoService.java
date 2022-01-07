package com.barreragerman.fr.c.war.ferreteriaCepillo_V02.service;

import com.barreragerman.fr.c.war.ferreteriaCepillo_V02.entity.Producto;

import java.util.List;

public interface ProductoService {

    List<Producto> findAll();
    Producto findById(Integer id);
    Producto save(Producto producto);
    Producto update(Producto producto,Integer id);
    void deleteById(Integer id);
}
