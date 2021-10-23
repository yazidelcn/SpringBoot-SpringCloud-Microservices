package com.elcnyazid.billingservice;

import com.elcnyazid.billingservice.entities.Bill;
import com.elcnyazid.billingservice.entities.ProductItem;
import com.elcnyazid.billingservice.feign.CustomerRestClient;
import com.elcnyazid.billingservice.feign.ProductRestClient;
import com.elcnyazid.billingservice.model.Customer;
import com.elcnyazid.billingservice.model.Product;
import com.elcnyazid.billingservice.repositories.BillRepository;
import com.elcnyazid.billingservice.repositories.ProductItemRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.data.domain.Example;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.hateoas.PagedModel;

import java.util.Date;
import java.util.List;
import java.util.Optional;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);

	}
	@Bean
	CommandLineRunner start(CustomerRestClient customerRestClient, ProductRestClient productRestClient,
							ProductItemRepository productItemRepository, BillRepository billRepository ){
		return args -> {
			Customer customer = customerRestClient.getCustomerById(1L);
			PagedModel<Product> products = productRestClient.findAll();
			System.out.println(customer.getId() + " " + customer.getName());
			products.forEach(product -> System.out.println(product.getName()));
			Bill bill = new Bill();
			bill.setCustomerId(customer.getId());
			bill.setBillingDate(new Date());
			bill.setCustomer(customer);
			billRepository.save(bill);
			products.forEach(product -> {
				ProductItem p = new ProductItem();
				p.setPrice(product.getPrice());
				p.setProductId(product.getId());
				p.setQuantity(product.getQuantity());
				p.setPrice(product.getPrice());
				p.setBill(bill);
				productItemRepository.save(p);
				//bill.getProductItemList().add(p);
			});
			System.out.println(billRepository.findById(1L).get());
			System.out.println(productItemRepository.findByBillId(1L));
		};
	}

}
