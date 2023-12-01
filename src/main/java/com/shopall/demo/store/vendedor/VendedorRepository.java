package com.shopall.demo.store.vendedor;

import java.util.Optional;
import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import com.shopall.demo.store.cliente.Cliente;

@Repository
public interface VendedorRepository extends JpaRepository<Vendedor, Long>{
    Optional<Vendedor> findVendedorById(Long id);
    Optional<Vendedor> findVendedorByNumTel(int num_telefono);
    
    public List<Vendedor> findByCliente(Cliente cliente);
}