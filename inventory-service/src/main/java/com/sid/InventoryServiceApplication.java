package com.sid;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.data.rest.core.config.RepositoryRestConfiguration;

import com.sid.interfaces.ProductRepository;
import com.sid.models.Product;

@SpringBootApplication
public class InventoryServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(InventoryServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(ProductRepository productRepository,RepositoryRestConfiguration configuration) {
		return args->{
			configuration.exposeIdsFor(Product.class);
			productRepository.save(new Product("ordinateur hp", 1500));
			productRepository.save(new Product("ordinateur accent", 1520));
			productRepository.save(new Product("camera canon", 1500));
			productRepository.findAll().forEach(System.out::println);
		};
	}

}
