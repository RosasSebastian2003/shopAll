package com.shopall.demo.store.cliente;

import org.springframework.web.bind.annotation.*;
import org.springframework.beans.factory.annotation.Autowired;
import java.util.List;

@RestController
@RequestMapping(path = "api/cliente") //http://localhost:8080/api/cliente
public class ClienteController {
    
    //Creamos una instancia de la clase clienteService
    @Autowired
    private final ClienteService clienteService;

    //Inyeccion de la dependencia ClienteService
    public ClienteController(ClienteService clienteService) {
        this.clienteService = clienteService; 
    }

    @GetMapping
    public List<Cliente> obtainClientes() {
        return clienteService.getClientes();
    }

    @PostMapping
    public void registerCliente(@RequestBody Cliente cliente) {
        clienteService.addCliente(cliente);
    }

    @DeleteMapping
    public void deleteCliente(Long id) {
        clienteService.deleteCliente(id);
    }
}
