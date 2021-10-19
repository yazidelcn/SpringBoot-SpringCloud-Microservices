package com.elcnyazid.inventoryservice;

import com.elcnyazid.inventoryservice.entities.Product;
import com.elcnyazid.inventoryservice.repositories.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	@Bean
	CommandLineRunner run (ProductRepository productRepository){
		return  args -> {
			productRepository.save(new Product(null, "Lenovo Ideapad", 7000, 100));
			productRepository.save(new Product(null, "Redmi Note 10s", 2700, 500));
			productRepository.save(new Product(null, "Playstation 5", 1200, 20));
			productRepository.save(new Product(null, "Iphone 10", 8000, 130));
		};

	}
}
