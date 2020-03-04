package com.billing.models;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToOne;
import javax.persistence.Transient;

import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonProperty.Access;

@Entity
public class ProductItem {
	@Id
	@GeneratedValue(strategy = GenerationType.IDENTITY)
  private Long id;
  private double price;
  private Long productId;
  
  @Transient
  private Product product;
  
  
  public Product getProduct() {
	return product;
}
public void setProduct(Product product) {
	this.product = product;
}
private int quantity;
  @ManyToOne
  @JsonProperty(access = Access.WRITE_ONLY)
  private Bill bill;
	public Long getId() {
		return id;
	}
public void setId(Long id) {
	this.id = id;
}
public double getPrice() {
	return price;
}
public void setPrice(double price) {
	this.price = price;
}
public Long getProductId() {
	return productId;
}
public void setProductId(Long productId) {
	this.productId = productId;
}
public int getQuantity() {
	return quantity;
}
public void setQuantity(int quantity) {
	this.quantity = quantity;
}
public Bill getBill() {
	return bill;
}
public void setBill(Bill bill) {
	this.bill = bill;
}
public ProductItem(double price, Long productId, int quantity) {
	super();
	this.price = price;
	this.productId = productId;
	this.quantity = quantity;
}
public ProductItem() {
	super();
	// TODO Auto-generated constructor stub
}
@Override
public String toString() {
	return "ProductItem [id=" + id + ", price=" + price + ", productId=" + productId + ", quantity=" + quantity
			+ ", bill=" + bill + "]";
}
public ProductItem(double price, Long productId, int quantity, Bill bill) {
	super();
	this.price = price;
	this.productId = productId;
	this.quantity = quantity;
	this.bill = bill;
}


  
  
  
  
}
