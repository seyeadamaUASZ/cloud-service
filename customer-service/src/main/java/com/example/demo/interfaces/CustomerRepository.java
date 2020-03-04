package com.example.demo.interfaces;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;

import com.example.demo.models.Customer;

@RepositoryRestResource
public interface CustomerRepository  extends JpaRepository<Customer,Long>{

}
