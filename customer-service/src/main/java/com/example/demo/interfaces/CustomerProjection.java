package com.example.demo.interfaces;

import org.springframework.data.rest.core.config.Projection;

import com.example.demo.models.Customer;

@Projection(name="P1",types=Customer.class)
public interface CustomerProjection {
  public Long getId();
  public String getName();
}
