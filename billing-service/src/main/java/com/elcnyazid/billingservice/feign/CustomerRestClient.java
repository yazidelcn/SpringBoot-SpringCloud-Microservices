package com.elcnyazid.billingservice.feign;

import org.springframework.cloud.openfeign.FeignClient;

@FeignClient(name = "CUSTOMER-SERVICE")
public interface CustomerRestClient {

}
