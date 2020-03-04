package com.example.demo;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.example.demo.interfaces.CustomerRepository;
import com.example.demo.models.Customer;

@SpringBootApplication
public class CustomerServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(CustomerServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(CustomerRepository customerRepository,RepositoryRestConfiguration configuration) {
		return args->{
			configuration.exposeIdsFor(Customer.class);
		   customerRepository.save(new Customer("ENSET", "contact@ENSET.com"));	
		   customerRepository.save(new Customer("Orange", "contact@Orange.com"));
		   customerRepository.save(new Customer("Free", "contact@Free.com"));
		   customerRepository.findAll().forEach(System.out::println);
		};
	}

}
