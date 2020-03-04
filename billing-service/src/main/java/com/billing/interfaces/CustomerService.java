package com.billing.interfaces;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;

import com.billing.models.Customer;

@FeignClient(name="CUSTOMER-SERVICE")
public interface CustomerService {
	
	@GetMapping("/customers/{id}")
  public Customer findCustomerById(@PathVariable(name="id")Long id);
	
}
