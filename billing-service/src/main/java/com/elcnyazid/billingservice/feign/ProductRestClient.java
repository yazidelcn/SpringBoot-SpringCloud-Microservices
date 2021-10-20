package com.elcnyazid.billingservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient("INVENTORY-SERVICE")
public interface ProductRestClient {
}
