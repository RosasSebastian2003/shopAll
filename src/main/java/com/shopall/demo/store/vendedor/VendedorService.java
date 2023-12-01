package com.shopall.demo.store.vendedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import java.util.Optional;
import java.util.List;
import com.shopall.demo.store.cliente.*;

@Component
public class VendedorService {
    @Autowired
    private VendedorRepository vendedorRepository;

    @Autowired
    private ClienteRepository clienteRepository;

    public VendedorService(VendedorRepository vendedorRepository) {
        this.vendedorRepository = vendedorRepository;
    }


    //GET
    public List<Vendedor> getVendedores() {
        return vendedorRepository.findAll();
    }

    //POST
    public Vendedor addVendedor(Vendedor vendedor){
        Optional<Vendedor> vendedorNum = vendedorRepository.findVendedorByNumTel(vendedor.getNum_telefono());

        if(vendedorNum.isPresent()) {
            throw new IllegalStateException("Numero repetido");
        }

        return vendedorRepository.save(vendedor);
    }

    //DELETE    
    public void deleteVendedor(Long id) {
        boolean exists = vendedorRepository.existsById(id);

        if(!exists) {
            throw new IllegalStateException("El id: " + id + " no existe");
        }

        vendedorRepository.deleteById(id);
    }
    
    public void setCliente(Long id_vendedor, Long id_cliente) {
        Vendedor vendedor = vendedorRepository.findById(id_vendedor).orElseThrow(() -> new IllegalStateException("El id: " + id_vendedor + " no existe"));
        Cliente cliente = clienteRepository.findById(id_cliente).orElseThrow(() -> new IllegalStateException("El id: " + id_cliente + " no existe"));

        vendedor.setCliente(cliente);
        vendedorRepository.save(vendedor);
    }
}

