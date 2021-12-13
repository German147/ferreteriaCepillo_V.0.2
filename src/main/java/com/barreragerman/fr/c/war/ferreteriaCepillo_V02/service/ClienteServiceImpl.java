package com.barreragerman.fr.c.war.ferreteriaCepillo_V02.service;

import com.barreragerman.fr.c.war.ferreteriaCepillo_V02.entity.Cliente;
import com.barreragerman.fr.c.war.ferreteriaCepillo_V02.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class ClienteServiceImpl implements ClienteService{

    @Autowired
    private ClienteRepository clienteRepository;


    @Override
    public List<Cliente> findAll() {
        return clienteRepository.findAll();
    }

    @Override
    public Cliente findById(Integer id) {
        Optional<Cliente> clienteOptional = clienteRepository.findById(id);
        return clienteOptional.orElseGet(Cliente::new);
    }

    @Override
    public Cliente save(Cliente cliente) {
        return clienteRepository.save(cliente);
    }

    @Override
    public Cliente update(Cliente cliente, Integer id) {
        Cliente clienteUpdate = new Cliente();
        if (id != null && id > 0) {
            Optional<Cliente> optionalCliente = clienteRepository.findById(id);
            if (optionalCliente.isPresent()) {
                cliente.setId(id);
                clienteUpdate = clienteRepository.save(cliente);
            }
        } else {

        }
        return clienteUpdate;
    }

    @Override
    public void deleteById(Integer id) {
        boolean exists = clienteRepository.existsById(id);
        if (!exists) {
            throw new IllegalStateException("El cliente " + id + " no existe en nuestra base de datos");
        }
        clienteRepository.deleteById(id);
    }

}
