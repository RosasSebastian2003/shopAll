package com.shopall.demo.store.vendedor;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import java.util.List;

@RestController
@RequestMapping(path = "api/vendedor")
public class VendedorController {
    @Autowired
    private final VendedorService vendedorService;
    
    public VendedorController(VendedorService vendedorService) {
        this.vendedorService = vendedorService;
    }

    @GetMapping
    public List<Vendedor> obtainVendedores() {
        return vendedorService.getVendedores();
    }

    //http://localhost:8080/api/vendedor?id_cliente=123 
    @PostMapping
    public void registerVendedor(@RequestBody Vendedor vendedor, @RequestParam Long id_cliente) {
        Vendedor newVendedor = vendedorService.addVendedor(vendedor);
        vendedorService.setCliente(newVendedor.getId(), id_cliente);
    }

    @DeleteMapping
    public void deleteVendedor(Long id) {
        vendedorService.deleteVendedor(id);
    }
}
