package com.elcnyazid.billingservice.feign;

import com.elcnyazid.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;


@FeignClient("INVENTORY-SERVICE")
public interface ProductRestClient {
    @GetMapping("/products")
    PagedModel<Product> findAll(/*@RequestParam(name="page") int page, @RequestParam(name = "size") int size*/);
    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable Long id);
}
