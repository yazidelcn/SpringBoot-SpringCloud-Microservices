package com.elcnyazid.customerservice;

import com.elcnyazid.customerservice.entities.Customer;
import com.elcnyazid.customerservice.repositories.CustomerRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
    @Bean
	CommandLineRunner start(CustomerRepository customerRepository){
		return args -> {
			customerRepository.save(new Customer(null, "Yazid Elcouhen", "elcouhenyazid@gmail.com"));
			customerRepository.save(new Customer(null, "Ted Lasso", "tedlasso@gmail.com"));
			customerRepository.save(new Customer(null, "Stewie Griffen", "stewie@gmail.com"));
			customerRepository.findAll().forEach(customer -> {
				System.out.println(customer.toString());
			});
		};
	}
}
