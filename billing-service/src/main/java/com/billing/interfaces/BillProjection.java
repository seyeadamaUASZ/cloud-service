package com.billing.interfaces;

import java.util.Collection;
import java.util.Date;

import org.springframework.data.rest.core.config.Projection;

import com.billing.models.Bill;
import com.billing.models.ProductItem;


@Projection(name="fullBill",types=Bill.class)
public interface BillProjection {
	public Long getId();
	public Date getBillingDate();
	public Long getCustomerId();
	public Collection<ProductItem> getProductItems();

}
