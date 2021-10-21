package com.elcnyazid.billingservice.feign;

import com.elcnyazid.billingservice.model.Product;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.hateoas.PagedModel;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestParam;


@FeignClient("INVENTORY-SERVICE")
public interface ProductRestClient {
    @GetMapping("/products")
    PagedModel<Product> pageProducts(@RequestParam(value="page") int page, @RequestParam(value = "size") int size);
    @GetMapping("/products/{id}")
    Product getProductById(@PathVariable Long id);
}
