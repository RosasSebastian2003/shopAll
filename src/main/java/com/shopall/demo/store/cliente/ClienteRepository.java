package com.shopall.demo.store.cliente;

import org.springframework.stereotype.Repository;
import org.springframework.data.jpa.repository.JpaRepository;

import java.util.Optional;

@Repository
public interface ClienteRepository extends JpaRepository<Cliente, Long> {
    Optional<Cliente> findClienteById(Long id); //SELECT * FROM cliente WHERE id = ?
 
}
