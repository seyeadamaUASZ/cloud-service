package com.billing.web;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import com.billing.interfaces.BillRepository;
import com.billing.interfaces.CustomerService;
import com.billing.interfaces.InventoryService;
import com.billing.interfaces.ProductItemRepository;
import com.billing.models.Bill;

@RestController
public class BillRestController {
	
	@Autowired
	private BillRepository billRepository;
	@Autowired
	private ProductItemRepository productItemRepository;
	@Autowired
	private CustomerService customerService;
	@Autowired
	private InventoryService inventoryService;
	
	@GetMapping("fullBill/{id}")
	public Bill getBill(@PathVariable Long id) {
		Bill bill=billRepository.findById(id).get();
		bill.setCustomer(customerService.findCustomerById(bill.getCustomerId()));
		bill.getProductItems().forEach(pi->{
			pi.setProduct(inventoryService.findProductById(pi.getProductId()));
		});
		return bill;
	}
}
