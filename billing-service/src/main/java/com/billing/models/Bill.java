package com.billing.models;

import java.util.Collection;
import java.util.Date;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.OneToMany;
import javax.persistence.Transient;

@Entity
public class Bill {
	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private Long id;
	private Date billingDate;
	private Long customerId;
	
	
	public Customer getCustomer() {
		return customer;
	}
	public void setCustomer(Customer customer) {
		this.customer = customer;
	}
	@Transient
	private Customer customer;
	
	@OneToMany(mappedBy = "bill")
	private Collection<ProductItem> productItems;
	public Long getId() {
		return id;
	}
	public void setId(Long id) {
		this.id = id;
	}
	public Date getBillingDate() {
		return billingDate;
	}
	public void setBillingDate(Date billingDate) {
		this.billingDate = billingDate;
	}
	public Long getCustomerId() {
		return customerId;
	}
	public void setCustomerId(Long customerId) {
		this.customerId = customerId;
	}
	public Collection<ProductItem> getProductItems() {
		return productItems;
	}
	public void setProductItems(Collection<ProductItem> productItems) {
		this.productItems = productItems;
	}
	public Bill(Date billingDate, Long customerId) {
		super();
		this.billingDate = billingDate;
		this.customerId = customerId;
	}
	public Bill() {
		super();
		// TODO Auto-generated constructor stub
	}
	@Override
	public String toString() {
		return "Bill [id=" + id + ", billingDate=" + billingDate + ", customerId=" + customerId + ", productItems="
				+ productItems + "]";
	}
	public Bill(Date billingDate, Long customerId, Collection<ProductItem> productItems) {
		super();
		this.billingDate = billingDate;
		this.customerId = customerId;
		this.productItems = productItems;
	}
	
	
	
	
	

}
