package com.barreragerman.fr.c.war.ferreteriaCepillo_V02.service.ServiceImplement;

import com.barreragerman.fr.c.war.ferreteriaCepillo_V02.entity.Producto;
import com.barreragerman.fr.c.war.ferreteriaCepillo_V02.exceptions.ProductoNotFoundException;
import com.barreragerman.fr.c.war.ferreteriaCepillo_V02.repository.ProductoRepository;
import com.barreragerman.fr.c.war.ferreteriaCepillo_V02.service.ProductoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
@Service
public class ProductoServiceImpl implements ProductoService {

    @Autowired
    private ProductoRepository productoRepository;

    @Override
    public List<Producto> findAll() {
        return productoRepository.findAll();
    }

    @Override
    public Producto findById(Integer id) {
        Optional<Producto> productoOptional = productoRepository.findById(id);
        return productoOptional.orElseGet(Producto::new);
    }

    @Override
    public Producto save(Producto producto) {
        return productoRepository.save(producto);
    }

    @Override
    public Producto update(Producto producto, Integer id) {
        Producto productoUpdate = new Producto();
        if (id != null && id > 0 ){
            Optional<Producto> optionalProducto = productoRepository.findById(id);
            if (optionalProducto.isPresent()){
                producto.setId(id);
                productoUpdate = productoRepository.save(producto);
            }
        }else{
            throw new ProductoNotFoundException("El Numero de Id del producto No Existe");
        }
        return productoUpdate;

    }

    @Override
    public void deleteById(Integer id) {

        boolean exists = productoRepository.existsById(id);
        if (!exists) {
            throw new ProductoNotFoundException("El producto con el Id " + id + " no existe en nuestra base de datos");
        }
        productoRepository.deleteById(id);
    }
}
