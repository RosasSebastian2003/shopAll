package com.shopall.demo.store.cliente;

import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.Bean;
import org.springframework.boot.CommandLineRunner;
import java.util.List;

@Configuration
public class ClienteConfig {
    @Bean
    CommandLineRunner commandLineRunner(ClienteRepository repository) {
        return args -> {
            Cliente cliente1 = new Cliente (
                "Juan Perez",
                1234567890
            );

            Cliente cliente2 = new Cliente (
                "Armando Hoyos",
                2983765
            );

            repository.saveAll(
                List.of(cliente1, cliente2)
            );
            
        };
    }
}
