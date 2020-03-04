package com.billing;

import java.util.Date;

import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.cloud.openfeign.EnableFeignClients;
import org.springframework.context.annotation.Bean;
import org.springframework.hateoas.PagedModel;

import com.billing.interfaces.BillRepository;
import com.billing.interfaces.CustomerService;
import com.billing.interfaces.InventoryService;
import com.billing.interfaces.ProductItemRepository;
import com.billing.models.Bill;
import com.billing.models.Customer;
import com.billing.models.Product;
import com.billing.models.ProductItem;

@SpringBootApplication
@EnableFeignClients
public class BillingServiceApplication {

	public static void main(String[] args) {
		SpringApplication.run(BillingServiceApplication.class, args);
	}
	
	@Bean
	CommandLineRunner start(BillRepository repo,ProductItemRepository productItemRepository,CustomerService customerService,InventoryService inventoryService) {
	   return args->{
		   Customer c = customerService.findCustomerById(1L);
		   System.out.println("********************");
		   System.out.println("Name = "+c.getName());
		   System.out.println("Id = "+c.getId());
		   System.out.println("********************");
		   Bill bill1 = repo.save(new Bill(new Date(), c.getId(), null));
		   
		   /*PagedModel<Product> products = inventoryService.findAllProducts();
		   products.getContent().forEach(p->{
			   productItemRepository.save(new ProductItem(p.getPrice(),p.getId(), 30, bill1)); 
		   });*/	 
	
	   };
	}
	

}
