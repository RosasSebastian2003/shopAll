package com.shopall.demo.store.cliente;

//Componentes de Spring
import org.springframework.stereotype.Component;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

//Compo

@Component
public class ClienteService {
    @Autowired
    private final ClienteRepository clienteRepository;

    public ClienteService(ClienteRepository clienteRepository) {
        this.clienteRepository = clienteRepository;
    }

    //GET
    public List<Cliente> getClientes() {
        return clienteRepository.findAll();
    }

    //POST
    public void addCliente(Cliente cliente){
        clienteRepository.save(cliente);
    }

    //DELETE
    public void deleteCliente(Long id) {
        boolean exists = clienteRepository.existsById(id);

        if(!exists) {
            throw new IllegalStateException("El id: " + id + " no existe");
        }

        clienteRepository.deleteById(id);
    }

}
